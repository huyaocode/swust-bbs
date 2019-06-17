<template>
  <ul>
    <li
      v-for="(item, index) in data"
      :key="index"
      class="infinite-list-item"
    >
      <el-card class="box-card">
        <router-link :to="'/detail/' + item.id">
          <div
            class="img"
            v-if="item.picture"
          >
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
            <div style="display: flex; justify-content: space-between;">
              <h3>{{item.title }}</h3>
              <h4 style="font-style: italic; font-weight: 200;">{{getCategory(item.categoryId, item.type)}}</h4>
            </div>
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
  props: ['data'],
  methods: {
    getCategory (categoryId, type) {
      let categoryList = null;
      if (type === '0') {
        categoryList = JSON.parse(localStorage.getItem('requireCategory'))
      } else {
        categoryList = JSON.parse(localStorage.getItem('resourceCategory'))
      }
      for (let i in categoryList) {
        if (categoryList[i].id === parseInt(categoryId)) {
          return categoryList[i].name;
        }
      }
    }
  },
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
