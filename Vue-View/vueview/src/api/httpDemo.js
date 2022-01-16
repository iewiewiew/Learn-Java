/**
 *@author       weimenghua
 *@time         2022-11-05 16:38
 *@description
 */

import request from '@/utils/request'

//查询
export function list(data) {
  return request({
    url: '/demo/list',
    method: 'post',
    data: data
  })
}

//分页查询
export function listByPage(data) {
  return request({
    url: '/demo/listByPage',
    method: 'post',
    params: data
  })
}

//新增
export function add(data) {
  return request({
    url: '/demo/add',
    method: 'post',
    data: data
  })
}

//编辑
export function update(data) {
  return request({
    url: '/demo/update',
    method: 'post',
    data: data
  })
}

//删除
export function del(params) {
  return request({
    url: '/demo/delete',
    method: 'get',
    params: params
  })
}
