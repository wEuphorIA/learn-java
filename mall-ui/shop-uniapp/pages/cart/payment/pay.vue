<template>
  <div class="wrapper">
    <u-navbar :is-back="true" title="支付订单"></u-navbar>
    <view :style="{ paddingTop: capsuleBottom + 'px' }">
      <div class="orderBox">
        <div class="tit">订单提交成功！</div>
        <div class="text">请您尽快完成支付，否则订单会被自动取消</div>
        <div class="qr">
          <div class="srCan">
            <view class="qr-box" v-if="qrShow"
              ><canvas canvas-id="qrcode"
            /></view>
            <image :src="qrCodeImg" v-else></image>
          </div>
          <view class="text-center">请用微信扫码付款</view>
        </div>
        <div class="tip">支付成功后自动跳转，如未跳转请点击按钮手动跳转...</div>
        <div class="footer">
          <button type="default" class="subBtn" @click="handleReset">
            重新支付
          </button>
          <button type="default" class="btn" @click="handleSave">
            支付成功
          </button>
        </div>
      </div>
    </view>
  </div>
</template>
<script>
import * as API_Trade from '@/api/trade';
import { payCallback } from '@/api/members';
import uQRCode from '@/utils/uqrcode.js'; //引入uqrcode.js
export default {
  data() {
    return {
      capsuleBottom: null,
      baseData: {},
      qrcode: null,
      qrShow: false,
      interval: null, // 定时器
      num: 0, // 商品数
      qrCodeImg: '', //二维码图片
    };
  },
  onLoad(val) {
    uni.getSystemInfo({
      success: () => {
        this.capsuleBottom = uni.getMenuButtonBoundingClientRect().bottom + 10;
      },
    });
    this.baseData = JSON.parse(decodeURIComponent(val.item));
    this.getCode(this.baseData);
  },
  mounted() {
    // 10秒钟监听一下付款状态是否付款
    this.interval = setInterval(() => {
      this.callback(this.baseData);
    }, 10000);
  },
  methods: {
    //   获取支付二维码
    async getCode(item) {
      console.log(item);
      await API_Trade.initiatePay(
        item.paymentMethod,
        item.paymentClient,
        item
      ).then((res) => {
        let response = res.data.result;
        //如果支付异常
        if (!res.data.success) {
          uni.showModal({
            content: res.data.message,
            showCancel: false,
          });
          return;
        }
        const str = response.slice(0, 10);
        // 以base图片显示二维码
        if (str === 'data:image') {
          this.qrCodeImg = response.replace(/[\r\n]/g, '');
        } else {
          // 后端直接返回的二维码地址，需要前端处理一下返回的二维码地址
          this.qrCodeFun(response);
        }
      });
    },
    // 处理后端返回的地址生成二维码
    qrCodeFun(valUrl) {
      this.qrShow = true;
      uQRCode.make({
        canvasId: 'qrcode', //放置在哪个标签中，将ID设置为相同
        componentInstance: this,
        text: valUrl, //valUrl为存放要传输的数据的变量
        size: 208, //大小左右都为200 ！注意要和容器大小一致
        margin: 0, //不改变大小添加白色边框
        backgroundColor: '#ffffff',
        foregroundColor: '#000000',
        fileType: 'jpg',
        errorCorrectLevel: uQRCode.errorCorrectLevel.H,
        success: (res) => {},
      });
    },
    callback(item) {
      // 支付回调接口
      this.num++;
      if (this.num >= 7) {
        clearInterval(this.interval);
        this.interval = null;
      }
      let params = {
        orderType: item.orderType,
        sn: item.sn,
        clientType: item.clientType,
        price: item.price,
      };
      payCallback(params).then((res) => {
        if (res.result) {
          clearInterval(this.interval);
          this.interval = null;
          uni.navigateTo({
            url:
              '/pages/cart/payment/success?paymentMethod=' +
              item.paymentMethod +
              '&payPrice=' +
              item.price +
              '&orderType=' +
              item.orderType,
          });
        }
      });
    },
    // 重新支付
    handleReset() {
      this.getCode(this.baseData);
    },
    // 支付成功
    handleSave() {
      const searchParams = {
        clientType: this.baseData.clientType,
        orderType: this.baseData.orderType,
        sn: this.baseData.sn,
        price: this.baseData.price,
      };
      payCallback(searchParams).then((res) => {
        if (res.data.result) {
          clearInterval(this.interval);
          this.interval = null;
          uni.navigateTo({
            url: '/pages/order/myOrder',
          });
        } else {
          uni.showModal({
            content: '支付失败,如果您已支付，请勿反复支付',
            showCancel: false,
          });
        }
      });
      // uni.navigateTo({
      //   url:
      //     '/pages/cart/payment/success?paymentMethod=' +
      //     this.baseData.paymentMethod +
      //     '&payPrice=' +
      //     this.baseData.price +
      //     '&orderType=' +
      //     this.baseData.orderType,
      // });
    },
  },
};
</script>
<style scoped lang="scss">
.orderBox {
  text-align: center;
  color: $font-color-dark;
  padding-top: 80rpx;
  .tit {
    font-size: 16px;
    font-weight: 600;
    padding-bottom: 20rpx;
  }
  .text {
    color: $font-color-dark19;
    padding-bottom: 20rpx;
  }
  .tip {
    padding-top: 20rpx;
  }
  .footer {
    padding: 60rpx;
    display: flex;
    align-items: center;
    button {
      margin: 0 20rpx;
      font-size: 14px;
      flex: 1;
    }
    .subBtn {
      height: 88rpx !important;
      line-height: 56rpx;
      border-radius: 44rpx;
    }
  }
  .srCan {
    display: flex;
    align-items: center;
    justify-content: center;
    padding: 30rpx;
    image {
      width: 416rpx;
      height: 416rpx;
    }
    .qr-box {
      border: 1px solid #e8e8e8;
      padding: 2px;
      border-radius: 4rpx;
      canvas {
        width: 416rpx;
        height: 416rpx;
      }
    }
  }
  .text-center {
    color: $main-color;
  }
}
</style>
