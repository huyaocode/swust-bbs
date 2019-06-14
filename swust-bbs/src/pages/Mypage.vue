import axios from 'axios';
<template>
  <div class="page">
    <el-form
      :model="userInfo"
      ref="loginForm"
      label-width="100px"
      class="form"
    >
      <el-form-item >
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
        {{userInfo.nickname}}
      </el-form-item>

      <el-form-item label="手机号：">
        {{userInfo.telephone}}
      </el-form-item>

      <el-form-item label="性别：">
        {{userInfo.sex}}
      </el-form-item>

      <el-form-item label="专业：">
        {{userInfo.profession}}
      </el-form-item>

      <el-form-item label="班级：">
        {{userInfo.classes}}
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
      userInfo: {}
    }
  },
  mounted () {
    axios.put('/api/user/get', {
      headers: {
        token: localStorage.getItem('token')
      },
    }).then(res => {
      this.userInfo = res.data.data;
      console.log('用户信息', res.data.data)
      const {id, username} = res.data.data;
      const localId = localStorage.getItem('userId')
      const localUsername = localStorage.getItem('username')
      // if(id === localId && username === localUsername) {

      // }
    }).catch(err => {
      console.log('error', err)
      this.$message.error('获取信息失败')
    })
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
</style>
