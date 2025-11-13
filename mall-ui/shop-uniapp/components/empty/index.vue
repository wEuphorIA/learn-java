<template>
  <view class="nodata">
    <view class="emptyImg"></view>
    <div v-if="tipInfo">{{tipInfo}}</div>
    <div v-else>暂无相关内容哦～</div>
  </view>
</template>
<script>
export default {
  props: ['tipInfo']
}
</script>
