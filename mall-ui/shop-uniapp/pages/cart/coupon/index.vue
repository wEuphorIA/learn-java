<template>
  <div class="wrapper">
    <u-navbar :is-back="true" title="优惠券"> </u-navbar>
    <div :style="{ paddingTop: capsuleBottom + 'px' }">
      <u-tabs
        :list="list"
        :is-scroll="false"
        :active-color="lightColor"
        :current="current"
        @change="
          (i) => {
            current = i;
          }
        "
      >
      </u-tabs>

      <div class="empty" v-if="couponsList&&couponsList.length <= 0">
        <emptyTemplate></emptyTemplate>
      </div>
      <view
        class="coupon-item"
        v-for="(item, index) in couponsList"
        :key="index"
      >
        <view class="left">
          <view class="desc">
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
          </view>

          <view class="reason" v-if="item.reason">{{ item.reason }}</view>
          <view class="end-time">有效期至:{{ item.endTime }}</view>
          <view class="circle circle-top"></view>
          <view class="circle circle-bottom"></view>
        </view>
        <view class="right">
          <view>
            <view class="message">
              <view v-if="item.couponType == 'DISCOUNT'">
                <span class="num">{{ item.discount }}</span
                ><span class="price">折</span>
              </view>
              <view class="firstMsg" v-else>
                <view
                  ><span class="price">￥</span
                  ><span class="num">{{ item.price }}</span></view
                >
                
              </view>
              <view class="sub-price"
                  >满{{ item.consumeThreshold | unitPrice }}元可用</view
                >
            </view>
            <view
              class="receive"
              v-if="current == 0 && !routerVal.selectedCoupon.includes(item.id)"
              @click="clickWay(item)"
            >
              <text>立即使用</text>
            </view>
            <view
              class="receive"
              v-if="current == 0 && routerVal.selectedCoupon.includes(item.id)"
              @click="clickWay(item)"
            >
              <text>取消使用</text>
            </view>
          </view>
        </view>
      </view>
    </div>
  </div>
</template>
<script>
import { useCoupon } from '@/api/trade.js';
import emptyTemplate from '@/components/empty/index.vue';
export default {
  components: {
	emptyTemplate
  },
  data() {
    return {
      lightColor: this.$lightColor,
      current: 0,
      list: [
        {
          name: '可用优惠券',
        },
        {
          name: '不可用优惠券',
        },
      ],
      couponsList: [], //优惠券集合
      params: {
        //传参
        memberCouponStatus: 'NEW', //优惠券状态
        pageNumber: 1,
        pageSize: 10,
        scopeId: '', //商品skuid
        storeId: '', //店铺id
        totalPrice: '', //价格
      },
      routerVal: '', //上级传参
      capsuleBottom: null,
    };
  },
  onLoad(options) {
    this.routerVal = options;
    uni.getSystemInfo({
      success: () => {
        this.capsuleBottom = uni.getMenuButtonBoundingClientRect().bottom + 0;
      },
    });
  },
  watch: {
    current(val) {
      console.log(this.$store.state.cantUseCoupons);
      val == 0
        ? (this.couponsList = this.$store.state.canUseCoupons)
        : (this.couponsList = this.$store.state.cantUseCoupons);
    },
  },

  mounted() {
    this.init();
    console.log(this.routerVal);
  },

  methods: {
    /**
     * 从vuex中拿取优惠券信息
     */
    init() {
      this.couponsList = this.$store.state.canUseCoupons;
    },
    /**
     * 领取优惠券
     */
    clickWay(coupon) {
      useCoupon({
        memberCouponId: coupon.id,
        used: !this.routerVal.selectedCoupon.includes(coupon.id),
        way: this.routerVal.way,
      }).then((res) => {
        if (res.data.success) {
          uni.navigateBack();
        } else {
          uni.showToast({
            title: res.data.message,
            duration: 2000,
            icon: 'none',
          });
        }
      });
    },
  },
};
</script>
<style lang="scss">
/deep/ page{
  background: #f2f2f2 !important;
}
</style>
<style scoped lang="scss">
.desc {
  display: flex;
  flex-direction: column;
  justify-content: space-around;
}
.end-time,
.reason {
  color: $font-color-dark;
  line-height:34rpx;
  font-size: 24rpx;
}
.end-time{
  position: absolute;
  bottom: 30rpx;
}
.empty {
  margin-top: 20px;
  text-align: center;
}
.wrapper {
  overflow: hidden;
  /deep/ .u-tab-bar{
    display: none;
  }
}
.coupon-item {
  display: flex;
  align-items: center;
  height: 220rpx;
  margin: 20rpx;
  background: $font-color-white;
  border-radius: 20rpx;

  .left {
    height: 100%;
    flex: 1;
    padding: 32rpx 0 32rpx 40rpx;
    font-size: 24rpx;
    line-height: 36rpx;

    position: relative;

    & > view {
      padding-bottom: 8rpx;
    }
    .explain {
      position: absolute;
      bottom: 32rpx;
      left: 40rpx;
      color: $font-color-baseSub;
    }

    // .wave-line {
    //   height: 220rpx;
    //   width: 8rpx;
    //   position: absolute;
    //   top: 0;
    //   left: 0;
    //   background-color: $light-color;
    //   overflow: hidden;

    //   .wave {
    //     width: 8rpx;
    //     height: 16rpx;
    //     background-color: #ffffff;
    //     border-radius: 0 16rpx 16rpx 0;
    //     margin-top: 4rpx;
    //   }
    // }
    .title-2 {
      padding-bottom: 8rpx;
    }
    .circle {
      width: 36rpx;
      height: 36rpx;
      background-color: $bg-color-sub;
      position: absolute;
      border-radius: 50%;
      z-index: 111;
    }

    .circle-top {
      top: -20rpx;
      right: -20rpx;
    }

    .circle-bottom {
      bottom: -20rpx;
      right: -20rpx;
    }
  }

  .right {
    display: flex;
    justify-content: space-between;
    align-items: center;
    width: 210rpx;
    font-size: $font-sm;
    height: 100%;
    background-color: $light-color;
    overflow: hidden;
    position: relative;
    border-radius: 0 20rpx 20rpx 0;
    & > view {
      width: 100%;
    }
    .message {
      color: $font-color-white;
      text-align: center;

      .price {
        font-size: 40rpx;
      }
      .num {
        font-weight: 500;
        font-size: 68rpx;
        line-height: 80rpx;
        padding-right: 12rpx;
      }
      .sub-price {
        font-size: 20rpx;
      }
    }
    .content {
      color: #666666;
      margin-left: 20rpx;
      line-height: 2em;
      > view:nth-child(1) {
        color: #ff6262;
        font-size: 30rpx;
      }

      .title-1,
      .title-2,
      .title-3 {
        font-size: 25rpx;
      }
    }
    .receive {
      color: #ffffff;
      background-color: $font-color-white;
      border-radius: 24rpx;
      width: 130rpx;
      height: 48rpx;
      line-height: 48rpx;
      text-align: center;
      color: $main-color;
      position: relative;
      margin: 20rpx auto 0;
    }

    .jiao-1 {
      background-color: #ffc71c;
      width: 400rpx;
      transform: rotate(45deg);
      text-align: center;
      position: absolute;
      color: #ffffff;
      right: -130rpx;
      top: 0;
      .text-1 {
        margin-left: 68rpx;
        font-size: 28rpx;
      }
      .text-2 {
        margin-left: 68rpx;
        font-size: 28rpx;
      }
    }
    .no-icon {
      border-radius: 50%;
      width: 86rpx;
      height: 86rpx;
      margin-right: 48rpx;
      position: relative;
      z-index: 2;
    }
    .bg-quan {
      width: 244rpx;
      height: 244rpx;
      border: 6rpx solid $main-color;
      border-radius: 50%;
      opacity: 0.1;
      color: $main-color;
      text-align: center;
      padding-top: 30rpx;
      font-size: 130rpx;
      position: absolute;
      right: -54rpx;
      bottom: -60rpx;
    }
  }
}
</style>
