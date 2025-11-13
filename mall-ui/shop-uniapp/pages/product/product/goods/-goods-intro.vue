<template>
  <div>
    <view class="detail-box">
      <view class="goods-detail">
        <view class="detail_padding">
          <div class="goods-detail-box">
            <div class="goods-detail-item goods-active">商品介绍</div>
          </div>
          <div class="param-list" v-if="!res.mobileIntro">
            <emptyTemplate :tipInfo='tipInfo'></emptyTemplate>
          </div>
          <u-parse
            class="vhtml"
            :lazy-load="true"
            :use-cache="true"
            :show-with-animation="true"
            :html="res.mobileIntro"
            :tag-style="style"
          ></u-parse>
        </view>
      </view>
    </view>

    <view class="detail-box">
      <view class="goods-detail">
        <view class="detail_padding">
          <div class="goods-detail-box">
            <div class="goods-detail-item goods-active">商品参数</div>
          </div>
          <!-- <u-divider>商品参数</u-divider> -->
          <div class="param-list" v-if="goodsParams.length == 0">
            <emptyTemplate :tipInfo='tipInfoParam'></emptyTemplate>
          </div>
          <div
            class="params-group"
            v-for="(group, groupIndex) in goodsParams"
            :key="groupIndex"
          >
            <view style="font-weight: bold; margin-left: 10px">{{
              group.groupName
            }}</view>
            <div class="param-list">
              <div
                class="param-item"
                v-for="(param, index) in group.goodsParamsItemDTOList"
                :key="index"
              >
                <div class="param-left">{{ param.paramName }}</div>
                <div class="param-right">{{ param.paramValue }}</div>
              </div>
            </div>
          </div>
        </view>
      </view>
    </view>
  </div>
</template>

<script>
import { getGoodsMessage } from '@/api/goods';
import emptyTemplate from '@/components/empty/index.vue';
export default {
  components: {
    emptyTemplate,
  },
  data() {
    return {
      goodsDetail: '',
      style: {
        img: 'display:block',
      },
      tipInfo:'暂无商品介绍',
      tipInfoParam:'暂无商品参数'
    };
  },
  props: ['res', 'goodsId', 'goodsParams'],
  async mounted() {
    let res = await getGoodsMessage(this.goodsId);
    if (res.data.success) {
      this.goodsDetail = res.data.result;
    }
  },
};
</script>

<style lang="scss" scoped>
@import '../product.scss';
.param-list {
  padding: 40rpx 0 80rpx 0;
}
.param-item {
  display: flex;
  justify-content: center;
  border-bottom: none;

  > .param-left,
  > .param-right {
    padding: 16rpx 0;
    font-size: 24rpx;
    color: #666;
    border: 1px solid rgb(220, 223, 230);
    border-bottom: none;
  }
  > .param-left {
    text-align: center;
    border-right: none;
    flex: 3;
  }

  > .param-right {
    padding: 0 10rpx;
    align-items: center;
    display: flex;
    flex: 7;
  }
}
.param-item:nth-last-of-type(1) {
  > .param-left,
  > .param-right {
    border-bottom: 1px solid rgb(220, 223, 230);
  }
}
.empty {
  margin: 40rpx 0;
}
.goods-detail /deep/ .vhtml {
  overflow: hidden;

  width: 100%;
}
.vhtml {
  /deep/ img {
    display: block !important;
  }
}

/deep/ img {
  width: 100%;
}
.goods-detail-box {
  display: flex;
  justify-content: space-between;
  // padding: 0 80rpx;
  padding: 32rpx 0;
  line-height: 40rpx;
  font-size: 28rpx;
  > .goods-active {
    font-weight: 600;
  }
  > .goods-detail-item {
    color: $font-color-dark19;
    position: relative;
  }
}
</style>
