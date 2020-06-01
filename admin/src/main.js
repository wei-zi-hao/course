import Vue from 'vue'
import App from './App.vue'
import router from './router'
import Axios from "axios";

Vue.config.productionTip = false
Vue.prototype.$ajax = Axios

new Vue({
  router,
  render: h => h(App),
}).$mount('#app')

/**
 * axios拦截器
 */
Axios.interceptors.request.use(function (config) {
  console.log("请求：", config);
  let token = Tool.getLoginUser().token;
  if (Tool.isNotEmpty(token)) {
    config.headers.token = token;
    console.log("请求headers增加token:", token);
  }
  return config;
}, error => {});
Axios.interceptors.response.use(function (response) {
  console.log("返回结果：", response);
  return response;
}, error => {});
