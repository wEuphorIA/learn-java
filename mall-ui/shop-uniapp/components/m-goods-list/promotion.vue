<template>
  <div>
    <div
      v-for="(item, index) in res"
      :key="index"
      class="goods-row"
      @click="navigateToDetailPage(item)"
    >
      <div class="flex goods-col">
        <div class="goods-img">
          <u-image
            width="236rpx"
            mode="aspectFit"
            border-radius="24"
            height="236rpx"
            :src="item.goodsImage || item.thumbnail"
          >
            <u-loading slot="loading"></u-loading>
          </u-image>
        </div>
        <div class="goods-detail">
          <div class="title clamp3">{{ item.goodsName }}</div>
          <div class="flex flex-a-s">
            <view class="price-box">
              <!-- 秒杀 / 拼团 -->
              <div class="price" v-if="!type && item.price != undefined">
                ¥<span
                  >{{ $options.filters.goodsFormatPrice(item.price)[0] }} </span
                >.{{ $options.filters.goodsFormatPrice(item.price)[1] }}
              </div>
              <!-- 砍价 -->
              <div class="price" v-if="type && item.purchasePrice != undefined">
                最低： ¥<span
                  >{{
                    $options.filters.goodsFormatPrice(item.purchasePrice)[0]
                  }} </span
                >.{{ $options.filters.goodsFormatPrice(item.purchasePrice)[1] }}
              </div>
              <!-- 兜底策略如果金额是0 -->
              <div class="price" v-if="!item.price && !type">
                ¥<span>0 </span>.00
              </div>
            </view>
            <div class="count-config" v-if="!type">
              <span>¥{{ item.originalPrice }}</span>
            </div>
          </div>
          <div class="buyBox">
            <div class="progress">
              <div class="progressBg">
                <div class="progressNum" :style="'width:'+(item.quantity && item.quantity > 0
                    ? Math.ceil((item.salesNum / item.quantity) * 100)
                    : 100) + '%'"></div>
              </div>
              <span
			  class="num"
                >已抢{{
                  (item.quantity && item.quantity > 0
                    ? Math.ceil((item.salesNum / item.quantity) * 100)
                    : 100) + '%'
                }}</span
              >
            </div>
            <image class="buy" :src="buy"></image>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import commonTpl from '@/components/m-goods-list/common';
export default {
  data() {
    return {
      lightColor: this.$mainColor,
      buy: require('@/static/buy.png'),
    };
  },
  mixins: [commonTpl],
  props: {
    // 遍历的数据
    res: {
      type: Array,
      default: () => {
        return [];
      },
    },
    goodStartTime:{
      type:String,
      default:''
    },
    type: {
      type: null,
      default: '',
    },
  },
  methods: {
    // 跳转到商品详情
    navigateToDetailPage(item) {
      if (this.type == 'kanJia') {
        uni.navigateTo({
          url: `/pages/promotion/bargain/detail?id=${item.id}`,
        });
        return;
      }
      console.log(item,111)
      uni.navigateTo({
        url: `/pages/product/goods?id=${item.skuId}&goodsId=${item.goodsId}&type=ms&time=${item.promotionGoods.startTime}&price=${item.originalPrice}&promotionPrice=${item.price}&endTime=${item.promotionGoods.endTime}`,
      });
    },
  },
};
</script>

<style lang="scss" scoped>
.buyBox {
  background: #ffe7df;
  border-radius: 6px 6px 27px 6px;
  padding: 20rpx 120rpx 20rpx 20rpx;
  height: 60rpx;
  line-height: 60rpx;
  position: absolute;
  bottom: 0;
  display: flex;
  width: 100%;
  .progress {
    flex: 1;
    display: flex;
    font-size: 22rpx;
    color: $main-color;
	align-items: center;
    .progressBg {
      background: #ffd5c7;
      border-radius: 8rpx;
	  flex: 1;
	  height: 16rpx;
	  overflow: hidden;
	  .progressNum{
		  background: $main-color;
		  height: 16rpx;
	  }
    }
	.num{
		padding-left: 6rpx;
		padding-right: 50rpx;
		line-height: 20rpx;
	}
  }
}
.buy {
  width: 100rpx;
  height: 60rpx;
  position: absolute;
  right: 0;
  top: 0;
}
.flex-j-sb {
  width: 100%;
}
.goods-row {
  background: #fff;
  padding: 16rpx;
  margin-bottom: 20rpx;
  border-radius: 24rpx;
  > .goods-col {
    display: flex;
    > .goods-img {
      overflow: hidden;
      flex: 4;
    }
    > .goods-detail {
      flex: 7;
    }
  }
}
.goods-detail {
  margin: 0 0 0 28rpx;
  position: relative;
  > .title {
    font-size: 26rpx;
    color: $font-color-dark;
    line-height: 36rpx;
    display: -webkit-box;
    -webkit-box-orient: vertical;
    -webkit-line-clamp: 2;
    overflow: hidden;
    padding-bottom: 16rpx;
  }

  .promotion {
    margin-top: 4rpx;
    display: flex;

    div {
      span {
        font-size: 24rpx;
        color: $light-color;
        margin-right: 10rpx;
        padding: 0 4rpx;
        border-radius: 2rpx;
      }
    }
  }

  .count-config {
    padding: 5rpx 0;
    color: rgba($color: #878787, $alpha: 0.46);
    display: flex;
    font-size: 26rpx;
    letter-spacing: 2rpx;
    padding-left: 10rpx;
    text-decoration: line-through;
    margin-left: 10rpx;
  }
}
.price-box {
  margin-top: 10rpx;
  display: flex;
  align-items: center;
  justify-content: space-between;
  padding-right: 10rpx;
  font-size: 24rpx;
  color: $font-color-light;

  > .price {
    font-size: 26rpx;
    line-height: 1;
    color: $main-color;
    font-weight: bold;

    /deep/ span:nth-of-type(1) {
      font-size: 48rpx;
    }
  }
}
</style>
