<template>
  <view class="wrapper">
    <u-navbar :is-back="true" title="我的订单"> </u-navbar>
    <view class="content" :style="{ paddingTop: capsuleBottom + 'px' }">
      <view class="navbar">
        <view
          v-for="(item, index) in navList"
          :key="index"
          class="nav-item"
          :class="{ current: tabCurrentIndex === index }"
          @click="tabClick(index)"
          >{{ item.text }}</view
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
          v-for="(tabItem, tabIndex) in navList"
          :key="tabIndex"
        >
          <scroll-view
            class="list-scroll-content"
            scroll-y
            @scrolltolower="loadData(tabIndex)"
          >
            <!-- 空白页 -->
            <div
              text="暂无订单"
              mode="list"
              v-if="tabItem.loaded === true && tabItem.orderList.length === 0"
            >
            <emptyTemplate></emptyTemplate>
            </div>
            <!-- 订单列表 -->
            <view
              class="seller-view"
              :key="oderIndex"
              v-for="(order, oderIndex) in tabItem.orderList"
            >
              <!-- 店铺名称 -->
              <view class="seller-info u-flex u-row-between">
                <view class="seller-name wes" @click="navigateToStore(order)">
                  <view class="name wes">{{ order.storeName }}</view>
                  <view class="uIcon"
                    ><u-icon
                      style="display: flex; align-items: flex-start"
                      name="arrow-right"
                    ></u-icon
                  ></view>
                </view>
                <view class="order-sn" :class="order.orderStatus">{{
                  order.orderStatus | orderStatusList
                }}</view>
              </view>
              <view>
                <view>
                  <view
                    class="goods-item-view"
                    @click="navigateToOrderDetail(order.sn)"
                  >
                    <view
                      class="goods-img"
                      v-for="(goods, goodsIndex) in order.orderItems"
                      :key="goodsIndex"
                    >
                      <u-image
                        border-radius="6"
                        width="100%"
                        height="100%"
                        :src="goods.image"
                      ></u-image>
                    </view>
                    <view class="goods-info">
                      <view
                        v-if="order.orderItems.length <= 1"
                        class="goods-title u-line-2"
                        >{{ order.groupName }}</view
                      >
                      <view
                        v-if="order.orderItems.length <= 1"
                        class="goods-price"
                      >
                        ￥{{ order.flowPrice | unitPrice }}
                      </view>
                    </view>
                    <view v-if="order.orderItems.length <= 1" class="goods-num">
                      <view>x{{ order.groupNum }}</view>
                    </view>
                  </view>
                </view>
                <view class="btn-view u-flex u-row-between">
                  <view class="description">
                    <!-- 等待付款 -->
                    <div v-if="order.payStatus === 'PAID'">已付金额:</div>
                    <div v-else>应付金额：</div>
                    <div class="priceInof">
                      ￥<span class="price">{{
                        order.flowPrice | unitPrice
                      }}</span>
                    </div>
                  </view>
                  <view class="goods-btn flex flex-a-c">
                    <!-- 全部 -->
                    <view
                      ripple
                      class="pay-btn"
                      shape="circle"
                      size="mini"
                      v-if="order.allowOperationVO.pay"
                      @click="waitPay(order)"
                      >立即付款</view
                    >
                    <!-- 取消订单 -->
                    <view
                      ripple
                      class="cancel-btn"
                      shape="circle"
                      size="mini"
                      v-if="order.allowOperationVO.cancel"
                      @click="onCancel(order.sn)"
                    >
                      取消订单
                    </view>
                    <!-- 等待收货 -->
                    <view
                      ripple
                      shape="circle"
                      class="subBtn"
                      size="mini"
                      v-if="order.allowOperationVO.showLogistics"
                      @click="navigateToLogistics(order)"
                    >
                      查看物流
                    </view>
                    <view
                      ripple
                      shape="circle"
                      class="pay-btn"
                      size="mini"
                      v-if="order.allowOperationVO.rog"
                      @click="onRog(order.sn)"
                    >
                      确认收货
                    </view>
                    <view
                      ripple
                      shape="circle"
                      class="sub-btn"
                      size="mini"
                      v-if="
                        order.groupAfterSaleStatus &&
                        (order.groupAfterSaleStatus.includes('NOT_APPLIED') ||
                          order.groupAfterSaleStatus.includes(
                            'PART_AFTER_SALE'
                          ))
                      "
                      @click="applyService(order)"
                    >
                      退款/售后
                    </view>
                    <!-- TODO 后续完善 -->
                    <!-- <u-button ripple shape="circle" class="rebuy-btn" size="mini" v-if="
                      order.orderStatus === 'CANCELLED' ||
                      order.orderStatus === 'COMPLETE'
                    " @click="reBuy(order)">
                    再次购买
                  </u-button> -->
                  </view>
                </view>
              </view>
            </view>
            <uni-load-more :status="tabItem.loadStatus"></uni-load-more>
          </scroll-view>
        </swiper-item>
      </swiper>
      <u-popup
        class="cancel-popup"
        v-model="cancelShow"
        mode="bottom"
        length="60%"
      >
        <view class="header">取消订单</view>
        <view class="body">
          <view class="title"
            >取消订单后，本单享有的优惠可能会一并取消，是否继续？</view
          >
          <view>
            <u-radio-group v-model="reason">
              <view class="value">
                <view
                  class="radio-view"
                  :key="index"
                  v-for="(item, index) in cancelList"
                >
                  <u-radio
                    :active-color="lightColor"
                    label-size="25"
                    shape="circle"
                    :name="item.reason"
                    @change="reasonChange"
                    >{{ item.reason }}</u-radio
                  >
                </view>
              </view>
            </u-radio-group>
          </view>
        </view>
        <view class="footer">
          <u-button
            v-if="reason"
            @click="submitCancel"
            >提交</u-button
          >
        </view>
      </u-popup>
      <u-toast ref="uToast" />
      <u-modal
        :confirm-color="lightColor"
        v-model="rogShow"
        :show-cancel-button="true"
        :content="'是否确认收货?'"
        @confirm="confirmRog"
      ></u-modal>
    </view>
  </view>
</template>

<script>
import uniLoadMore from '@/components/uni-load-more/uni-load-more.vue';
import { getOrderList, cancelOrder, confirmReceipt } from '@/api/order.js';
import { getClearReason } from '@/api/after-sale.js';
import LiLiWXPay from '@/js_sdk/lili-pay/wx-pay.js';
import emptyTemplate from '@/components/empty/index.vue';
export default {
  components: {
    uniLoadMore,
    emptyTemplate,
  },
  data() {
    return {
      lightColor: this.$lightColor,
      tabCurrentIndex: 0, //导航栏索引
      navList: [
        //导航栏list
        {
          state: 0,
          text: '全部',
          loadStatus: 'more',
          orderList: [],
          pageNumber: 1,
        },
        {
          state: 1,
          text: '待付款',
          loadStatus: 'more',
          orderList: [],
          pageNumber: 1,
        },
        {
          state: 2,
          text: '待发货',
          loadStatus: 'more',
          orderList: [],
          pageNumber: 1,
        },
        {
          state: 3,
          text: '待收货',
          loadStatus: 'more',
          orderList: [],
          pageNumber: 1,
        },
        {
          state: 4,
          text: '已完成',
          loadStatus: 'more',
          orderList: [],
          pageNumber: 1,
        },
        {
          state: 5,
          text: '已取消',
          loadStatus: 'more',
          orderList: [],
          pageNumber: 1,
        },
      ],
      status: '', //接收导航栏状态
      params: {
        pageNumber: 1,
        pageSize: 10,
        tag: 'ALL',
      },
      orderStatus: [
        //订单状态
        {
          orderStatus: 'ALL', //全部
        },
        {
          orderStatus: 'WAIT_PAY', //代付款
        },
        {
          orderStatus: 'WAIT_SHIP',
        },
        {
          orderStatus: 'WAIT_ROG', //待收货
        },
        {
          orderStatus: 'COMPLETE', //已完成
        },
        {
          orderStatus: 'CANCELLED', //已取消
        },
        {
          orderStatus: 'STAY_PICKED_UP', //待自提
        },
      ],
      cancelShow: false, //是否显示取消
      orderSn: '', //ordersn
      reason: '', //取消原因
      cancelList: '', //取消列表
      rogShow: false, //显示是否收货
      capsuleBottom: null,
    };
  },

  /**
   * 跳转到个人中心
   */
  onBackPress(e) {
    if (e.from == 'backbutton') {
      uni.switchTab({
        url: '/pages/tabbar/user/my',
      });
      return true; //阻止默认返回行为
    }
  },
  onPullDownRefresh() {
    if (this.tabCurrentIndex) {
      this.initData(this.tabCurrentIndex);
    } else {
      this.initData(0);
    }
    // this.loadData(this.status);
  },
  onShow() {
    if (this.$options.filters.tipsToLogin()) {
      if (!this.tabCurrentIndex) {
        this.initData(0);
      }
    }
    // this.loadData(this.status);
  },

  onLoad(options) {
    /**
     * 修复app端点击除全部订单外的按钮进入时不加载数据的问题
     * 替换onLoad下代码即可
     */
    let status = Number(options.status);
    this.status = status;

    this.tabCurrentIndex = status;
    // if (status == 0) {
    //   this.loadData(status);
    // }
    uni.getSystemInfo({
      success: () => {
        this.capsuleBottom = uni.getMenuButtonBoundingClientRect().bottom + 0;
      },
    });
  },

  watch: {
    /**监听更改请求数据 */
    tabCurrentIndex(val) {
      this.params.tag = this.orderStatus[val].orderStatus;
      //切换标签页将所有的页数都重置为1
      this.navList.forEach((res) => {
        res.pageNumber = 1;
        res.loadStatus = 'more';
        res.orderList = [];
      });
      this.loadData(val);
    },
  },
  methods: {
    // 售后
    applyService(order) {
      uni.navigateTo({
        url: `/pages/order/afterSales/afterSales?orderSn=${order.sn}`,
      });
    },

    // 店铺详情
    navigateToStore(val) {
      uni.navigateTo({
        url: '/pages/product/shopPage?id=' + val.storeId,
      });
    },

    /**
     * 取消订单
     */
    onCancel(sn) {
      this.orderSn = sn;
      this.cancelShow = true;
      uni.showLoading({
        title: '加载中',
      });
      getClearReason().then((res) => {
        if (res.data.result.length >= 1) {
          this.cancelList = res.data.result;
        }
        if (this.$store.state.isShowToast) {
          uni.hideLoading();
        }
      });
    },

    /**
     * 初始化数据
     */
    initData(index) {
      this.navList[index].pageNumber = 1;
      this.navList[index].loadStatus = 'more';
      this.navList[index].orderList = [];
      this.loadData(index);
    },

    /**
     * 等待支付
     */
    waitPay(val) {
      this.$u.debounce(this.pay(val), 3000);
    },

    /**
     * 支付
     */
    pay(val) {
      if (val.sn) {
        uni.navigateTo({
          url: '/pages/cart/payment/payOrder?order_sn=' + val.sn,
        });
        // // #ifdef MP-WEIXIN
        // new LiLiWXPay({
        //   sn: val.sn,
        //   price: val.flowPrice,
        //   orderType: 'ORDER',
        // }).pay();
        // // #endif
        // // #ifndef MP-WEIXIN
        // uni.navigateTo({
        //   url: '/pages/cart/payment/payOrder?order_sn=' + val.sn,
        // });
        // // #endif
      }
    },

    /**
     * 获取订单列表
     */
    loadData(index) {
      this.params.pageNumber = this.navList[index].pageNumber;
      // this.params.tag = this.orderStatus[index].orderStatus;
      getOrderList(this.params).then((res) => {
        uni.stopPullDownRefresh();
        if (!res.data.success) {
          this.navList[index].loadStatus = 'noMore';
          return false;
        }
        let orderList = res.data.result.records;
        if (orderList.length == 0) {
          this.navList[index].loadStatus = 'noMore';
        } else if (orderList.length < 10) {
          this.navList[index].loadStatus = 'noMore';
        }
        if (orderList.length > 0) {
          this.navList[index].orderList =
            this.navList[index].orderList.concat(orderList);
          this.navList[index].pageNumber += 1;
        }
      });
    },
    //swiper 切换监听
    changeTab(e) {
      this.tabCurrentIndex = e.target.current;
    },
    //顶部tab点击
    tabClick(index) {
      this.tabCurrentIndex = index;
    },
    //删除订单
    deleteOrder(index) {
      uni.showLoading({
        title: '请稍后',
      });
      setTimeout(() => {
        this.navList[this.tabCurrentIndex].orderList.splice(index, 1);
        if (this.$store.state.isShowToast) {
          uni.hideLoading();
        }
      }, 600);
    },
    //取消订单
    cancelOrder(item) {
      uni.showLoading({
        title: '请稍后',
      });
      setTimeout(() => {
        let { stateTip, stateTipColor } = this.orderStateExp(9);
        item = Object.assign(item, {
          state: 9,
          stateTip,
          stateTipColor,
        });

        //取消订单后删除待付款中该项
        let list = this.navList[1].orderList;
        let index = list.findIndex((val) => val.id === item.id);
        index !== -1 && list.splice(index, 1);
        if (this.$store.state.isShowToast) {
          uni.hideLoading();
        }
      }, 600);
    },

    //订单状态文字和颜色
    orderStateExp(state) {
      let stateTip = '',
        stateTipColor = this.$lightColor;
      switch (+state) {
        case 1:
          stateTip = '待付款';
          break;
        case 2:
          stateTip = '待发货';
          break;
        case 9:
          stateTip = '订单已关闭';
          stateTipColor = '#909399';
          break;

        //更多自定义
      }
      return {
        stateTip,
        stateTipColor,
      };
    },

    /**
     * 跳转到订单详情
     */
    navigateToOrderDetail(sn) {
      uni.navigateTo({
        url: './orderDetail?sn=' + sn,
      });
    },

    /**
     * 选择取消原因
     */
    reasonChange(reason) {
      this.reason = reason;
    },

    /**
     * 提交取消订单（未付款）
     */
    submitCancel() {
      cancelOrder(this.orderSn, { reason: this.reason }).then((res) => {
        if (res.data.success) {
          uni.showToast({
            title: '订单已取消',
            duration: 2000,
            icon: 'none',
          });
          this.initData(this.tabCurrentIndex);

          this.cancelShow = false;
        } else {
          uni.showToast({
            title: res.data.message,
            duration: 2000,
            icon: 'none',
          });
          this.cancelShow = false;
        }
      });
    },

    /**
     * 确认收货显示
     */
    onRog(sn) {
      this.orderSn = sn;
      this.rogShow = true;
    },

    /**
     * 点击确认收货
     */
    confirmRog() {
      confirmReceipt(this.orderSn).then((res) => {
        if (res.data.code == 200) {
          uni.showToast({
            title: '已确认收货',
            duration: 2000,
            icon: 'none',
          });
          this.initData(this.tabCurrentIndex);
          this.rogShow = false;
        }
      });
    },

    /**
     * 评价商品
     */
    onComment(sn) {
      uni.navigateTo({
        url: './evaluate/myEvaluate',
      });
    },

    /**
     * 重新购买
     */
    reBuy(order) {
      console.log(order);
      return;
      uni.navigateTo({
        url:
          '/pages/product/goods?id=' + order.id + '&goodsId=' + order.goodsId,
      });
    },

    /**
     * 查看物流
     */
    navigateToLogistics(order) {
      uni.navigateTo({
        url:
          '/pages/mine/msgTips/packageMsg/logisticsDetail?order_sn=' + order.sn,
      });
    },
  },
};
</script>

<style lang="scss" scoped>
page,
.content {
  background: $page-color-base;
  height: 100%;
}

.swiper-box {
  height: calc(100vh - 40px);
  // #ifdef H5
  height: calc(100vh - 40px - 44px);
  // #endif
  padding: 0 20rpx;
}

.list-scroll-content {
  height: 100%;
}
.uni-swiper-item {
  height: auto;
}

.seller-view {
  border-radius: 20rpx;
  background-color: #fff;
  margin: 20rpx 0rpx;
  padding: 36rpx 24rpx 28rpx;

  .seller-info {
    height: 42rpx;
    line-height: 42rpx;
    margin-bottom: 24rpx;
    .seller-name {
      height: 42rpx;
      line-height: 42rpx;
      flex: 10;
      font-size: 30rpx;
      display: flex;
      align-items: center;
      .uIcon {
        font-size: 20rpx;
        margin-left: 14rpx;
      }
    }

    .order-sn {
      color: $font-color-dark;
      font-size: 24rpx;
    }
    .UNPAID {
      color: $uni-color-error;
    }
    .WAIT_ROG,
    .COMPLETED,
    .DELIVERED,
    .STAY_PICKED_UP {
      color: $main-color;
    }
    .CANCELLED {
      color: #151515;
    }
  }

  .goods-item-view {
    display: flex;
    flex-wrap: wrap;
    flex-direction: row;
    .goods-img {
      width: 200rpx;
      height: 200rpx;
      border-radius: 24rpx;
      margin-right: 10rpx;
      /deep/ .u-image__image {
        border-radius: 24rpx !important;
      }
    }

    .goods-info {
      padding-left: 10rpx;
      flex: 1;
      position: relative;

      .goods-title {
        margin-bottom: 10rpx;
        color: $font-color-dark;
        font-size: 26rpx;
      }

      .goods-specs {
        font-size: 24rpx;
        margin-bottom: 10rpx;
        color: #878787;
      }

      .goods-price {
        font-size: 28rpx;
        margin-bottom: 10rpx;
        color: $font-color-dark;
        position: absolute;
        font-weight: 600;
        left: 0;
        bottom: 0;
      }
    }

    .goods-num {
      color: $font-color-baseSub;
      font-size: 24rpx;
    }
  }

  .btn-view {
    padding: 20rpx 0 0;
    font-size: 26rpx;

    .description {
      display: flex;
      size: 24rpx;
      align-content: center;
      flex: 1;
      line-height: 60rpx;
      .priceInof {
        display: flex;
        align-items: center;
        color: $main-color;
      }
      .price {
        
        font-size: 34rpx;
        // font-weight: 600;
      }
    }
  }

  // {
  //         orderStatus: 'WAIT_PAY', //代付款
  //       },
  //       {
  //         orderStatus: 'WAIT_SHIP',
  //       },
  //       {
  //         orderStatus: 'WAIT_ROG', //待收货
  //       },
  //       {
  //         orderStatus: 'COMPLETE', //已完成
  //       },
  //       {
  //         orderStatus: 'CANCELLED', //已取消
  //       },
  //       {
  //         orderStatus: 'STAY_PICKED_UP', //待自提
  //       },
}


.goods-btn {
  display: flex;
  .rebuy-btn{
    margin-left: 0;
  }
}
</style>
