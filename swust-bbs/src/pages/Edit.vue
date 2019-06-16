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
        <el-radio label="1">资源</el-radio>
        <el-radio label="0">需求</el-radio>
      </el-radio-group>
    </el-form-item>
    <el-form-item prop="type">
      <el-select
        v-model="form.category"
        placeholder="请选择类型"
      >
        <el-option
          v-for="item in optionList"
          :key="item.id"
          :label="item.name"
          :value="item.id"
        >
        </el-option>
      </el-select>
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
        action="/api/information/uploadImg"
        list-type="picture-card"
        :on-preview="handlePictureCardPreview"
        :on-remove="handleRemove"
        :headers="myHeaders"
        :on-success="addPic"
        :file-list="form.imgObjList"
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
      >
        {{editing ? '更新' : '发布'}}
      </el-button>
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
        infoId: null,
        content: '',
        title: '',
        type: '',
        category: '',
        imgObjList: []
      },
      editing: false,
      picList: [],
      myHeaders: { token: localStorage.getItem('token') },
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
  computed: {
    optionList () {
      if (this.form.type === '1') {
        return JSON.parse(localStorage.getItem('resourceCategory'))
      } else if (this.form.type === '0') {
        return JSON.parse(localStorage.getItem('requireCategory'))
      }
    }
  },
  mounted () {
    // 编辑
    if (this.$route.path.search('edit') !== -1) {
      this.infoId = this.$route.params.id;
      this.editing = true;
      this.loadInfo();

    }
  },
  methods: {
    submitForm (formName) {
      const date = new Date();
      this.$refs[formName].validate((valid) => {
        if (valid) {
          const data = {}
          const { title, type, content, category } = this.form;
          data.type = type;
          data.title = title;
          data.categoryId = category
          data.content = content;
          data.userId = localStorage.getItem('userId')

          if (this.form.imgObjList.length > 0) {
            data.picture = ''
            this.form.imgObjList.forEach(img => {
              data.picture += img.url + '----'
            });
          }
          this.waitResponse = true
          console.log('提交后台', data)
          axios.post('/api/information/add',
            data, {
              headers: {
                token: localStorage.getItem('token')
              }
            }
          )
            // 跳转到详情
            .then(res => {
              this.waitResponse = false;
              this.$router.push({ path: '/detail/' + res.data.data.id })
            }).catch(err => {
              this.waitResponse = false;
            }).catch(err => {
              this.$message.error(err);
              // this.$router.push({ path: '/login' })
            })
        } else {
          console.log('error submit!!')
          return false;
        }
      });
    },
    addPic (response, file, fileList) {
      this.form.imgObjList.push({
        name: file.name,
        url: 'http://localhost:8085/' + response.message
      })
    },
    handleRemove (file, fileList) {
      this.form.imgObjList = fileList
    },
    handlePictureCardPreview (file) {
      this.dialogImageUrl = file.url;
      this.dialogVisible = true;
    },
    loadInfo () {
      axios.put('api/information/get', { id: this.infoId }).then(res => {
        const { title, picture, content, type } = res.data.data;
        this.form.title = title
        this.form.type = type
        this.form.content = content
        if (picture) {
          const images = picture.split('----')
          for (let i in images) {
            if (images[i]) {
              this.form.imgObjList.push({
                name: '',
                url: images[i]
              })
            }
          }
        }
      }).catch(err => {
        this.$message.error('出错了');
      })
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