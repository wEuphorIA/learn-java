<template>
  <view class="wrapper">
    <div class="coupon-empty" v-if="!res">暂无优惠券</div>
    <view class="coupon-List" v-for="(item, index) in couponRes" :key="index">
      <view class="coupon-item">
        <view class="left">
          <view class="message">
            <view class="top">
              <div class="price firstMsg">
                <span v-if="item.couponType == 'DISCOUNT'"
                  ><span class="num">{{ item.couponDiscount }}</span><span class="pri">折</span></span
                >
                <span v-if="item.couponType == 'PRICE'"
                  ><span class="pri">￥</span
                      ><span class="num">{{ item.price | unitPrice }}</span
                      >优惠券</span
                >
              </div>
              <view class="text">
                <div class="coupon-List-title">
                  <view v-if="item.scopeType">
                    <span v-if="item.scopeType == 'ALL' && item.storeId == '0'"
                      >全平台</span
                    >
                    <span v-if="item.scopeType == 'PORTION_GOODS_CATEGORY'"
                      >仅限品类</span
                    >
                    <view v-else
                      >{{
                        item.storeName == 'platform'
                          ? '全平台'
                          : item.storeName + '店铺'
                      }}使用</view
                    >
                  </view>
                </div>
                <div>满{{ item.consumeThreshold | unitPrice }}可用</div>
              </view>
            </view>
            <view class="time"
              >{{ (item.startTime / 1000) | unixToDate }} -
              {{ (item.endTime / 1000) | unixToDate }}</view
            >
          </view>
          <view class="circle circle-top"></view>
          <view class="circle circle-bottom"></view>
        </view>
        <view class="right">
          <view class="lingqu-btn" @click="getCoupon(item, index)">
            <div :class="yhqFlag[index] ? 'cur' : ''">
              {{ yhqFlag[index] ? '已领取或领完' : '立即领取' }}
            </div>
          </view>
        </view>
      </view>
    </view>
  </view>
</template>

<script>
export default {
  data() {
    return {
      yhqFlag: [], //获取优惠券判断是否点击
      couponRes: [],
    };
  },
  props: {
    res: {
      type: null,
      default: '',
    },
  },
  watch: {
    res: {
      handler() {
        if (this.res && this.res.length != 0) {
          Object.keys(this.res).forEach((item) => {
            let key = item.split('-')[0];
            if (key === 'COUPON') {
              this.couponRes.push(this?.res[item]);
            }
          });
        }
      },
      immediate: true,
    },
  },
  methods: {
    // 提交优惠券
    getCoupon(item, index) {
      this.yhqFlag[index] = true;
      this.$emit('getCoupon', item);
    },
  },
};
</script>

<style lang="scss" scoped>
.coupon-item {
  width: 100%;
  height: 100%;
  display: flex;
}

.coupon-List {
  display: flex;
  flex-direction: column;
  margin: 30rpx 0;

  .line {
    height: 1px;
    background: #fff;
    margin: 0 20rpx;
    position: relative;

    &:before,
    &:after {
      content: '';
      display: block;
      width: 15rpx;
      height: 30rpx;
      background: #fff;
      position: absolute;
      top: -15rpx;
    }

    &:before {
      left: -50rpx;
    }

    &:after {
      right: -50rpx;
    }
  }

  .time {
    flex: 1;
    font-size: 24rpx;
    align-items: center;
    display: flex;
    align-items: center;
	padding-top: 12rpx;
	line-height: 34rpx;
	color: $font-color-baseSub;
  }
}

.top {

  .text {

    display: flex;
    flex-direction: column;
    justify-content: center;
    font-size: 28rpx;
	line-height: 40rpx;
	color: $font-color-baseSub;
    .coupon-List-title {
      font-size: 30rpx;
	  color: $font-color-dark;
    }
  }

  .lingqu-btn {
    display: flex;
    align-items: center;
    margin-left: 40rpx;

    text {
      width: 140rpx;
      height: 40rpx;
      text-align: center;
      line-height: 40rpx;
      color: #fff;
      background: #6772e5;
      border-radius: 5px;
      font-size: 26rpx;

      &.cur {
        background: none;
        transform: rotate(45deg) translate(10rpx, -46rpx);
      }
    }
  }
}
.coupon-item {
  display: flex;
  align-items: center;
  background: #ffece4;
  border-radius: 12rpx;
  padding: 0 14rpx 22rpx 30rpx;
  .left {
    // height: 100%;
    flex: 1;
    position: relative;
    display: flex;
    &::after {
      content: '';
      display: inline-block;
      width: 1px;
      height: 85px;
      margin-top: 18px;
      border-right: 1rpx dashed rgba(#fe6a3d, 0.3);
    }

    .message {
      color: #878787;
      line-height: 40rpx;
      display: flex;
      flex-direction: column;
      margin-top: 14rpx;
      width: 100%;
      .firstMsg {
        font-size: 30rpx;
        color: $font-color-dark;
        .pri {
          font-size: 40rpx;
          color: $light-color;
        }
        .num {
          font-weight: 500;
          font-size: 30rpx;
          line-height: 80rpx;
          color: $light-color;
          // padding-right: 12rpx;
        }
      }
    }

    // .wave-line {
    //   height: 220rpx;
    //   width: 8rpx;
    //   position: absolute;
    //   top: 0;
    //   left: 0;
    //   overflow: hidden;

    //   .wave {
    //     width: 8rpx;
    //     height: 16rpx;
    //     border-radius: 0 16rpx 16rpx 0;
    //     margin-top: 4rpx;
    //   }
    // }

    .circle {
      width: 36rpx;
      height: 36rpx;
      position: absolute;
      border-radius: 50%;
      background: #fff;
      z-index: 111;
    }

    .circle-top {
      top: -18rpx;
      right: -20rpx;
    }

    .circle-bottom {
      bottom: -40rpx;
      right: -20rpx;
    }
  }

  .right {
    padding: 40rpx 0 0 36rpx;

    .lingqu-btn {
      color: $font-color-white;
      background-color: $light-color;
      border-radius: 25rpx;
      width: 130rpx;
      height: 50rpx;
      line-height: 50rpx;
      text-align: center;
      margin-right: 36rpx;
      vertical-align: middle;
      position: relative;
      font-size: 24rpx;
      z-index: 2;
    }
  }
}
</style>
