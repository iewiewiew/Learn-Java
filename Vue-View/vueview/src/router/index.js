import Vue from 'vue'
import Router from 'vue-router'
import Layout from "@/layout/Layout";

Vue.use(Router)
export const constantRouterMap = [
  {
    path: '/',
    name: 'Layout',
    component: Layout,
    redirect: "/demo",
    children: [
      {
        path: 'home',
        name: 'Home',
        component: () => import("@/views/Home"),
      },
      {
        path: 'demo',
        name: 'demo',
        component: () => import("@/views/demo"),
      },
      {
        path: 'news',
        name: 'News',
        component: () => import("@/views/News"),
      },
    ]
  },
  {
    path: '/index',
    name: 'index',
    component:() => import('@/views/index'),
  },
  {
    path: '/demo',
    name: 'demo',
    component:() => import('@/views/demo'),
  }
];

export default new Router({
  // mode: 'history', //后端支持可开
  scrollBehavior: () => ({y: 0}),
  routes: constantRouterMap
})
