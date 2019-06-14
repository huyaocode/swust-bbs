<template>
  <el-form
    :model="ruleForm"
    :rules="rules"
    ref="registerForm"
    label-width="100px"
    class="form"
  >
    <el-form-item
      label="用户名"
      prop="username"
    >
      <el-input
        v-model="ruleForm.username"
        placeholder="请输入2~16字长的用户名"
      ></el-input>
    </el-form-item>

    <el-form-item
      label="昵称"
      prop="nickname"
    >
      <el-input
        v-model="ruleForm.nickname"
        placeholder="昵称长度4~16和字符之间"
      ></el-input>
    </el-form-item>

    <el-form-item
      label="密码"
      prop="pass"
    >
      <el-input
        type="password"
        v-model="ruleForm.pass"
        placeholder="密码长度在6~12字符之间"
      ></el-input>
    </el-form-item>

    <el-form-item
      label="确认密码"
      prop="checkPass"
    >
      <el-input
        type="password"
        v-model="ruleForm.checkPass"
        placeholder="密码长度在6~12字符之间"
      ></el-input>
    </el-form-item>

    <el-form-item>
      <el-button
        type="primary"
        style="width:100%"
        @click="submitForm('registerForm')"
        :loading="waitResponse"
      >注册</el-button>
    </el-form-item>
  </el-form>
</template>

<script>
import axios from 'axios'
import { constants } from 'crypto';

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
        checkPass: '',
        nickname: ''
      },
      waitResponse: false,
      rules: {
        username: [{ validator: validator('请输入正确手机号', 'username', username => username.length >=2 && username.length <= 16), trigger: 'blur' }],
        nickname: [{ validator: validator('请输入正确昵称', 'nickname', name => (name.length >= 2 && name.length <= 16)), trigger: 'blur' }],
        pass: [{ validator: validator('密码长度在6~12字符之间', 'pass', pass => (pass.length >= 6 && pass.length <= 12)), trigger: 'blur' }],
        checkPass: [{ validator: validator('两次输入密码不同', 'checkPass', () => this.ruleForm.checkPass === this.ruleForm.pass), trigger: 'blur' }]
      }
    }
  },
  methods: {
    submitForm (formName) {
      this.$refs[formName].validate((valid) => {
        if (valid) {
          this.waitResponse = true
          axios.post('/api/user/add', {
            nickname: this.ruleForm.nickname,
            password: this.ruleForm.pass,
            username: this.ruleForm.username
          }).then(res => {
            const {code, message, data} = res.data;
            this.waitResponse = false
            if(data) {
              localStorage.setItem('userid', data.id);
              localStorage.setItem('username', data.username);
              localStorage.setItem('nickname', data.nickname);
              this.$router.push({ path: '/login' })
            } else {
              this.$message.error(message);
            }
          })
        } else {
          console.log('error submit!!');
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