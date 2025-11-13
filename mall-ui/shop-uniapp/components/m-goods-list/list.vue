<template>
  <view>
    <!-- 一行两列商品展示 -->
    <view class="goods-list" v-if="type == 'twoColumns'">
      <view v-for="(item, index) in res" :key="index" class="goods-item">
        <view class="image-wrapper" @click="navigateToDetailPage(item)">
          <u-image
            :src="item.thumbnail"
            width="100%"
            height="330rpx"
            mode="aspectFit"
          >
            <u-loading slot="loading"></u-loading>
          </u-image>
        </view>
        <view class="goods-detail">
          <div
            class="title clamp"
            v-html="lightSearchStr(keyword, item.goodsName)"
            @click="navigateToDetailPage(item)"
          ></div>
          <view class="price-box" @click="navigateToDetailPage(item)">
            <div class="price" v-if="item.price != undefined">
              ¥<span
                >{{ $options.filters.goodsFormatPrice(item.price)[0] }} </span
              >.{{ $options.filters.goodsFormatPrice(item.price)[1] }}
            </div>
            <span class="payText">已售 {{ item.buyCount || '0' }}</span>
          </view>
          <div class="promotion" @click="navigateToDetailPage(item)">
            <div v-if="item.salesModel == 'WHOLESALE'">
              <span>批</span>
            </div>
            <div
              v-for="(promotionItem, promotionIndex) in getPromotion(item)"
              :key="promotionIndex"
            >
              <span
                class="discountIcon"
                v-if="promotionItem.indexOf('COUPON') != -1"
                >劵</span
              >
              <span
                class="discountIcon"
                v-if="promotionItem.indexOf('FULL_DISCOUNT') != -1"
                >满减</span
              >
              <span
                class="discountIcon"
                v-if="promotionItem.indexOf('SECKILL') != -1"
                >秒杀</span
              >
            </div>
          </div>
          <!-- <div class="count-config" @click="navigateToDetailPage(item)">
            <span>已售 {{ item.buyCount || '0' }}</span>
            <span>{{ item.commentNum || '0' }}条评论</span>
          </div> -->
          <div
            class="store-seller-name"
            v-if="storeName"
            @click="navigateToStoreDetailPage(item)"
          >
            <div class="text-hidden">
              <u-tag
                style="margin-right: 10rpx"
                size="mini"
                mode="dark"
                v-if="item.selfOperated"
                text="自营"
                type="error"
              />
              <span>{{ item.storeName || '暂无' }}</span>
            </div>
            <span class="rightText">
              进店<u-icon name="arrow-right"></u-icon>
            </span>
          </div>
        </view>
      </view>
    </view>
    <!-- 一行一列商品展示 -->
    <div v-if="type == 'oneColumns'" class="goods-one-row">
      <div v-for="(item, index) in res" :key="index" class="goods-row">
        <div class="flex goods-col">
          <div class="goods-img" @click="navigateToDetailPage(item)">
            <u-image
              width="230rpx"
              mode="aspectFit"
              border-radius="16"
              height="230rpx"
              :src="item.thumbnail"
            >
              <u-loading slot="loading"></u-loading>
            </u-image>
          </div>
          <div class="goods-detail">
            <div class="title clamp3" @click="navigateToDetailPage(item)">
              {{ item.goodsName }}
            </div>
            <view class="price-box" @click="navigateToDetailPage(item)">
              <div class="price" v-if="item.price != undefined">
                ¥<span
                  >{{ $options.filters.goodsFormatPrice(item.price)[0] }} </span
                >.{{ $options.filters.goodsFormatPrice(item.price)[1] }}
              </div>
              <span class="payText" style="float: left"
                >已售 {{ item.buyCount || '0' }}</span
              >
            </view>
            <div class="promotion" @click="navigateToDetailPage(item)">
              <div v-if="item.salesModel == 'WHOLESALE'">
                <span>批</span>
              </div>
              <div
                v-for="(promotionItem, promotionIndex) in getPromotion(item)"
                :key="promotionIndex"
              >
                <span
                  class="discountIcon"
                  v-if="promotionItem.indexOf('COUPON') != -1"
                  >劵</span
                >
                <span
                  class="discountIcon"
                  v-if="promotionItem.indexOf('FULL_DISCOUNT') != -1"
                  >满减</span
                >
                <span
                  class="discountIcon"
                  v-if="promotionItem.indexOf('SECKILL') != -1"
                  >秒杀</span
                >
              </div>
            </div>
            <!-- <div
              style="overflow: hidden"
              @click="navigateToDetailPage(item)"
              class="count-config"
            >
              <span style="float: left; font-size: 22rpx"
                >已售 {{ item.buyCount || '0' }}</span
              >
              <span style="float: right; font-size: 22rpx"
                >{{ item.commentNum || '0' }}条评论</span
              >
            </div> -->
            <div
              style="overflow: hidden"
              @click="navigateToStoreDetailPage(item)"
              class="count-config"
            >
              <div class="text-hidden" v-if="storeName">
                <u-tag
                  style="margin-right: 10rpx"
                  size="mini"
                  mode="dark"
                  v-if="item.selfOperated"
                  text="自营"
                  type="error"
                />
                <span class="line1-store-name">{{ item.storeName }}</span>
                <span class="to-store"
                  >进店<u-icon
                    size="24"
                    name="arrow-right"
                    color="#666"
                  ></u-icon>
                </span>
              </div>
              <span class="rightText">
                <u-icon name="arrow-right" color="#c5c5c5">进店</u-icon>
              </span>
            </div>
          </div>
        </div>
      </div>
    </div>
  </view>
</template>

<script>
import commonTpl from '@/components/m-goods-list/common';
export default {
  data() {
    return {
      lightColor: this.$mainColor,
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
    // 一行两列还是一行一列显示
    type: {
      type: String,
      default: 'twoColumns',
      validator() {
        return ['twoColumns', 'oneColumns'];
      },
    },
    storeName: {
      type: Boolean,
      default: true,
    },
    keyword: {
      type: null,
      default: '',
    },
  },
  watch: {
    keyword(val) {
      if (val) {
        this.lightSearchStr(val);
      }
    },
  },
  methods: {
    // 高亮显示搜索内容
    lightSearchStr(keyword, str) {
      if (!keyword) {
        return str;
      } else {
        let unicodes = '';
        for (let i of Array.from(keyword)) {
          unicodes += this.unicode(i) + '|';
        }
        const rule = '(' + unicodes + ')';
        const reg = new RegExp(rule, 'gi');
        return str
          ? str.replace(
              reg,
              (matchValue) =>
                `<span style="color:${this.lightColor}">${matchValue}</span>`
            )
          : '';
      }
    },
    //  转换为unicode
    unicode(str) {
      var value = '';
      for (var i = 0; i < str.length; i++) {
        value +=
          '\\u' + this.left_zero_4(parseInt(str.charCodeAt(i)).toString(16));
      }
      return value;
    },
    left_zero_4(str) {
      if (str != null && str != '' && str != 'undefined') {
        if (str.length == 2) {
          return '00' + str;
        }
      }
      return str;
    },
    // 数据去重一下 只显示一次 减免 劵 什么的
    getPromotion(item) {
      if (item ? item.promotionMap : item.promotionMap) {
        const fieldList = item ? item.promotionMap : item.promotionMap;
        let array = [];
        Object.keys(fieldList).forEach((child) => {
          if (!array.includes(child.split('-')[0])) {
            array.push(child.split('-')[0]);
          }
        });
        return array;
      }
    },
    // 跳转到商品详情
    navigateToDetailPage(item) {
      uni.navigateTo({
        url: `/pages/product/goods?id=${item.id}&goodsId=${item.goodsId}`,
      });
    },
    // 跳转地址
    navigateToStoreDetailPage(item) {
      uni.navigateTo({
        url: `/pages/product/shopPage?id=${item.storeId}`,
      });
    },
  },
};
</script>

<style lang="scss" scoped>
.goods-one-row {
  padding-bottom: 250rpx;
  .goods-detail{
    position: relative;
    &>.title{
      padding: 0;
    }
    .count-config{
      position: absolute;
      width: 100%;
      bottom: 30rpx;
    }
  }
}
/* 商品列表 */
.goods-list {
  display: flex;
  flex-wrap: wrap;
  margin: 34rpx 20rpx 284rpx;
  width: 100%;

  > .goods-item {
    background-color: #ffffff;
    display: flex;
    border-radius: 16rpx;
    flex-direction: column;
    width: calc(50% - 30rpx);
    margin-bottom: 26rpx;
    padding-bottom: 28rpx;

    &:nth-child(2n + 1) {
      margin-right: 20rpx;
    }

    .image-wrapper {
      width: 100%;
      height: 340rpx;
      border-radius: 20rpx 20rpx 0 0;
      overflow: hidden;
      padding: 0;
    }
  }

  .count-config,
  .store-seller-name {
    font-size: $font-sm;
  }
  .rightText {
    color: $font-color-dark;
  }
  .payText {
    font-size: 22rpx;
  }
  .text-hidden {
    overflow: hidden;
    text-overflow: ellipsis;
    white-space: nowrap;
  }
}

.goods-row {
  background: #fff;
  padding: 16rpx;

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
  margin: 0 20rpx;

  > .title {
    font-size: 26rpx;
    color: $font-color-black;
    line-height: 36rpx;
    padding: 20rpx 0 0;
    display: -webkit-box;
    -webkit-box-orient: vertical;
    -webkit-line-clamp: 2;
    overflow: hidden;
  }

  .promotion {
    margin-top: 6rpx;
    display: flex;

    div {
      span {
        font-size: 24rpx;
        color: $light-color;
        margin-right: 10rpx;
        padding: 0 4rpx;
        border-radius: 2rpx;
        &.discountIcon {
          border: 1px solid #fe6a3d;
          border-radius: 2px;
        }
      }
    }
  }

  .store-seller-name {
    padding-top: 9rpx;
    color: $font-color-baseSub;
    overflow: hidden;
    display: flex;
    justify-content: space-between;
  }

  .count-config {
    padding: 5rpx 0;
    color: #666;
    display: flex;
    font-size: 24rpx;
    justify-content: space-between;
  }

  > .price-box {
    margin-top: 12rpx;
    display: flex;
    align-items: center;
    justify-content: space-between;
    font-size: 24rpx;
    color: $font-color-light;

    > .price {
      font-size: 26rpx;
      line-height: 1;
      color: $main-color;

      /deep/ span:nth-of-type(1) {
        font-size: 36rpx;
      }
    }
  }
  .discountIcon {
    border: 1 solid #fe6a3d;
    border-radius: 2px;
  }
}
</style>
