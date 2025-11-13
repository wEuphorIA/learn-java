<template>
  <view class="sale">
    <u-navbar title="青橙秒杀"></u-navbar>
    <view :style="{ paddingTop: capsuleBottom + 'px' }">
      <view class="header-wraper">
        <image mode="widthFix" src="/static/seckill.png"></image>
        <div class="navBg">
          <scroll-view scroll-x class="scrollBox">
            <view class="index-navs">
              <view class="index-nav-v">
                <view
                  class="index-nav"
                  :class="{ 'index-nav-active': nav == index }"
                  @click="clickNavigateTime(index,item)"
                  v-for="(item, index) in timeLine"
                  :key="index"
                >
                  <span class="active"></span>
                  <view class="text">
                    {{ item.timeLine }}:00
                    <view class="index-nav-desc"
                      >{{
                        index === 0 && item.distanceStartTime ==='0'
                          ? '抢购中'
                          : '即将开始'
                      }}
                    </view>
                  </view>
                </view>
              </view>
            </view>
          </scroll-view>
        </div>
      </view>

      <view class="sale-items">
        <view v-if="goodsList.length > 0">
          <goodsTemplate :res="goodsList" :goodStartTime="goodStartTime" />
        </view>
        <view v-else>
          <emptyTemplate></emptyTemplate>
        </view>
      </view>
    </view>
  </view>
</template>

<script>
import { getSeckillTimeLine, getSeckillTimeGoods } from '@/api/promotions.js';
import Foundation from '@/utils/Foundation.js';
import goodsTemplate from '@/components/m-goods-list/promotion.vue';
import emptyTemplate from '@/components/empty/index.vue';
export default {
  components: {
    goodsTemplate,
    emptyTemplate,
  },
  data() {
    return {
      nav: 0, //默认选择第一个时间
      timeLine: '', //获取几个点活动
      resTime: 0, //当前时间
      time: 0, //距离下一个活动的时间值
      times: {}, //时间集合
      onlyOne: '', //是否最后一个商品
      goodsList: [], //商品集合
      params: {
        pageNumber: 1,
        pageSize: 10,
      },
      capsuleBottom: null,
      goodStartTime:''
    };
  },

  /**
   * 显示时间活动
   */
  async onShow() {
    await this.getTimeLine();
    if (!this.timeLine) {
      await uni.showToast({
        icon: 'none',
        duration: 2000,
        title: '今天没有活动，明天再来吧',
      });
    }
    this._setTimeInterval = setInterval(() => {
      if (this.time <= 0) {
        clearInterval(this._setTimeInterval);
        this.getGoodsList();
        this.getTimeLine();
      } else {
        this.times = Foundation.countTimeDown(this.time);
        this.time--;
      }
    }, 1000);
  },
  mounted() {
    uni.getSystemInfo({
      success: () => {
        this.capsuleBottom = uni.getMenuButtonBoundingClientRect().bottom + 10;
      },
    });
  },
  onUnload() {
    this._setTimeInterval && clearInterval(this._setTimeInterval);
  },
  methods: {
    /**
     * 获取时间线商品
     */
    async getTimeLine() {
      let res = await getSeckillTimeLine();
      if (res.data.success && res.data.result.length > 0) {
        let timeLine = res.data.result.sort(
          (x, y) => Number(x.timeLine) - Number(y.timeLine)
        );
        this.timeLine = timeLine.slice(0, 5);
        this.resTime = parseInt(new Date().getTime() / 1000);
        this.onlyOne = res.data.result.length === 1;
        this.diffTime = parseInt(new Date().getTime() / 1000) - this.resTime;

        this.time =
          this.timeLine[this.nav].distanceStartTime ||
          (this.timeLine[this.nav + 1] &&
            this.timeLine[this.nav + 1].distanceStartTime) ||
          Foundation.theNextDayTime() - this.diffTime;
        this.times = Foundation.countTimeDown(this.time);

        this.getGoodsList();
      }
    },

    /**
     * 获取商品集合
     */
    async getGoodsList() {
      this.params.timeLine = this.timeLine[this.nav].timeLine;
      let res = await getSeckillTimeGoods(this.params.timeLine);
      if (res.data.success && res.data.result.length != 0) {
        this.goodsList = res.data.result;
      } else {
        this.goodsList = [];
      }
    },

    /**
     * 单击导航时间
     */
    clickNavigateTime(type,item) {
      this.goodStartTime=item.startTime
      this.nav = type;
      this.goodsList = [];
      this.diffTime = parseInt(new Date().getTime() / 1000) - this.resTime;
      this.time =
        this.timeLine[this.nav].distanceStartTime ||
        (this.timeLine[this.nav + 1] &&
          this.timeLine[this.nav + 1].distanceStartTime) ||
        Foundation.theNextDayTime() - this.diffTime;

      this.times = Foundation.countTimeDown(this.time);
      this.getGoodsList();
    },
  },
};
</script>
<style lang="scss">
/deep/ page {
  background-color: #f9f9f9;
}
</style>
<style lang="scss" scoped>
.sale {
  width: 100%;
  min-height: 100vh;
  background-color: #f7f7f7;
}

.header-wraper {
  background: url('/static/pic-bj.png');
  background-size: contain;
  height: 256rpx;
  display: flex;
  justify-content: center;
  position: relative;
  > image {
    width: 120rpx;
    margin-top: 30rpx;
  }
}

.sale-items {
  margin-top: -42rpx;
  background: #f9f9f9;
  height: 100%;
  border-radius: 24rpx;
  position: relative;
  z-index: 99;
  padding: 48rpx 24rpx 0;
  /deep/ .goods-row{
    padding: 28rpx 24rpx;
  }
}
.scrollBox {
  // margin-top: -110rpx;
  position: absolute;
  bottom: 0;
  left: 0;
}
.navBg {
  position: absolute;
  bottom: 0;
  left: 0;
  background-color: rgba(#fff, 0.18);
  border-radius: 12px 15px 16px 12px 0 0;
  height: 70px;
  width: 100%;
}
.index-navs {
  display: -webkit-box;
  display: -webkit-flex;
  display: flex;
  align-items: flex-start;
  justify-content: space-between;
  height: 70px;
}

.index-nav-v {
  display: -webkit-box;
  display: -webkit-flex;
  display: flex;
  justify-content: center;
  align-items: center;
  position: relative;
  .index-nav-active {
    width: 230rpx;
    .active {
      padding-top: 0 !important;
      background: url('/static/menuOn.png') no-repeat;
      background-size: 100%;
      height: 115rpx;
      position: absolute;
      width: 230rpx;
      top: 0;
      left: 0;
      z-index: 0;
    }
    .text {
      position: relative;
      z-index: 9;
    }
  }
}

.index-nav {
  display: -webkit-box;
  display: -webkit-flex;
  display: flex;
  justify-content: center;
  align-items: center;
  width: 150rpx;
  flex-direction: column;
  color: #ffffff;
  position: relative;
  font-size: 36rpx;
  font-weight: bold;
  padding-top: 5px;

  &-active {
    color: $main-color;
    position: relative;
    z-index: 30;
    align-items: flex-start;
    padding-left: 46rpx;
    .index-nav-desc {
      color: $main-color;
      font-size: 26rpx;
      font-weight: normal;
    }
  }
}

.index-nav-desc {
  font-size: 26rpx;
  color: rgba($color: #fff, $alpha: 0.46);
  font-weight: normal;
}
</style>
