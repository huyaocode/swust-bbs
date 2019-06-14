// import的时候从 'vue/dist/vue.js' 中引入，否则报错
import Vue from 'vue/dist/vue.js'
import VueRouter from 'vue-router'
import ElementUI from 'element-ui'
import 'element-ui/lib/theme-chalk/index.css'
import axios from 'axios'
import routes from './router.js'

Vue.use(VueRouter)
Vue.use(ElementUI)
Vue.config.productionTip = false

axios.defaults.withCredentials=true

const router = new VueRouter({
  routes
})

new Vue({
  router
}).$mount('#app')
