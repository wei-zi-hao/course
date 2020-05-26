<template>
    <div>
        <h1>欢迎来到控台页面</h1>
    </div>
</template>

<script>
    export default {
        name:"welcome",
        mounted() {
             this.$parent.activeSidebar("welcome-sidebar");
        }
    }
</script>

<style>

</style>
