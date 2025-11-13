<template>
  <view class="logistics-detail">
    <u-navbar :is-back="true" title="订单跟踪"> </u-navbar>
    <view class="card" :style="{ paddingTop: capsuleBottom + 'px' }">
      <view class="card-title">
        <span>{{ logiList.shipper }}</span
        >快递 <span>{{ logiList.logisticCode }}</span>
      </view>
      <view class="time-line">
        <u-time-line v-if="logiList.traces && logiList.traces.length != 0">
          <u-time-line-item
            nodeTop="2"
            v-for="(item, index) in logiList.traces"
            :key="index"
          >
            <!-- 此处自定义了左边内容，用一个图标替代 -->
            <template v-slot:node>
              <view
                v-if="index == logiList.traces.length - 1"
                class="u-node"
                :style="{ background: $lightColor }"
                style="padding: 0 4px"
              >
                <!-- 此处为uView的icon组件 -->
                <u-icon name="pushpin-fill" color="#fff" :size="24"></u-icon>
              </view>
            </template>
            <template v-slot:content>
              <view>
                <!-- <view class="u-order-title">待取件</view> -->
                <view class="u-order-desc">{{ item.AcceptStation }}</view>
                <view class="u-order-time">{{ item.AcceptTime }}</view>
              </view>
            </template>
          </u-time-line-item>
        </u-time-line>
        <div class="empty" v-else>
          <emptyTemplate :tipInfo="tipInfo"></emptyTemplate>
        </div>
      </view>
    </view>
  </view>
</template>

<script>
import { getExpress } from '@/api/trade.js';
import emptyTemplate from '@/components/empty/index.vue';
export default {
  components: {
    emptyTemplate,
  },
  data() {
    return {
      express: '',
      resData: {
        title: '物流详情',
      },

      logiList: '',
      activeStep: 0,
      tipInfo: '目前没有物流订单',
      capsuleBottom: null,
    };
  },
  methods: {
    init(sn) {
      getExpress(sn).then((res) => {
        this.logiList = res.data.result;
      });
    },
  },
  onLoad(option) {
    let sn = option.order_sn;
    this.init(sn);
    uni.getSystemInfo({
      success: () => {
        this.capsuleBottom = uni.getMenuButtonBoundingClientRect().bottom + 0;
      },
    });
  },
};
</script>

<style lang="scss">
.card-title {
  background: #f2f2f2;
}
.logistics-detail {
  margin-top: 20rpx;
  padding: 0 16rpx;
}
.card {
  background: #fff;
  border-radius: 20rpx;
  width: 100%;
  > .card-title {
    font-size: 24rpx;
    border-radius: 30rpx;
    height: 60rpx;
    line-height: 60rpx;
    padding: 0 18rpx;
  }
  > .time-line {
    padding: 16rpx 32rpx;
  }
}
.u-order-title {
  font-weight: bold;
}
.u-order-desc {
  font-size: 26rpx;
  color: #666;
  margin: 10rpx 0;
}
.u-order-time {
  font-size: 24rpx;
  color: #999;
}
.empty {
  padding: 40rpx 0;
}
</style>
