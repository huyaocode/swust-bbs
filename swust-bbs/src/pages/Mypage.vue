import axios from 'axios';
<template>
  <div :class="{ page: !editable, 'edit-page': editable }">
    <el-form
      :model="userInfo"
      ref="loginForm"
      label-width="100px"
    >
      <el-form-item>
        <el-image
          style="width: 60px; height: 60px;"
          :src="userInfo.headImgUrl"
          :fit="'cover'"
        >
        </el-image>
      </el-form-item>

      <el-form-item label="username：">
        <span style="font-size: 18px; font-weight: 600; font-style: italic;">{{userInfo.username}}</span>
      </el-form-item>

      <el-form-item label="昵称：">
        <span v-if="!editable">{{userInfo.nickname}}</span>
        <el-input
          v-else
          v-model="userInfo.nickname"
          placeholder="昵称"
        ></el-input>
      </el-form-item>

      <el-form-item label="手机号：">
        <span v-if="!editable">{{userInfo.telephone}}</span>
        <el-input
          v-else
          v-model="userInfo.telephone"
          placeholder="手机号"
        ></el-input>
      </el-form-item>

      <el-form-item label="性别：">
        <span v-if="!editable">{{userInfo.sex}}</span>
        <el-input
          v-else
          v-model="userInfo.sex"
          placeholder="性别"
        ></el-input>
      </el-form-item>

      <el-form-item label="学院：">
        <span v-if="!editable">{{userInfo.profession}}</span>
        <el-input
          v-else
          v-model="userInfo.profession"
          placeholder="学院"
        ></el-input>
      </el-form-item>

      <el-form-item label="班级：">
        <span v-if="!editable">{{userInfo.classes}}</span>
        <el-input
          v-else
          v-model="userInfo.classes"
          placeholder="班级"
        ></el-input>
      </el-form-item>

      <el-form-item>
        <el-button
          v-if="editable"
          style="width:135%; margin-left: -100px; margin-top:20px;"
          type="primary"
          @click="submitForm()"
          :loading="waitResponse"
        >更新</el-button>
      </el-form-item>
    </el-form>
  </div>
</template>

<script>
import axios from 'axios'
export default {
  name: 'mypage',
  data () {
    return {
      editable: false,
      waitResponse: false,
      userInfo: {
        headImgUrl: '',
        nickname: '',
        telephone: '',
        sex: '',
        profession: '',
        classes: ''
      }
    }
  },
  mounted () {
    const id = this.$route.params.id;
    // 获取用户信息
    this.getUserInfo(id);
    if (id === localStorage.getItem('userId')) {
      this.editable = true;
    }
  },
  methods: {
    getUserInfo (id) {
      axios.put('/api/user/getUserInfo', {
        id: id
      }).then(res => {
        if (res.data.data) {
          this.userInfo = res.data.data;
          console.log('用户信息', res.data.data)
        } else {
          this.$message.error('请登录')
          this.$router.push('/login')
        }
      }).catch(err => {
        console.log('error', err)
      })
    },
    // 更新
    submitForm () {
      this.waitResponse = true
      axios.put('/api/user/edit', {
        ...this.userInfo
      }, {
          headers: {
            token: localStorage.getItem('token')
          }
        }).then(res => {
          this.$message.success('更新信息成功')
          this.waitResponse = false
        }).catch(err => {
          console.log('error', err)
          this.$message.error('更新信息失败')
        })

    }
  }
}

</script>

<style scoped>
.page {
  width: 400px;
  margin: 20px auto;
  border: 1px solid #efefef;
  padding: 20px 10px 20px 150px;
}
.edit-page {
  width: 400px;
  margin: 20px auto;
  border: 1px solid #efefef;
  padding: 20px 20px 20px 10px;
}
</style>
