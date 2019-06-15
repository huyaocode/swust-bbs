import App from './App.vue'
import Login from './pages/Login'
import Register from './pages/Register'
import Require from './pages/Require'
import Resource from './pages/Resource'
import Mypage from './pages/Mypage'
import Add from './pages/Add'
import Detail from './pages/Dertail.vue'

export default [
  {
    path: '/',
    component: App,
    children: [
      {
        path: '/',
        component: Resource
      },
      {
        path: 'resource',
        component: Resource,
        children: [
          {
            path: 'me',
            component: Resource
          }
        ]
      },
      {
        path: 'require',
        component: Require,
        children: [
          {
            path: 'me',
            component: Require
          }
        ]
      },
      {
        path: 'login',
        component: Login
      },
      {
        path: 'register',
        component: Register
      },
      {
        path: 'me/:id',
        component: Mypage
      },
      {
        path: 'add',
        component: Add
      },
      {
        path: 'detail/:id',
        component: Detail
      }
    ]
  }
]
