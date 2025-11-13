<template>
  <view class="category-wrap">
    <u-navbar class="navbar" :is-back="false">
      <div class="searchMain">
        <div class="title">商品分类</div>
        <!-- #ifdef H5 -->
        <u-search
          class="nav-search"
          @click.native="search"
          placeholder="搜索商品"
          :show-action="false"
        ></u-search>
        <!-- #endif -->
        <!-- #ifndef H5 -->
        <u-search
          class="nav-search"
          disabled
          @click.native="search"
          placeholder="搜索商品"
          :show-action="false"
        ></u-search>
        <!-- #endif -->
      </div>
    </u-navbar>
    <view class="content" :style="{ paddingTop: capsuleBottom + 'px' }">
      <scroll-view scroll-y scroll-with-animation class="left-aside">
        <view
          v-for="(item, index) in tabList"
          :key="item.id"
          class="f-item b-b"
          :class="{ active: item.id === currentId }"
          @click="tabtap(item, index)"
        >
          {{ item.name }}
        </view>
      </scroll-view>
      <scroll-view
        scroll-with-animation
        scroll-y
        class="right-aside"
        :upper-threshold="-100"
        :lower-threshold="-100"
      >
        <!-- 头部图片 -->
        <view class="top-img" id="main-top">
          <u-image
            width="500rpx"
            height="230rpx"
            @click="navigateToList(topImg.id, topImg.id)"
            :src="topImg.image"
            mode=""
          >
          </u-image>
        </view>
        <view
          v-for="item in categoryList"
          :key="item.id"
          class="s-list"
          :id="'main-' + item.id"
        >
          <!-- 分类标题 -->
          <text class="s-item">{{ item.name }}</text>
          <!-- 分类详情 -->
          <view class="t-list">
            <view
              @click="navigateToList(item.id, children.id)"
              v-if="children.parentId === item.id"
              class="t-item"
              v-for="(children, cIndex) in item.children"
              :key="children.id"
              :class="{ 'margin-right': (cIndex + 1) % 3 == 0 }"
            >
              <u-image
                width="70px"
                height="70px"
                :src="children.image"
                :lazy-load="true"
              >
              </u-image>
              <text>{{ children.name }}</text>
            </view>
          </view>
        </view>
      </scroll-view>
    </view>
  </view>
</template>

<script>
import { getCategoryList } from '@/api/goods.js';
export default {
  data() {
    return {
      currentId: 0,
      tabList: [], //左侧标题列表
      categoryList: [], //右侧分类数据列表
      topImg: '', //顶部图片
      capsuleBottom: null,
    };
  },
  onLoad() {
    this.loadData();
    // #ifdef MP-WEIXIN
    // 小程序默认分享
    uni.showShareMenu({ withShareTicket: true });
    // #endif
    uni.getSystemInfo({
      success: () => {
        this.capsuleBottom = uni.getMenuButtonBoundingClientRect().bottom + 30;
      },
    });
  },
  methods: {
    /**
     * 查询
     */
    search() {
      uni.navigateTo({
        url: '/pages/navigation/search/searchPage',
      });
    },

    /**
     * 加载图片
     */
    async loadData() {
      let list = await getCategoryList(0);
      this.tabList = list.data.result;
      this.currentId = list.data.result[0].id;
      this.loadListContent(0);
    },

    /**
     * 加载列表内容
     */
    loadListContent(index) {
      this.topImg = this.tabList[index];
      this.categoryList = this.tabList[index].children;
    },
    /**
     * 一级分类点击
     */
    tabtap(item, i) {
      if (item.id != this.currentId) {
        this.currentId = item.id;
        this.loadListContent(i);
      }
    },

    navigateToList(sid, tid) {
      uni.navigateTo({
        url: `/pages/navigation/search/searchPage?category=${tid}`,
      });
    },
  },
};
</script>
<style lang="scss">
/deep/ page {
  height: 100%;
  background-color: #fdfaff;
}
</style>
<style lang="scss" scoped>
/* 解决小程序和app滚动条的问题 */
/* #ifdef MP-WEIXIN || APP-PLUS */
::-webkit-scrollbar {
  display: none;
}
/* #endif */
/* 解决H5 的问题 */
/* #ifdef H5 */
uni-scroll-view .uni-scroll-view::-webkit-scrollbar {
  /* 隐藏滚动条，但依旧具备可以滚动的功能 */
  display: none;
}
/* #endif */
.s-list {
  background: $font-color-white;
  border-radius: 24rpx;
  padding: 28rpx 24rpx 10rpx;
  margin-bottom: 20rpx;
  &:nth-child(2) {
    border-radius: 0rpx 0rpx 24rpx 24rpx;
  }
}
.category-wrap {
  height: 100%;
  background: $bg-color-sub;
  .content {
    height: calc(100vh - 4px);
    display: flex;
    color: #333;
    font-size: 28rpx;
    margin-top: 20rpx;
  }
  .left-aside {
    flex-shrink: 0;
    width: 200rpx;
    height: 100%;
    background-color: #f7f7f7;
  }
  .f-item {
    display: flex;
    align-items: center;
    justify-content: center;
    width: 100%;
    height: 104rpx;
    line-height: 104rpx;
    padding: 34rpx 0;
    position: relative;
    font-size: 26rpx;
    color: #878787;
    &.active {
      font-weight: bold;
      color: $light-color;
      font-size: 32rpx;
    }
  }
  .right-aside {
    flex: 1;
    overflow: hidden;
    padding: 0 22rpx 0 30rpx;
  }

  .top-img {
    height: 230rpx;
    border-radius: 8px 8px 0 0;
    overflow: hidden;
    background: $font-color-white;
    padding: 34rpx 20rpx 0;
    image {
      width: 100%;
      height: 100%;
    }
  }
  .s-item {
    display: flex;
    align-items: center;
    line-height: 44rpx;
    font-weight: 600;
    font-size: 32rpx;
    color: $font-color-dark19;
    padding-bottom: 20rpx;
  }
  .t-list {
    display: flex;
    flex-wrap: wrap;
    width: 100%;
    text {
      line-height: 34rpx;
      font-size: 24rpx;
      white-space: nowrap; /* 确保文本在一行内显示 */
      overflow: hidden; /* 隐藏超出容器的文本 */
      text-overflow: ellipsis; /* 使用省略号表示被截断的文本 */
    }
  }
  .margin-right {
    margin-right: 0 !important;
  }
  .t-item {
    display: flex;
    justify-content: center;
    align-items: center;
    flex-direction: column;
    width: 128rpx;
    margin-right: 30rpx;
    font-size: 24rpx;
    padding-bottom: 20rpx;
    image {
      width: 128rpx;
      display: block;
      border-radius: 8px;
      margin-bottom: 20rpx;
    }
    /deep/ .u-image {
      width: 140rpx !important;
      height: 140rpx !important;
      border-radius: 8px !important;
      margin-bottom: 20rpx !important;
    }
  }
}
</style>
