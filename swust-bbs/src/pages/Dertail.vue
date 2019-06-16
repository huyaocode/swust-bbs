<template>
  <div class="page">
    <div class="header">
      <div class="title">
        <h2>{{title}}</h2>
        <table style="margin-top:10px;">
          <tr>
            <td>时间： </td>
            <td>{{time}}</td>
          </tr>
          <tr>
            <td>类型：</td>
            <td>{{type}}</td>
          </tr>
          <tr>
            <td>分类：</td>
            <td>{{categoryText}}</td>
          </tr>
          <tr>
            <td>发布人：</td>
            <td>{{userNickName}}</td>
          </tr>
          <tr>
            <td>联系方式：</td>
            <td>{{telephone}}</td>
          </tr>
        </table>
      </div>
      <div class="right">
        <div class="head-img">
          <router-link :to="userPageUrl">
            <el-image
              style="width: 60px; height: 60px;"
              :src="'http://localhost:8085/' + userHeadImg"
              :fit="'cover'"
            >
            </el-image>
          </router-link>
        </div>

        <div class="right">
          <el-button
            icon="el-icon-star-off"
            @click="star"
            v-if="!stared"
          >收藏</el-button>
          <el-button
            v-else
            icon="el-icon-star-on"
            @click="star"
          >已收藏</el-button>
        </div>
      </div>
    </div>
    <div style="clear: both;"></div>
    <div class="option">
      <el-button
        icon="el-icon-edit"
        v-show="editable"
        @click="edit"
      >编辑</el-button>

      <el-button
        v-show="editable"
        icon="el-icon-delete"
        @click="deleteInfo"
      >删除</el-button>
    </div>
    <div style="clear: both;"></div>
    <div id="content">
    </div>

    <div
      class="imgs"
      v-for="img in imgs"
      :key="img"
    >
      <img
        :src="img"
        alt=""
      >
    </div>
  </div>
</template>

<script>
import Header from '../components/Header'
import axios from 'axios'

export default {
  name: 'detail',
  components: {
    Header
  },
  data () {
    return {
      title: '',
      userNickName: '',
      time: '',
      content: '',
      type: '',
      imgs: [],
      userHeadImg: '',
      telephone: '',
      userPageUrl: '',
      stared: false,
      infoId: null,
      editable: false,
      starId: null,
      category: ''
    }
  },
  mounted () {
    const urlParamsId = this.$route.params.id;
    if (urlParamsId) {
      // 获取文章信息
      this.loadPageData(urlParamsId);
    } else {
      this.$router.push('/')
    }
    this.isStared(urlParamsId);
  },
  computed: {
    categoryText () {
      let categoryList = null;
      if (this.type === '需求') {
        categoryList = JSON.parse(localStorage.getItem('requireCategory'))
      } else {
        categoryList = JSON.parse(localStorage.getItem('resourceCategory'))
      }
      
      for(let i in categoryList) {
        if(categoryList[i].id === parseInt(this.category)) {
          return categoryList[i].name;
        }
      }
    }
  },
  methods: {
    star () {
      if (!this.stared) { // 没有star，就收藏
        axios.post('/api/collection/add', {
          "informationId": this.infoId,
          "userId": localStorage.getItem('userId')
        },
          {
            headers: {
              token: localStorage.getItem('token')
            }
          }).then(res => {
            this.stared = !this.stared;
            this.$message({
              showClose: true,
              message: '收藏成功',
              type: 'success'
            });
          })
      } else {
        axios.delete('/api/collection/del', {
          data: {
            id: this.starId
          }
        }, {
            headers: {
              token: localStorage.getItem('token')
            }
          }).then(res => {
            this.stared = false;
            this.$message({
              showClose: true,
              message: '取消收藏成功'
            });
          })
      }
    },
    edit () {
      this.$router.push('/edit/' + this.infoId)
    },
    deleteInfo () {
      axios.delete('/api/information/del', {
        data: {
          id: this.infoId
        }
      }, {
          headers: {
            token: localStorage.getItem('token')
          }
        }).then(res => {
          this.$message({
            showClose: true,
            message: '删除成功'
          });
          if (this.type === '资源') {
            this.$router.push('/resource')
          } else {
            this.$router.push('/require')
          }
        })
    },
    loadPageData (urlParamsId) {
      axios.put('api/information/get', { id: urlParamsId }).then(res => {
        const { userNickName, updateTime, title, picture, content, type, userId, id, categoryId } = res.data.data;
        this.userNickName = userNickName;
        this.time = updateTime;
        this.title = title;
        this.type = (type == 0 ? '需求' : '资源')
        this.userId = userId
        this.category = categoryId
        if (userId === parseInt(localStorage.getItem('userId'))) {
          this.editable = true
        }
        this.infoId = id;
        if (picture) {
          this.imgs = picture.split('----')
        }
        this.userPageUrl = '/me/' + userId;
        // 换行符
        this.content = content.replace(/\n/g, '<br />');
        document.getElementById('content').innerHTML = this.content;
        // 获取作者信息
        return axios.put('/api/user/getUserInfo', {
          id: userId
        })
      }).then(res => {
        const { headImgUrl, telephone } = res.data.data
        this.userHeadImg = headImgUrl
        this.telephone = telephone;
      }).catch(err => {
        this.$message.error('出错了');
        this.$router.push('/')
      })
    },
    // 判断自己是否收藏
    isStared (urlParamsId) {
      axios.put('api/collection/list', {
        pageNum: 1,
        pageSize: 1000
      }, {
          headers: {
            token: localStorage.getItem('token')
          }
        }).then(res => {
          const allStarList = res.data.data.list
          const userId = parseInt(localStorage.getItem('userId'))
          const infoId = parseInt(urlParamsId)
          for (let i in allStarList) {
            if (allStarList[i].informationId === infoId && allStarList[i].userId === userId) {
              this.stared = true;
              this.starId = allStarList[i].id;
            }
          }
        })
    }
  }
}
</script>

<style scoped>
.page {
  margin: 20px auto;
  width: 700px;
}

.head-img {
  float: right;
  margin-right: 15px;
  border-radius: 50%;
  width: 60px;
  height: 60px;
  overflow: hidden;
  cursor: pointer;
}
.title {
  float: left;
  width: 580px;
}

img {
  max-width: 100%;
  margin: 10px;
}

td {
  padding: 5px 10px 0 0;
}

.right {
  margin-top: 20px;
  float: right;
  width: 100px;
  display: inline-block;
}
.el-button {
  margin: 5px;
}
.option {
  margin-top: 15px;
  padding-top: 5px;
}
#content {
  border-top: 1px solid #ececec;
  padding: 25px 10px 10px;
  margin-top: 15px;
}
</style>
