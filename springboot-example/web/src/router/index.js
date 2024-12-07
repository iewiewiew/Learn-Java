import Vue from 'vue'
import Router from 'vue-router'

Vue.use(Router)

export const constantRouterMap = [
  {
    path: '/',
    name: 'Layout',
    redirect: "/example",
    children: [
      {
        path: 'tmp',
        name: 'Tmp',
        component: () => import("@/views/example"),
      },
    ]
  },
  {
    path: '/example',
    name: 'Example',
    component:() => import('@/views/example'),
  },
];

export default new Router({
  scrollBehavior: () => ({y: 0}),
  routes: constantRouterMap
})
