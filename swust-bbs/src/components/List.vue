<template>
  <ul>
    <li
      v-for="(item, index) in data"
      :key="index"
      class="infinite-list-item"
    >
      <el-card class="box-card">
        <router-link :to="'/detail/' + item.id">
          <div class="img" v-if="item.picture">
            <el-image
              style="width: 100px; height: 100px"
              :src="(item.picture).split('----')[0]"
              :fit="'contain'"
            >
            </el-image>
          </div>
        </router-link>
        <div class="content">
          <router-link :to="'/detail/' + item.id">
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
  margin: 20px auto;
}
.img {
  float: left;
  margin-right: 15px;
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
