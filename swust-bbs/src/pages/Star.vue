<template>
  <div style="margin: 20px auto; max-width: 800px;">

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
  name: 'mystar',
  components: {
    List
  },
  data () {
    return {
      pageNum: 0,
      pageSize: 10,
      loading: false,
      starList: [],
      total: 10000,
      data: null
    }
  },
  watch: {
    '$route' () {
      // 清空列表
      this.data = null;
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
    this.starList.length = 0;
    this.loadList()
  },
  methods: {
    loadList () {
      this.loading = true;
      const data = this.data;
      const sendData = {
        "pageNum": this.pageNum + 1,
        "pageSize": this.pageSize
      }
      axios.put('api/collection/getMyCollection', {}, {
        headers: {
          token: localStorage.getItem('token')
        }
      }).then(res => {
        if (res.data.data) {
          this.pageNum++;
          this.total = res.data.data.length;
          if (!this.data) {
            this.data = res.data.data.reverse()
          } else {
            this.data = this.data.concat(res.data.data.reverse())
          }
        } else {
          this.$message.error('请登录');
          this.$router.push('/login')
        }
        this.loading = false;
      }).catch(err => {
        this.loading = false;
        this.$message.error('请登录');
        this.$router.push('/login')
      })
    },
    loadContent () {
      console.log('content', this.starList)
    }
  }
}
</script>

<style scoped>
p {
  text-align: center;
}
</style>
