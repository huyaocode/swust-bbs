<template>
  <div style="margin: 20px auto; max-width: 800px;">
    <el-input
      placeholder="请输入内容"
      v-model="searchContent"
      style="margin:10px 0;"
    >
      <el-button
        slot="append"
        icon="el-icon-search"
        style="padding-right: 30px;"
        @click="search"
      ></el-button>
      <el-button
        style="border-left: 2px solid #fff; border-radius: 0;"
        slot="append"
        icon="el-icon-delete"
        @click="deleteInput"
      ></el-button>
    </el-input>
    <List :data="data" />
    <p
      class="loadMore"
      style="margin-top: 50px"
      v-if="!noMore"
    >
      <el-button
        round
        style="width: 100%; max-width: 800px; "
        :loading="loading"
        @click="loadList"
      >加载更多</el-button>
    </p>
    <p v-if="noMore">没有更多了</p>
  </div>
</template>

<script>
import List from '../components/List'
import axios from 'axios';

export default {
  name: 'require',
  components: {
    List
  },
  data () {
    return {
      pageNum: 0,
      pageSize: 10,
      loading: false,
      data: null,
      total: 10000,
      config: null,
      searchContent: ''
    }
  },
  watch: {
    '$route' (to, from) {
      if (to.path === '/require' && from.path === '/require/me'
        || to.path === '/require/me' && from.path === '/require'
      ) {
        // 清空列表
        this.data = null;
      }
      this.pageNum = 0;
      this.judgeUrl()
    }
  },
  computed: {
    noMore () {
      return this.pageNum * this.pageSize >= this.total;
    },
    disabled () {
      return this.loading || this.noMore
    }
  },
  mounted () {
    this.judgeUrl()
  },
  methods: {
    search () {
      if (this.searchContent) {
        this.config = { title: this.searchContent }
      } else {
        this.config = null
        this.pageNum = 0
      }
      this.data = null;
      this.loadList()
    },
    deleteInput () {
      this.config = null
      this.pageNum = 0
      this.data = null;
      this.loadList()
    },
    judgeUrl () {
      const fullPath = this.$route.fullPath
      if (fullPath === '/require/me') {
        this.config = {
          userId: localStorage.getItem('userId')
        }
      } else {
        this.config = null;
      }
      this.loadList()
    },
    loadList (config) {

      this.loading = true;
      const data = this.data;
      const sendData = {
        "pageNum": this.pageNum + 1,
        "pageSize": this.pageSize,
        "type": "0" // 0代表需求
      }

      if (this.config) {
        for (let key in this.config) {
          sendData[key] = this.config[key];
        }
      }

      console.log('sendData', sendData)

      axios.put('api/information/list', sendData).then(res => {
        if (res.data.data) {
          this.loading = false;
          this.pageNum++;
          this.total = res.data.data.total;
          if (!this.data) {
            this.data = res.data.data.list;
          } else {
            this.data = this.data.concat(res.data.data.list)
          }
        } else {
          this.$message.error('请登录');
          this.$router.push('/login')
        }
      }).catch(err => {
        this.loading = false;
        this.$message.error('请登录');
        this.$router.push('/login')
      })
    }
  }
}
</script>

<style scoped>
p {
  text-align: center;
}
</style>
