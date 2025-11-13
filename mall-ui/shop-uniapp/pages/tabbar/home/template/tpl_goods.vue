<template>
  <div class="layout">
    <u-sticky>
      <div class="goods-cell-title">
        <div
          class="goods-item-title"
          :class="{ 'selected-title': selected.index == index }"
          @click="handleClickTitle(title, index)"
          v-for="(title, index) in res.list[0].titleWay"
          :key="index"
        >
          <h4 class="h4">{{ title.title }}</h4>
          <div>{{ title.desc }}</div>
        </div>
      </div>
    </u-sticky>
    <div class="goods-list">
      <div
        v-if="
          item.___index != undefined
            ? selected.index == item.___index
            : selected.val == item.type
        "
        @click="handleClick(item)"
        class="goods-item"
        v-for="(item, item_index) in res.list[0].listWay"
        :key="item_index"
      >
        <div class="goods-img">
          <u-image
            :src="item.img"
            height="350rpx"
            mode="aspectFit"
            width="100%"
          >
            <u-loading slot="loading"></u-loading>
          </u-image>
        </div>
        <div class="goods-desc">
          <div class="goods-title">
            {{ item.title }}
          </div>
          <div class="goods-bottom">
            <div class="goods-price">
              ¥<span
                >{{ $options.filters.goodsFormatPrice(item.price)[0] }} </span
              >.{{ $options.filters.goodsFormatPrice(item.price)[1] }}
            </div>
          </div>
        </div>
      </div>

      <div
        v-if="
          res.list[0].titleWay[selected.index].bindCategory && goodsData.length
        "
        v-for="(item, index) in goodsData"
        :key="index"
        class="goods-item"
        @click="handleClick(item)"
      >
        <div class="goods-img">
          <u-image
            :src="item.thumbnail"
            height="350rpx"
            mode="aspectFit"
            width="100%"
          >
            <u-loading slot="loading"></u-loading>
          </u-image>
        </div>
        <div class="goods-desc">
          <div class="goods-title">
            {{ item.goodsName }}
          </div>
          <div class="goods-bottom">
            <div class="goods-price">
              ¥<span
                >{{ $options.filters.goodsFormatPrice(item.price)[0] }} </span
              >.{{ $options.filters.goodsFormatPrice(item.price)[1] }}
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>
<script>
import { getGoodsList } from '@/api/goods.js';
export default {
  title: '商品分类以及商品',
  data() {
    return {
      selected: {
        index: 0,
        val: '',
      },
      params: {
        pageNumber: 1,
        pageSize: 100,
        categoryId: '',
      },
      goodsData: [], //商品循环内容
      goodsResult: '', //es总返回内容
    };
  },
  props: ['res', 'enableBottomLoad'],
  watch: {
    res: {
      handler(val) {
        // 监听父级的值 如果有值将值赋给selected
        if (val) {
          console.log(val);
          // 如果第一个标签页绑定为商品
          this.selected.val = this.res.list[0].listWay[0]
            ? this.res.list[0].listWay[0].type
            : '';
          // 如果第一个标签为绑定为分类
          this.res.list[0].titleWay[0].bindCategory
            ? this.initGoods(this.res.list[0].titleWay[0])
            : '';
        }
      },
      immediate: true,
    },
  },
  mounted() {
    uni.$on('onReachBottom', () => {
      if (
        this.enableBottomLoad &&
        this.goodsResult.totalElements >=
          this.params.pageNumber * this.params.pageSize
      ) {
        this.params.pageNumber++;
        this.initGoods(this.res.list[0].titleWay[this.selected.index]);
      }
    });
  },
  destroyed() {
    uni.$off('onReachBottom');
  },
  methods: {
    handleClick(item) {
      uni.navigateTo({
        url: `/pages/product/goods?id=${item.id}&goodsId=${item.goodsId}`,
      });
    },
    closeGoods(val, index) {
      this.res.list[0].listWay.splice(index, 1);
    },
    async initGoods(val) {
      if (this.enableBottomLoad) this.params.pageSize = 20;
      val ? (this.params.categoryId = val.bindCategory.id) : '';
      const res = await getGoodsList(this.params);
      if (res.data.success) {
        this.goodsResult = res.data.result;
        const result = res.data.result.records;
        this.goodsData.push(...result);
        console.log(this.goodsData);
      }
    },
    handleClickTitle(val, index) {
      this.selected.index = index;
      this.selected.val = val.title;
      if (val.bindCategory) {
        this.params.pageNumber = 1;
        this.goodsData = [];
        this.initGoods(val);
      }
    },
  },
};
</script>
<style lang="scss" scoped>
$w_94: 94%;

.layout {
  margin: 40rpx 0;
  background: #f9f9f9;
}

.selected-title {
  > h4 {
    font-size: 30rpx;
    color: #191919 !important;
    font-weight: bold;
  }

  > div {
    font-weight: bold;
    color: $main-color !important;
  }
}

.goods-cell-title {
  padding: 26rpx;
  transition: 0.35s;
  line-height: 44rpx;
  display: flex;
  background: #f9f9f9;
  > .goods-item-title {
    flex: 1;
    text-align: center;

    > h4 {
      font-size: 32rpx;
      padding-bottom: 6rpx;
    }

    > div {
      color: #999;
      font-size: 24rpx;
    }
  }
}

.goods-list {
  display: flex;
  flex-wrap: wrap;
  padding: 0 25rpx;
  margin-left: -20rpx;
}

.goods-item {
  width: calc(50% - 10px);
  margin-bottom: 10px;
  overflow: hidden;
  background: #ffffff;
  box-shadow: 0 2px 13px 0 #0000000a;
  border-radius: 10px;
  margin-left: 10px;
}

.goods-img {
  position: relative;
  border-top-left-radius: 20rpx;
  border-top-right-radius: 20rpx;
  overflow: hidden;
  .u-image__image {
    border-radius: 12px 12px 0 0;
  }
  > img {
    width: 100%;
    height: 100%;
  }
}

.goods-desc {
  border-bottom-left-radius: 20rpx;
  border-bottom-right-radius: 20rpx;
  line-height: 36rpx;
  width: $w_94;
  background: #fff;
  padding: 20rpx 20rpx 22rpx;
  > .goods-title {
    font-size: 24rpx;
    height: 67rpx;
    display: -webkit-box;
    font-weight: 500;
    -webkit-box-orient: vertical;
    -webkit-line-clamp: 2;
    overflow: hidden;
    font-size: 26rpx;
    color: #000;
  }

  > .goods-bottom {
    display: flex;
    font-weight: bold;
    padding-top: 12rpx;
    > .goods-price {
      line-height: 50rpx;
      color: $main-color;
      > span {
        font-size: 36rpx;
      }
    }
  }
}
</style>
