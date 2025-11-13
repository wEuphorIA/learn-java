<template>
  <div class="layout">
    <div class="menu-list">
      <div
        class="menu-item"
        @click="modelNavigateTo(item)"
        v-for="(item, index) in res.list"
        :key="index"
      >
        <div>
          <u-image
            width="88rpx"
            height="88rpx"
            class="menu-img"
            :src="imgList[index]"
          >
            <u-loading slot="loading"></u-loading>
          </u-image>
        </div>
        <div class="menu-title">{{ item.title }}</div>
      </div>
    </div>
  </div>
</template>
<script>
import { modelNavigateTo } from "./tpl";
export default {
  title: "五列菜单",
  props: ["res"],
  data() {
    return {
      modelNavigateTo,
      imgList:[
        '/static/icon/icon-shuma.png',
        '/static/icon/icon-jydq.png',
        '/static/icon/icon-fzxm.png',
        '/static/icon/icon-spyl.png',
        '/static/icon/icon-xlx.png',
        '/static/icon/icon-ghhz.png',
        '/static/icon/icon-cfcy.png',
        '/static/icon/icon-jjjz.png',
        '/static/icon/icon-ms.png',
        '/static/icon/icon-lqzx.png'
      ]
    };
  },
};
</script>
<style lang="scss" scoped>
@import "./tpl.scss";
.menu-list {
  display: flex;
  align-items: center;
  justify-content: space-between;
  flex-wrap: wrap;

  > .menu-item {
    text-align: center;
    width: 20%;
    // flex: 1;
    margin: 40rpx 0 0;
  }
}
.menu-img {
  display: flex;
  margin: 0 auto;
  width: 88rpx;
  height: 88rpx;
}
.menu-title {
  font-size: 24rpx;
  padding-top: 10rpx;
}
</style>