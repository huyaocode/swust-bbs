<template>
  <ul>
    <li
      v-for="item in data"
      :key="item.id"
      class="infinite-list-item"
    >
      <el-card class="box-card">
        <router-link to="/">
          <div class="img">
            <el-image
              style="width: 100px; height: 100px"
              :src="'https://fuss10.elemecdn.com/e/5d/4a731a90594a4af544c0c25941171jpeg.jpeg'"
              :fit="'contain'"
            >
            </el-image>
          </div>
        </router-link>
        <div class="content">
          <router-link to="/">
            <h3>{{item.title }}</h3>
          </router-link>
          <p>
            {{item.content }}
          </p>
        </div>
      </el-card>
    </li>
  </ul>
</template>

<script>
import { constants } from 'crypto';

export default {
  name: 'list',
  props: ['data']
}
</script>

<style scoped>
li {
  list-style: none;
  margin: 20px 50px;
}
.img {
  float: left;
}
.content {
  margin-left: 120px;
}
.box-card {
  padding-bottom: 10px;
}
h3 {
  overflow: hidden;
  text-overflow: ellipsis;
  white-space: nowrap;
}
p {
  display: -webkit-box;
  -webkit-box-orient: vertical;
  -webkit-line-clamp: 3;
  overflow: hidden;
}
</style>
