<template>
  <view>
    <u-navbar :is-back="true" title="证照信息"> </u-navbar>
    <div class="wrapper" :style="{ paddingTop: capsuleBottom + 'px' }">
      <div class="aboutBox">
          <p><img src="/static/yyzz01.jpg" /></p>
          <p><img src="/static/zzdx01.jpg" /></p>
      </div>
    </div>
  </view>
</template>
<script>
export default {
  data() {
    return {
      navTitle: '',
      capsuleBottom: null,
    };
  },
  mounted() {},
  onLoad(option) {
    uni.getSystemInfo({
      success: () => {
        this.capsuleBottom = uni.getMenuButtonBoundingClientRect().bottom + 8;
      },
    });
  }
};
</script>
<style lang="scss">
/deep/ page{
    background: #f8f8f8;
}
</style>
<style lang="scss" scoped>
@import './index.scss';
.wrapper {
  padding: 16rpx;
}
</style>
