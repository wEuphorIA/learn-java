<template>
  <view class="wrapper">
    <u-navbar :is-back="true" title="我的优惠券"> </u-navbar>
    <view class="b-content" :style="{ paddingTop: capsuleBottom + 'px' }">
      <view class="navbar">
        <!-- 循环出头部tab栏 -->
        <view
          v-for="(item, index) in navList"
          :key="index"
          class="nav-item"
          @click="handleTabClick(index)"
          ><text :class="{ current: tabCurrentIndex === index }">{{
            item.text
          }}</text></view
        >
      </view>
      <swiper
        :current="tabCurrentIndex"
        class="swiper-box"
        duration="300"
        @change="changeTab"
      >
        <swiper-item
          class="tab-content"
          v-for="(navItem, navIndex) in navList"
          :key="navIndex"
        >
          <scroll-view
            class="list-scroll-content"
            scroll-y
            @scrolltolower="loadData"
          >
            <!-- 空白页 -->
            <u-empty
              mode="coupon"
              text="暂无优惠券了"
              v-if="navItem.whetherEmpty"
            ></u-empty>

            <!-- 数据 -->
            <view
              v-if="navItem.dataList && coupon"
              class="coupon-item"
              :class="{ 'coupon-used': navIndex != 0 }"
              v-for="(coupon, index) in navItem.dataList"
              :key="index"
            >
              <view class="left">
                <view class="content">
                  <view class="title-1">{{ coupon.title }}</view>
                  <view class="title-2"
                    >使用范围：{{
                      coupon.scopeType == 'ALL' && coupon.storeId == '0'
                        ? '全平台'
                        : coupon.scopeType == 'PORTION_GOODS'
                        ? '部分商品'
                        : coupon.scopeType == 'PORTION_GOODS_CATEGORY'
                        ? '部分分类商品'
                        : coupon.storeName == 'platform'
                        ? '全平台'
                        : coupon.storeName + ''
                    }}使用</view
                  >
                  <view v-if="coupon.endTime">{{
                    getNow(coupon.endTime)
                  }}</view>
                </view>
                <view class="explain" @click="couponDetail(coupon)"
                  >详细说明
                  <u-icon
                    style="float: right; margin-top: 10rpx"
                    name="arrow-right"
                  ></u-icon>
                </view>
                <view class="circle circle-top"></view>
                <view class="circle circle-bottom"></view>
              </view>
              <view class="right" v-if="coupon">
                <view>
                  <view class="message">
                    <view v-if="coupon.couponType == 'DISCOUNT'"
                      ><span class="num">{{ coupon.discount }}</span
                      ><span class="price">折</span></view
                    >
                    <view class="firstMsg" v-else>
                      <view
                        ><span class="price">￥</span
                        ><span class="num">{{ coupon.price }}</span></view
                      >
                      <view class="sub-price"
                        >满{{ coupon.consumeThreshold | unitPrice }}可用</view
                      >
                    </view>
                  </view>
                  <view
                    class="receive"
                    v-if="navIndex == 0"
                    @click="useItNow(coupon)"
                  >
                    立即使用
                  </view>
                  <view class="past" v-else>{{navIndex == 1?'已使用':'已过期'}}</view>
                </view>
              </view>
            </view>
            <uni-load-more :status="navItem.loadStatus"></uni-load-more>
          </scroll-view>
        </swiper-item>
      </swiper>
    </view>
  </view>
</template>

<script>
import { getMemberCoupons } from '@/api/members.js';
export default {
  data() {
    return {
      tabCurrentIndex: 0, //tab栏下标默认为0 未使用
      navList: [
        //每个tab存储的信息
        {
          text: '未使用',
          loadStatus: 'more',
          dataList: [],
          params: {
            memberCouponStatus: 'NEW',
            pageNumber: 1,
            pageSize: 10,
            status: 1,
          },
          whetherEmpty: false,
        },
        {
          text: '已使用',
          loadStatus: 'more',
          dataList: [],
          params: {
            memberCouponStatus: 'USED',
            pageNumber: 1,
            pageSize: 10,
            status: 2,
          },
          whetherEmpty: false,
        },
        {
          text: '已过期',
          loadStatus: 'more',
          dataList: [],
          params: {
            memberCouponStatus: 'EXPIRE',
            pageNumber: 1,
            pageSize: 10,
            status: 3,
          },
          whetherEmpty: false,
        },
      ],
      couponList: [], //优惠券列表
      capsuleBottom: null,
    };
  },
  onLoad() {
    uni.getSystemInfo({
      success: () => {
        this.capsuleBottom = uni.getMenuButtonBoundingClientRect().bottom + 0;
      },
    });
  },
  onShow() {
    this.navList[this.tabCurrentIndex].params.pageNumber = 1;
    this.navList[this.tabCurrentIndex].dataList = [];
    this.getData();
  },

  watch: {
    /**
     * 监听切换顶部tab栏实现刷新数据
     */
    tabCurrentIndex(val) {
      if (this.navList[val].dataList.length == 0) this.getData();
    },
  },
  methods: {
    /**
     * 顶部tab点击
     */
    handleTabClick(index) {
      this.tabCurrentIndex = index;
    },

    /**
     * 读取优惠券
     */
    getData() {
      uni.showLoading({
        title: '加载中',
      });
      let index = this.tabCurrentIndex;
      getMemberCoupons(this.navList[index].params).then((res) => {
        uni.stopPullDownRefresh();
        if (res.data.success) {
          let data = res.data.result.records;
          if (data.length == 0) {
            if (res.data.pageNumber == 1) {
              this.navList[index].whetherEmpty = true;
            } else {
              this.navList[index].loadStatus = 'noMore';
            }
          } else if (data.length < 10) {
            this.navList[index].loadStatus = 'noMore';
            this.navList[index].dataList.push(...data);
          } else {
            this.navList[index].dataList.push(...data);
          }
        }
        if (this.$store.state.isShowToast) {
          uni.hideLoading();
        }
      });
    },

    /**
     * 切换tab
     */
    changeTab(e) {
      this.tabCurrentIndex = e.target.current;
    },

    /**
     * 加载数据
     */
    loadData() {
      let index = this.tabCurrentIndex;
      if (this.navList[index].loadStatus != 'noMore') {
        this.navList[index].params.pageNumber++;
        this.getData();
      }
    },

    /**
     * 立即使用优惠券
     */
    useItNow(item) {
      uni.navigateTo({
        url: `/pages/navigation/search/searchPage?promotionsId=${item.couponId}&promotionType=COUPON`,
      });
    },

    /**
     * 优惠券详情
     */
    couponDetail(item) {
      uni.navigateTo({
        url:
          '/pages/cart/coupon/couponDetail?item=' +
          encodeURIComponent(JSON.stringify(item)),
      });
    },
    getNow(val) {
      let date = new Date(val);
      let y = date.getFullYear();
      let m = date.getMonth() + 1;
      let d = date.getDate();
      return y + '.' + m + '.' + d;
    },
  },
};
</script>

<style lang="scss" scoped>
page {
  height: 100%;
}
$item-color: #fff;

.b-content {
  background: $page-color-base;
  height: 100%;
}

.swiper-box {
  height: calc(100vh - 40px);
}

.list-scroll-content {
  height: 100%;
  width: 100%;

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
        display: flex;
        justify-content: center;
        align-items: center;
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
      .receive,.past{
        border-radius: 24rpx;
        width: 130rpx;
        height: 48rpx;
        line-height: 48rpx;
        text-align: center;
        margin: 20rpx auto 0;
        position: relative;
      }
      .receive {
        background-color: $font-color-white;
        color: $main-color;
      }
      .past {
        color: rgba($color: #fff, $alpha: 0.56);
        border:1px solid rgba($color: #fff, $alpha: 0.56);
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
  .coupon-used{
    .right{
      background: #B9B9B9;
    }
  }
}
</style>
