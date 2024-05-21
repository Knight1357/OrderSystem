function loginApi(data) {
  return $axios({
    'url': '/employee/login',
    // 'url': '/aa',
    'method': 'post',
    data
  })
}

function logoutApi(){
  return $axios({
    'url': '/employee/logout',
    'method': 'post',
  })
}
