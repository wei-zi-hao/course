import Vue from 'vue'
import Router from 'vue-router';
import login from "./views/login.vue";
import admin from "./views/admin.vue";

Vue.use(Router);

export default new Router({
    mode:'history',
    base:process.env.BASE_URL,
    routes:[{
        path:'*',
        redirect:"/login",
    },{
        path: '/login',
        component:login
    },{
        path: '/admin',
        component:admin
    }]

})