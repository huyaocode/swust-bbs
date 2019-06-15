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
            <td>发布人：</td>
            <td>{{userNickName}}</td>
          </tr>
          <tr>
            <td>联系方式：</td>
            <td>{{telephone}}</td>
          </tr>
        </table>
      </div>

      <div class="head-img">
        <router-link :to="userPageUrl">
          <el-image
            style="width: 60px; height: 60px;"
            :src="userHeadImg"
            :fit="'cover'"
          >
          </el-image>
        </router-link>
      </div>
    </div>

    <div class="content">
      {{content}}
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
      userPageUrl: ''
    }
  },
  mounted () {
    const urlParamsId = this.$route.params.id;
    if (urlParamsId) {
      axios.put('api/information/get', { id: urlParamsId }).then(res => {
        console.log(res.data.data)
        const { userNickName, updateTime, title, picture, content, type, userId } = res.data.data;
        this.userNickName = userNickName;
        this.time = updateTime;
        this.title = title;
        this.type = type == 0 ? '需求' : '资源'
        this.userId = userId;
        if (picture) {
          this.imgs = picture.split('----');
        }
        this.userPageUrl = '/me/' + userId;
        console.log('pic', this.imgs)
        this.content = content;

        return axios.put('/api/user/getUserInfo', {
          id: userId
        })
      }).then(res => {
        const { headImgUrl, telephone } = res.data.data
        this.userHeadImg = headImgUrl
        this.telephone = telephone;
      })
    }
  },
}
</script>

<style scoped>
.page {
  margin: 20px auto;
  width: 700px;
}
.head-img {
  margin-left: 600px;
  border-radius: 50%;
  width: 60px;
  height: 60px;
  overflow: hidden;
  cursor: pointer;
}
.title {
  float: left;
  width: 600px;
}
.content {
  border-top: 1px solid #ececec;
  padding-top: 25px;
  margin: 130px 0;
}

img {
  max-width: 100%;
}

td {
  padding: 5px 10px 0 0;
}
</style>
