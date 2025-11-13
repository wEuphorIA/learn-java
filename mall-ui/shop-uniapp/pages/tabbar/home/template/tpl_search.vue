<template>
  <div class="layout">
    <div class="line"></div>
    <div class="search" @click="handleSearch">
      {{ res.list[0].title }}
    </div>
    <!-- <div slot="right" open-type="contact" class="navbar-right message" @click="linkMsgDetail" style="border-style:none;background:rgb(234,234,234);" >
		  <image style="width:53rpx;height:53rpx;margin-top:6rpx;" src="@/static/img/title.png"></image>
	  </div> -->
  </div>
</template>
<script>
export default {
  title:"搜索栏",
  props: ["res","storeId"],
  methods: {
    linkMsgDetail(){
      uni.navigateTo({
        url:`/pages/tabbar/home/title`
      })
    },
 
    handleSearch() {
      if(this.storeId){
        uni.navigateTo({
        url: `/pages/navigation/search/searchPage?storeId=${this.storeId}`,
      });
      }else{
         uni.navigateTo({
        url: `/pages/navigation/search/searchPage`,
      });
      }
      
    },
  },
};
</script>
<style lang="scss" scoped>
@import "./tpl.scss";

.search {
  height: 64rpx;
  border-radius: 10rpx;
  display: flex;
  align-items: center;
  font-size:12px;
  color: #878787;
  
}
.line{
    display: inline-block;
    background: #E5E4E4;
    width: 1px;
    height: 24rpx;
    margin-right:16rpx;
    margin-left:-14rpx
  }

.layout {
  background: #fff;
  border-radius: 32px;
  padding: 0 80rpx;
  position: relative;
  display:flex;
  align-items:center
}
.navbar-right{
	position: absolute;
	top: 0;
	// right: 0;
}
.message{
	right:40rpx;
}
</style>
