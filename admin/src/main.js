import Vue from 'vue'
import App from './App.vue'
import router from './router'
import Axios from "axios";
import filter from "./filter/filter";

Vue.config.productionTip = false
Vue.prototype.$ajax = Axios

new Vue({
  router,
  render: h => h(App),
}).$mount('#app')


// 全局过滤器
Object.keys(filter).forEach(key => {
  Vue.filter(key, filter[key])
});

