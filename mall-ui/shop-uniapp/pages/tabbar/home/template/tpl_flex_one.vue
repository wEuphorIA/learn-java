<template>
  <div class="layout">
    <div class="flex-one">
      <u-image @click="modelNavigateTo(res.list[0])" width="100%" mode="aspectFit" height="176rpx" src="/static/img/pic-yhj.png" alt=""></u-image>
    </div>
    <div class="flex-one">
      <hotzone :res="res"></hotzone>
    </div>
    <div class="flex-one">
      <u-image @click="modelNavigateTo(res.list[0])" width="100%" mode="aspectFit" height="228rpx" src="/static/img/618.png" alt="" class="imgs"></u-image>
    </div>
  </div>
</template>
<script>
import { modelNavigateTo } from "./tpl";
import hotzone from "@/pages/tabbar/home/template/tpl_hot_zone.vue";

export default {
  title: "单行图片模块",
  components: {
    hotzone,
  },
  data() {
    return {
      modelNavigateTo
    };
  },
  props: ["res"],
};
</script>
<style lang="scss" scoped>
@import "./tpl.scss";
.flex-one {
  width: 100%;
  display: block;
  overflow: hidden;
  padding: 40rpx 0 0;
  > img {
    width: 100%;
    height: 100%;
  }
}

</style>