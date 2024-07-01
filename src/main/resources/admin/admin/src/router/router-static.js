import Vue from 'vue';
//配置路由
import VueRouter from 'vue-router'
Vue.use(VueRouter);
//1.创建组件
import Index from '@/views/index'
import Home from '@/views/home'
import Login from '@/views/login'
import NotFound from '@/views/404'
import UpdatePassword from '@/views/update-password'
import pay from '@/views/pay'
import register from '@/views/register'
import center from '@/views/center'
    import jiarubanji from '@/views/modules/jiarubanji/list'
    import discussxinwenxinxi from '@/views/modules/discussxinwenxinxi/list'
    import banwei from '@/views/modules/banwei/list'
    import juanzengxinxi from '@/views/modules/juanzengxinxi/list'
    import huodongxinxi from '@/views/modules/huodongxinxi/list'
    import discusshuodongxinxi from '@/views/modules/discusshuodongxinxi/list'
    import storeup from '@/views/modules/storeup/list'
    import forum from '@/views/modules/forum/list'
    import discussbanjixiangce from '@/views/modules/discussbanjixiangce/list'
    import banjixiangce from '@/views/modules/banjixiangce/list'
    import yonghu from '@/views/modules/yonghu/list'
    import xinwenxinxi from '@/views/modules/xinwenxinxi/list'
    import banjixinxi from '@/views/modules/banjixinxi/list'
    import config from '@/views/modules/config/list'


//2.配置路由   注意：名字
const routes = [{
    path: '/index',
    name: '首页',
    component: Index,
    children: [{
      // 这里不设置值，是把main作为默认页面
      path: '/',
      name: '首页',
      component: Home,
      meta: {icon:'', title:'center'}
    }, {
      path: '/updatePassword',
      name: '修改密码',
      component: UpdatePassword,
      meta: {icon:'', title:'updatePassword'}
    }, {
      path: '/pay',
      name: '支付',
      component: pay,
      meta: {icon:'', title:'pay'}
    }, {
      path: '/center',
      name: '个人信息',
      component: center,
      meta: {icon:'', title:'center'}
    }
      ,{
	path: '/jiarubanji',
        name: '加入班级',
        component: jiarubanji
      }
      ,{
	path: '/discussxinwenxinxi',
        name: '新闻信息评论',
        component: discussxinwenxinxi
      }
      ,{
	path: '/banwei',
        name: '班委',
        component: banwei
      }
      ,{
	path: '/juanzengxinxi',
        name: '捐赠信息',
        component: juanzengxinxi
      }
      ,{
	path: '/huodongxinxi',
        name: '活动信息',
        component: huodongxinxi
      }
      ,{
	path: '/discusshuodongxinxi',
        name: '活动信息评论',
        component: discusshuodongxinxi
      }
      ,{
	path: '/storeup',
        name: '我的收藏管理',
        component: storeup
      }
      ,{
	path: '/forum',
        name: '论坛管理',
        component: forum
      }
      ,{
	path: '/discussbanjixiangce',
        name: '班级相册评论',
        component: discussbanjixiangce
      }
      ,{
	path: '/banjixiangce',
        name: '班级相册',
        component: banjixiangce
      }
      ,{
	path: '/yonghu',
        name: '用户',
        component: yonghu
      }
      ,{
	path: '/xinwenxinxi',
        name: '新闻信息',
        component: xinwenxinxi
      }
      ,{
	path: '/banjixinxi',
        name: '班级信息',
        component: banjixinxi
      }
      ,{
	path: '/config',
        name: '轮播图管理',
        component: config
      }
    ]
  },
  {
    path: '/login',
    name: 'login',
    component: Login,
    meta: {icon:'', title:'login'}
  },
  {
    path: '/register',
    name: 'register',
    component: register,
    meta: {icon:'', title:'register'}
  },
  {
    path: '/',
    name: '首页',
    redirect: '/index'
  }, /*默认跳转路由*/
  {
    path: '*',
    component: NotFound
  }
]
//3.实例化VueRouter  注意：名字
const router = new VueRouter({
  mode: 'hash',
  /*hash模式改为history*/
  routes // （缩写）相当于 routes: routes
})

export default router;
