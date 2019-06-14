<template>
  <div class="page">
    <div class="header">
      <div class="title">
        <h2>{{title}}</h2>
        <table style="margin-top:10px;">
          <tr>
            <td>{{time}}</td>
            <td>{{type}}</td>
            <td>{{author}}</td>
            <td>{{contact}}</td>
          </tr>
        </table>
      </div>

      <div class="head-img">
        <el-image
          style="width: 60px; height: 60px;"
          :src="'https://fuss10.elemecdn.com/e/5d/4a731a90594a4af544c0c25941171jpeg.jpeg'"
          :fit="'cover'"
        >
        </el-image>
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

  </div>
</template>

<script>
import Header from '../components/Header'
import { constants } from 'crypto';

export default {
  name: 'detail',
  components: {
    Header
  },
  data () {
    return {
      title: '这是标题',
      type: '类型',
      contact: '18681693374',
      author: '胡耀',
      time: '2019-6-10',
      content: '吉他很好很好听，吉他很好很好听，吉他很好很好听，吉他很好很好听，吉他很好很好听，吉他很好很好听，吉他很好很好听，吉他很好很好听，吉他很好很好听，吉他很好很好听，吉他很好很好听',
      imgs: ['https://cube.elemecdn.com/6/94/4d3ea53c084bad6931a56d5158a48jpeg.jpeg?s=1',
        'https://cube.elemecdn.com/6/94/4d3ea53c084bad6931a56d5158a48jpeg.jpeg?s=2'
        , 'https://cube.elemecdn.com/6/94/4d3ea53c084bad6931a56d5158a48jpeg.jpeg?s=3']
    }
  }
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
  margin: 40px 0;
}

img {
  max-width: 100%;
}

td{
  padding-right: 15px;
  line-height: 15px;
  align-content: center;
}
</style>
