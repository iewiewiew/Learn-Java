import request from '@/utils/request'

//查询
export function list(data) {
  return request({
    url: '/example/list',
    method: 'post',
    data: data
  })
}

//分页查询
export function listByPage(data) {
  return request({
      url: '/example/listByPage',
      method: 'post',
      params: data
  })
}
