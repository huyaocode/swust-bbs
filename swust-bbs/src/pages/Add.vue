<template>
  <el-form
    :model="form"
    :rules="rules"
    ref="addFrom"
    label-width="100px"
    class="form"
  >
    <el-form-item prop="title">
      <el-input
        placeholder="标题"
        v-model="form.title"
      ></el-input>
    </el-form-item>

    <el-form-item prop="type">
      <el-radio-group v-model="form.type">
        <el-radio label="resource">资源</el-radio>
        <el-radio label="require">需求</el-radio>
      </el-radio-group>
    </el-form-item>

    <el-form-item
      prop="content"
      autocomplete="off"
    >
      <el-input
        type="textarea"
        placeholder="请输入内容"
        rows="5"
        v-model="form.content"
      ></el-input>
    </el-form-item>

    <el-form-item
      prop="content"
      autocomplete="off"
    >
      <el-upload
        action="https://jsonplaceholder.typicode.com/posts/"
        list-type="picture-card"
        :on-preview="handlePictureCardPreview"
        :on-remove="handleRemove"
      >
        <i class="el-icon-plus"></i>
      </el-upload>
      <el-dialog :visible.sync="dialogVisible">
        <img
          width="100%"
          :src="dialogImageUrl"
          alt=""
        >
      </el-dialog>
    </el-form-item>

    <el-form-item>
      <el-button
        style="width:100%; margin-top: 30px;"
        type="primary"
        @click="submitForm('addFrom')"
        :loading="waitResponse"
      >发布</el-button>
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
        const isVertified = vertifyMethod(this.form[checkData]);
        if (!isVertified) {
          callback(new Error(errMessage));
        } else {
          callback();
        }
      }
    }
    return {
      form: {
        content: '',
        title: '',
        type: ''
      },
      dialogImageUrl: '',
      dialogVisible: false,
      waitResponse: false,
      rules: {
        title: [{ validator: validator('请输入标题', 'title', text => text.length > 0), trigger: 'blur' }],
        content: [{ validator: validator('请输入内容', 'content', content => content.length > 0), trigger: 'blur' }],
        type: [{ validator: validator('请选择类型', 'type', type => type), trigger: 'blur' }]
      }
    }
  },
  methods: {
    submitForm (formName) {
      this.$refs[formName].validate((valid) => {
        if (valid) {
          const data = {
            ...this.form
          }
          data['time'] = {

          }
          console.log('发布', data)
          this.waitResponse = true
          setTimeout(() => {
            this.waitResponse = false

          }, 1000)
        } else {
          console.log('error submit!!')
          return false;
        }
      });
    },
    handleRemove(file, fileList) {
      console.log(file, fileList);
    },
    handlePictureCardPreview(file) {
      this.dialogImageUrl = file.url;
      this.dialogVisible = true;
    }
  }
}
</script>

<style scoped>
.form {
  width: 800px;
  margin: 30px auto;
  padding: 30px 30px 30px 0px;
  border-radius: 5px;
}
</style>