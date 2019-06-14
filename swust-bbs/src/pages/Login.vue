<template>
  <el-form
    :model="ruleForm"
    :rules="rules"
    ref="loginForm"
    label-width="100px"
    class="form"
  >
    <el-form-item
      label="账号"
      prop="username"
    >
      <el-input v-model="ruleForm.username"></el-input>
    </el-form-item>

    <el-form-item
      label="密码"
      prop="pass"
      autocomplete="off"
    >
      <el-input
        type="password"
        v-model="ruleForm.pass"
      ></el-input>
    </el-form-item>

    <el-form-item>
      <el-button
        style="width:100%"
        type="primary"
        @click="submitForm('loginForm')"
        :loading="waitResponse"
      >登录</el-button>
    </el-form-item>
    <el-form-item>
      <router-link to="/register">
        <el-button style="width:100%">去注册</el-button>
      </router-link>
    </el-form-item>
  </el-form>
</template>

<script>
import axios from 'axios'
import { constants } from 'crypto';
import { setTimeout } from 'timers';

export default {
  name: 'login',
  data () {
    var validator = (errMessage, checkData, vertifyMethod) => {
      return (rule, value, callback) => {
        const isVertified = vertifyMethod(this.ruleForm[checkData]);
        if (!isVertified) {
          callback(new Error(errMessage));
        } else {
          callback();
        }
      }
    }

    return {
      ruleForm: {
        pass: '',
        username: '',
      },
      waitResponse: false,
      rules: {
        username: [{ validator: validator('请输入正确用户名', 'username', username => username.length >= 2 && username.length <= 16), trigger: 'blur' }],
        pass: [{ validator: validator('密码长度在6~12字符之间', 'pass', pass => (pass.length >= 6 && pass.length <= 12)), trigger: 'blur' }],
      }
    }
  },
  mounted () {
    this.ruleForm.username = localStorage.getItem('username')
  },
  methods: {
    submitForm (formName) {
      this.$refs[formName].validate((valid) => {
        if (valid) {
          this.waitResponse = true
          // 登录
          axios.post('/api/login', {
            username: this.ruleForm.username,
            password: this.ruleForm.pass
          }).then(res => {
            const { code, message, data } = res.data;
            if (data) {
              localStorage.setItem('isLogin', true);
              localStorage.setItem('token', data.token);
              localStorage.setItem('loginTime', data.loginTime);
              axios.defaults.headers.common['token'] = data.token
            } else {
              this.$message.error(message);
            }
            return axios.put('/api/user/get', {
              headers: {
                token: localStorage.getItem('token')
              }
            })
          }).then(res => {
            // 获取用户信息（id）
            this.waitResponse = false
              console.log('信息', res.data)
              this.userInfo = res.data.data;
              const { id, username } = res.data.data;
              const localId = localStorage.setItem('userId', id)
              this.$router.push({ path: '/' })
            }).catch(err => {
              console.log('error', err)
              this.$message.error('获取信息失败')
            })
        } else {
          return false;
        }
      });
    }
  }
}
</script>

<style scoped>
.form {
  width: 400px;
  margin: 30px auto;
  padding: 30px 30px 30px 0px;
  border-radius: 5px;
}
</style>