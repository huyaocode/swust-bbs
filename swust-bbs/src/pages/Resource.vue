<template>
  <div>
    <List :data="data" />
    <p
      class="loadMore"
      style="margin-top: 50px"
      v-if="!noMore"
    >
      <el-button
        round
        style="width: 90%"
        :loading="loading"
        @click="loadList"
      >加载更多</el-button>
    </p>
    <p v-if="noMore">没有更多了</p>
  </div>
</template>

<script>
import List from '../components/List'

export default {
  name: 'resource',
  components: {
    List
  },
  data () {
    return {
      count: 5,
      loading: false,
      data: [
        {
          id: 1,
          title: '转卖二手吉他',
          content: '吉他很好很好听，吉他很好很好听，吉他很好很好听，吉他很好很好听，吉他很好很好听，吉他很好很好听，吉他很好很好听，'
        },
        {
          id: 2,
          title: '转卖二手吉他',
          content: '吉他很好很好听，吉他很好很好听，吉他很好很好听，吉他很好很好听，吉他很好很好听，吉他很好很好听，吉他很好很好听，'
        },
        {
          id: 3,
          title: '转卖二手吉他很好听，吉他很好很好手吉他很好听，吉他很好很',
          content: '吉他很好很好听，吉他很好很好听，吉他很好很好听，吉他很好很好听，吉他很好很好听，吉他很好很好听，吉他很好很好听，吉他很好很好听，吉他很好很好听，吉他很好很好听，吉他很好很好听，'
        },
        {
          id: 4,
          title: '转卖二手吉他',
          content: '吉他很好很好听，吉他很好很好听，吉他很好很好听，吉他很好很好听，吉他很好很好听，吉他很好很好听，吉他很好很好听，'
        }
      ]
    }
  },
  computed: {
    noMore () {
      return this.count >= 20
    },
    disabled () {
      return this.loading || this.noMore
    }
  },
  mounted () {
    const fullPath = this.$route.fullPath
    if(fullPath ==='myresource') {

    } else {

    }
  },
  methods: {
    loadList () {
      this.loading = true;
      const data = this.data;
      setTimeout(() => {
        for (let i = 0; i < 5; i++) {
          this.data.push(this.data[0])
        }
        this.loading = false;
      }, 1000);
    }
  }
}
</script>

<style scoped>
p {
  text-align: center;
}
</style>
