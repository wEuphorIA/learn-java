<!-- 拨打电话弹层 -->
<template>
  <u-popup
    ref="popup"
    @close="closePopup"
    v-model="show"
    mode="center"
    class="popupBox"
  >
    <view class="container phoneCon">
      <view class="popup-content">
        <view class="phone">
          <view
            >欢迎致电青橙电商，很高兴得到您的<br />认可，联系客服请拨打</view
          >
          <view>000-000-0000</view>
        </view>
        <view class="phoneFoot">
          <view class="closePopup" @click="closePopup">取消</view>
          <view @click="call">呼叫</view>
        </view>
      </view>
    </view>
  </u-popup>
</template>
<script>
export default {
  data() {
    return {
      show: true,
    };
  },
  props: ['phoneFlag'],
  methods: {
    closePopup() {
      this.$emit('close');
    },
    call() {
      uni.showToast({
        title: '该功能对接第三方，暂未实现',
        duration: 2000,
        icon: 'none',
      });
    },
  },
};
</script>
<style lang="scss">
// 拨打电话
.popupBox {
  .phoneCon {
    text-align: center;
    color: #333;
    font-size: 32rpx;
    line-height: 44rpx;
    .popup-content {
      width: 600rpx;
      border-radius: 32rpx;
      background-color: var(--neutral-color-white);
      & > view {
        font-size: 28rpx;
        &:first-child {
          border-bottom: 2rpx solid #efefef;
          color: #151515;
          font-size: 28rpx;
        }
        &:last-child {
          height: 100rpx;
          line-height: 100rpx;
        }
      }
    }
    .phoneFoot {
      display: flex;
      view {
        flex: 1;
        &:last-child {
          color: var(--essential-color-red);
        }
      }
      .closePopup {
        border-right: 1px solid var(--neutral-color-line);
      }
    }
    .phone {
      padding: 40rpx 60rpx;
      line-height: 40rpx;
      color: var(--neutral-color-main);
      view {
        &:last-child {
          font-size: 40rpx;
          line-height: 56rpx;
          padding-top: 16rpx;
        }
      }
    }
  }
}
</style>
