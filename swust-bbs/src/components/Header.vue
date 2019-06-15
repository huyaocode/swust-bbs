<template>
  <div id='header'>
    <div class="left">
      <h1>SWUST BBS</h1>
    </div>
    <div class="right">
      <el-menu
        style="border: none"
        :default-active="activeIndex"
        class="el-menu-demo"
        mode="horizontal"
        @select="handleSelect"
      >
        <el-menu-item index="1">
          <router-link to="/resource">资源</router-link>
        </el-menu-item>
        <el-menu-item index="2">
          <router-link to="/require">需求</router-link>
        </el-menu-item>
        <el-menu-item index="3">
          <router-link to="/add">
            <i class="el-icon-edit"></i>发帖子
          </router-link>
        </el-menu-item>
        <el-submenu
          index="4"
          class="right-menu-item"
        >
          <template slot="title"><i class="el-icon-user"></i></template>
          <router-link to="/resource/me">
            <el-menu-item index="4-1">我的资源</el-menu-item>
          </router-link>
          <router-link to="/require/me">
            <el-menu-item index="4-2">我的需求</el-menu-item>
          </router-link>
          <router-link to="/star">
            <el-menu-item index="4-3">我的收藏</el-menu-item>
          </router-link>
          <router-link :to="myPageUrl" >
            <el-menu-item index="4-4">关于我</el-menu-item>
          </router-link>
          <router-link to="/login">
            <el-menu-item index="666">切换账户</el-menu-item>
          </router-link>
        </el-submenu>
      </el-menu>
    </div>
  </div>

</template>

<script>
export default {
  name: 'Header',
  data: () => ({
    activeIndex: localStorage.getItem('activeIndex'),
    myPageUrl: `/me/${localStorage.getItem('userId')}`
  }),
  methods: {
    handleSelect (index) {
      localStorage.setItem('activeIndex', index)
    }
  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
#header {
  border-bottom: 1px solid #e6e6e6;
  padding-right: 50px;
}
.left {
  float: left;
  width: 170px;
  padding: 15px;
  font-size: 15px;
}
.right {
  margin-left: 170px;
}
.right-menu-item {
  float: right;
}
a {
  display: inline-block;
  width: 100%;
  height: 100%;
  padding: 0 20px;
  margin: 0 -20px;
}
a li {
  width: 10px;
  margin-left: 15px;
}
h1 {
  color: rgb(64, 158, 255);
  font-style: italic;
}
</style>
