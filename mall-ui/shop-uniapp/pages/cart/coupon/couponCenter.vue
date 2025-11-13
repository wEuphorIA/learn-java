<template>
  <view class="wrapper">
    <u-navbar :is-back="true" title="领卷中心"> </u-navbar>
    <view class="coupon-center">
      <div class="swiper-box" :style="{ paddingTop: capsuleBottom + 'px' }">
        <div class="swiper-item">
          <div class="scroll-v" enableBackToTop="true" scroll-y>
            <div
              mode="coupon"
              style="margin-top: 20%"
              text="没有优惠券了"
              v-if="whetherEmpty"
            >
            <emptyTemplate></emptyTemplate>
            </div>
            <view
              v-else
              class="coupon-item"
              v-for="(item, index) in couponList"
              :key="index"
            >
              <view class="left">
                <!-- <view class="wave-line">
                  <view
                    class="wave"
                    v-for="(item, index) in 12"
                    :key="index"
                  ></view>
                </view> -->
                <view class="message">
                  <view class="firstMsg">
                    <!--判断当前优惠券类型  couponType  PRICE || DISCOUNT -->
                    <span v-if="item.couponType == 'DISCOUNT'"
                      ><span class="num">{{ item.couponDiscount }}</span
                      >折</span
                    >
                    <span v-else
                      ><span class="pri">￥</span
                      ><span class="num">{{ item.price }}</span
                      >优惠券</span
                    >
                    <!-- <span
                      ><span class="pri">￥</span
                      ><span class="num">{{ item.price }}</span>优惠券</span
                    > -->
                  </view>
                  <view>满{{ item.consumeThreshold | unitPrice }}元可用</view>
                  <view v-if="item.endTime"
                    >有效期至：{{ item.endTime.split(' ')[0] }}</view
                  >
                </view>
                <view class="circle circle-top"></view>
                <view class="circle circle-bottom"></view>
              </view>
              <view class="right">
                <!-- <view> -->
                <!-- 根据scopeType 判断是否是 平台、品类或店铺  -->
                <!-- <view class="coupon-title wes-3" v-if="item.scopeType">
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
                      }}使用
                    </view>
                  </view>
                  <view v-if="item.endTime"
                    >有效期至：{{ item.endTime.split(' ')[0] }}</view
                  > -->
                <!-- </view> -->
                <view class="receive" @click="receive(item)"> 点击领取 </view>
              </view>
            </view>
          </div>
        </div>
      </div>
    </view>
  </view>
</template>

<script>
import { receiveCoupons } from '@/api/members.js';
import { getAllCoupons } from '@/api/promotions.js';
import emptyTemplate from '@/components/empty/index.vue';
export default {
  components: {
    emptyTemplate,
  },
  data() {
    return {
      loadStatus: 'more', //下拉状态
      whetherEmpty: false, //是否为空
      couponList: [], // 优惠券列表
      params: {
        pageNumber: 1,
        pageSize: 10,
      },
      storeId: '', //店铺 id,
      couponData: '',
      capsuleBottom: null,
    };
  },
  onLoad(option) {
    this.storeId = option.storeId;
    this.getCoupon();
    uni.getSystemInfo({
      success: () => {
        this.capsuleBottom = uni.getMenuButtonBoundingClientRect().bottom + 10;
      },
    });
  },
  onReachBottom() {
    this.loadMore();
  },
  onPullDownRefresh() {
    //下拉刷新
    this.params.pageNumber = 1;
    this.couponList = [];
    this.getCoupon();
  },
  methods: {
    /**
     * 获取当前优惠券
     */
    getCoupon() {
      uni.showLoading({
        title: '加载中',
      });
      let submitData = {
        ...this.params,
      };
      // 判断当前是否有店铺
      this.storeId
        ? (submitData = {
            ...this.params,
            storeId: this.storeId,
          })
        : '',
        getAllCoupons(submitData)
          .then((res) => {
            if (this.$store.state.isShowToast) {
              uni.hideLoading();
            }
            uni.stopPullDownRefresh();
            if (res.data.code == 200) {
              // 如果请求成功，展示数据并进行展示
              this.couponData = res.data.result;
              if (this.couponData.total == 0) {
                // 当本次请求数据为空展示空信息
                this.whetherEmpty = true;
              } else {
                this.couponList.push(...this.couponData.records);
                this.loadStatus = 'noMore';
              }
            }
          })
          .catch((err) => {
            if (this.$store.state.isShowToast) {
              uni.hideLoading();
            }
          });
    },
    /**
     * 领取优惠券
     */
    receive(val) {
      this.$u.throttle(() => {
        this.fetchCoupon(val);
      }, 1500);
    },

    fetchCoupon(val) {
      receiveCoupons(val.id).then((res) => {
        if (res.data.code == 200) {
          uni.showToast({
            title: '领取成功',
            icon: 'none',
          });
        } else {
          uni.showToast({
            title: res.data.message,
            icon: 'none',
          });
        }
      });
    },

    /**
     * 加载更多
     */
    loadMore() {
      if (
        this.couponData.total >
        this.params.pageNumber * this.params.pageSize
      ) {
        this.params.pageNumber++;
        this.getCoupon();
      }
    },
  },
  onNavigationBarButtonTap(e) {
    uni.navigateTo({
      url: '/pages/cart/coupon/couponIntro',
    });
  },
};
</script>
<style>
page {
  height: 100%;
  background: #fff;
}
</style>
<style lang="scss" scoped>
.coupon-center {
  height: 100%;

  .swiper-box {
    .coupon-item {
      display: flex;
      align-items: center;
      height: 220rpx;
      margin: 20rpx 30rpx;
      background: #ffece4;
      border-radius: 12rpx;
      padding: 0 0 0 52rpx;
      .left {
        // height: 100%;
        flex: 1;
        position: relative;
        display: flex;
        &::after {
          content: '';
          display: inline-block;
          width: 1px;
          height: 80px;
          margin-top: 3px;
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
            font-weight: 600;
            .pri {
              font-size: 40rpx;
              color: $light-color;
            }
            .num {
              font-weight: 500;
              font-size: 68rpx;
              line-height: 80rpx;
              color: $light-color;
              padding-right: 12rpx;
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
          top: -45rpx;
          right: -20rpx;
        }

        .circle-bottom {
          bottom: -45rpx;
          right: -20rpx;
        }
      }

      .right {
        padding: 0 0 0 36rpx;
        // display: flex;
        // justify-content: space-between;
        // align-items: center;
        // font-size: $font-sm;
        // height: 100%;
        // overflow: hidden;
        // position: relative;

        // > view:nth-child(1) {
        //   color: #666666;
        //   margin-left: 20rpx;
        //   display: flex;
        //   height: 100%;
        //   flex-direction: column;
        //   justify-content: space-around;

        //   > view:nth-child(1) {
        //     color: #ff6262;
        //     font-size: 30rpx;
        //   }
        // }

        .receive {
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
  }
}

.coupon-title {
  width: 260rpx;
}
</style>
