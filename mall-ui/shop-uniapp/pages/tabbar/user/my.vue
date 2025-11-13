<template>
  <view class="user">
    <!-- 个人信息 -->
    <view class="status_bar">
      <!-- 这里是状态栏 -->
    </view>
    <view class="header" @click="userDetail">
      <view class="head-1">
        <image :src="userInfo.face || userImage"></image>
      </view>
      <view class="head-2" v-if="userInfo.id">
        <view class="user-name">{{ userInfo.nickName }}</view>
      </view>
      <view class="head-2" v-else>
        <view class="user-name">登录/注册</view>
      </view>
      <u-icon
        style="display: flex; align-items: flex-start"
        name="arrow-right"
      ></u-icon>
    </view>
    <!-- 积分，优惠券，关注， -->
    <div class="pointBox box">
      <!-- 我的订单，代付款 -->
      <view class="boxBg boxRadius">
        <!-- 我的订单 -->
        <view class="order">
          <view class="lText">我的订单</view>
          <view
            class="rText"
            @click="navigateTo('/pages/order/myOrder?status=0')"
            >查看全部<icon class="selectIcon iconOpacity"></icon>
          </view>
        </view>
        <!-- end -->
        <view class="fastMenu">
          <view
            class="item"
            @click="navigateTo('/pages/order/myOrder?status=1')"
          >
            <view class="menuIcon">
              <icon class="serve"></icon>
            </view>
            <view class="item">待付款</view>
          </view>
          <view
            class="item"
            @click="navigateTo('/pages/order/myOrder?status=2')"
          >
            <view class="menuIcon">
              <icon class="payment"></icon>
            </view>
            <view class="item">待发货</view>
          </view>
          <view
            class="item"
            @click="navigateTo('/pages/order/myOrder?status=3')"
          >
            <view class="menuIcon">
              <icon class="execute"></icon>
            </view>
            <view class="item">已发货</view>
          </view>
          <view
            class="item"
            @click="navigateTo('/pages/order/myOrder?status=4')"
          >
            <view class="menuIcon">
              <icon class="accomplish"></icon>
            </view>
            <view class="item">已完成</view>
          </view>
          <view
            class="item"
            @click="navigateTo('/pages/order/afterSales/afterSales')"
          >
            <view class="menuIcon">
              <icon class="afterSale"></icon>
            </view>
            <view class="item">售后</view>
          </view>
        </view>
      </view>
    </div>
    <!-- 常用工具 -->
    <div class="pointBox box mt-40">
      <view class="boxBg pd0 boxRadius">
        <tool />
      </view>
    </div>
    <view v-if="userInfo.id" class="myFootBtn">
      <view class="bt" @click="handleOut">退出登录</view>
    </view>
  </view>
</template>
<script>
import tool from '@/pages/tabbar/user/utils/tool.vue';
import { getCouponsNum} from '@/api/members.js';
// import { getUserWallet } from '@/api/members';
import configs from '@/config/config';
export default {
  components: {
    tool,
  },
  data() {
    return {
      configs,
      userImage: configs.defaultUserPhoto,
      coverTransform: 'translateY(0px)',
      coverTransition: '0s',
      moving: false,
      userInfo: {},
      couponNum: '',
      footNum: '',
      walletNum: '',
    };
  },
  onLoad() {},
  onShow() {
    this.userInfo = this.$options.filters.isLogin() || {};
    if (this.$options.filters.isLogin('auth')) {
      this.getUserOrderNum();
    } else {
      this.walletNum = 0;
      this.couponNum = 0;
      this.footNum = 0;
    }
  },
  onPullDownRefresh() {
    this.getUserOrderNum();
    this.userInfo = this.$options.filters.isLogin();
  },
  // #ifndef MP
  onNavigationBarButtonTap(e) {
    const index = e.index;
    if (index === 0) {
      this.navigateTo('/pages/mine/set/setUp');
    }
  },
  // #endif

  mounted() {},
  methods: {
    /**
     * 统一跳转接口,拦截未登录路由
     * navigator标签现在默认没有转场动画，所以用view
     */
    navigateTo(url) {
      uni.navigateTo({
        url,
      });
    },
    userDetail() {
      this.userInfo.id
        ? this.navigateTo('/pages/mine/set/personMsg')
        : this.$options.filters.navigateToLogin();
    },
    async getUserOrderNum() {
      uni.stopPullDownRefresh();

      Promise.all([
        getCouponsNum(), //优惠券
        // getFootprintNum(), //浏览数量
        // getUserWallet(), //预存款
      ]).then((res) => {
        this.couponNum = res[0].data.result;
        // this.footNum = res[1].data.result;
        // this.walletNum = res[2].data.result.memberWallet;
      });
    },
    /**
     * 退出登录
     */
    handleOut() {
      this.$options.filters.quiteLoginOut();
    },
  },
};
</script>
<style lang="scss" scoped>
/deep/ page {
  background: #f8f8f8;
}
html,
body {
  overflow: auto;
}

.money {
  overflow: hidden;

  text-overflow: ellipsis;
  white-space: nowrap;
}

.user {
  background: #f8f8f8;
  height: 100vh;
  .header {
    max-width: 100%;
    padding: calc(140rpx + var(--status-bar-height)) 30rpx 30rpx 6%;
    background-size: cover;
    border-bottom-left-radius: 30rpx;
    border-bottom-right-radius: 30rpx;
    background: linear-gradient(
      rgba(#ffb996, 0.5) 0%,
      rgba(#ffffff73, 0.2) 100%
    );
    background-position: bottom;
    background-repeat: no-repeat;
    color: $font-color-dark;
    display: flex;
    justify-content: space-between;
    align-items: center;

    align-items: center;
    .head-1 {
      text-align: center;
      width: 108rpx;
      position: relative;
      display: flex;
      align-items: center;

      image {
        width: 104rpx;
        height: 104rpx;
        border-radius: 50%;
        border: 1px solid #fff;
      }

      .edti-head {
        position: absolute;
        width: 40rpx;
        height: 40rpx;
        border-radius: 50%;
        background-color: rgba(255, 255, 255, 0.3);
        top: 100rpx;
        right: 0;

        image {
          width: 100%;
          height: 100%;
        }
      }
    }

    .head-2 {
      flex: 1;
      margin-left: 32rpx;
      font-weight: 600;
    }

    // /deep/ .u-icon,
    // .u-icon {
    //   .u-icon__icon {
    //     color: $font-color-white !important;
    //   }
    // }
  }

  .pointBox {
    padding: 0 30rpx;
  }

  .point {
    text-align: center;
    height: 160rpx;

    font-size: $font-sm;
    // #ifdef MP-WEIXIN
    padding: 24rpx;

    // #endif
    .u-col {
      view {
        color: $u-main-color;
        font-size: 28rpx;
      }

      view:last-child {
        margin-top: 8rpx;
        color: $main-color;
        font-size: $font-lg;
      }
    }
  }

  .order {
    font-size: 14;
    line-height: 40rpx;
    display: flex;
    padding: 30rpx 0 0 0;
    .lText {
      flex: 1;
      font-weight: 700;
    }
    .rText {
      color: #151515;
      font-size: 12;
      flex: 1;
      display: flex;
      justify-content: flex-end;
      align-items: center;
      text-align: right;
    }
  }
  .pd0 {
    padding: 0;
  }
}
.user-name {
  font-size: 34rpx;
}

.bag {
  width: 56rpx;
  height: 56rpx;
  border-radius: 50%;
  margin: 0 auto;
}

.bag1 {
  background: #ff4a48;
}

.bag2 {
  background: #ff992f;
}

.bag3 {
  background: #009ee0;
}

.bag4 {
  background: #00d5d5;
}

.bag5 {
  background: #28ccb0;
}
.fastMenu {
  display: flex;
  padding: 40rpx 0;
  .item {
    flex: 1;
    text-align: center;
    color: var(--neutral-color-main);
    font-size: var(--font-size-13);
    line-height: 36rpx;
  }
  .menuIcon {
    display: flex;
    align-items: center;
    justify-content: center;
  }
  icon {
    width: 52rpx;
    height: 52rpx;
    margin-bottom: 18rpx;
  }
  .serve {
    background: url('/static/icon/dzf.png') no-repeat;
    background-size: contain;
  }
  .payment {
    background: url('/static/icon/dfh.png') no-repeat;
    background-size: contain;
  }
  .execute {
    background: url('/static/icon/yfh.png') no-repeat;
    background-size: contain;
  }
  .accomplish {
    background: url('/static/icon/ywc.png') no-repeat;
    background-size: contain;
  }
  .afterSale {
    background: url('/static/icon/sale.png') no-repeat;
    background-size: contain;
    width: 70rpx;
  }
}
.myFootBtn {
  margin: 40rpx 30rpx 0;
  .bt {
    height: 44px;
    line-height: 44px;
    text-align: center;
    font-size: 30rpx;
    background: $font-color-white;
    border-radius: 46rpx;
    border: 0 none;
    box-shadow: none;
  }
}
</style>
