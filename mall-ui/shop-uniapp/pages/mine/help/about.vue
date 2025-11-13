<template>
  <view>
    <u-navbar :is-back="true" title="关于我们"> </u-navbar>
    <div class="wrapper" :style="{ paddingTop: capsuleBottom + 'px' }">
      <div class="aboutBox">
        <div class="tit">黑马程序员好口碑IT教育— 70%学员来自口碑推荐</div>
        <p>
          黑马程序员是传智教育（股票代码：003032）旗下高端IT教育品牌，传智教育是国内首个实现A股IPO的教育企业。依托于传智雄厚的教育资源，秉承传智教育“为中华民族伟大复兴而讲课，为千万学生少走弯路而著书”的使命，致力于培养高精尖数字化人才，为国家建设现代化经济体系的战略目标培养科技人才。
        </p>
        <p>黑马程序员课程涵盖了JavaEE、鸿蒙应用开发、HTML&JS+前端、Python大数据开发、人工智能、AI+设计、软件测试、新媒体、产品经理等热门精品学科。已在北京昌平、北京顺义、上海、广州、深圳、武汉、郑州、西安、长沙、济南、重庆、南京、杭州、石家庄、成都、合肥、太原16个城市设立17所分校。</p>
        <p>截止2024年2月，黑马程序员B站粉丝已超320万，免费分享15万余节初/中/高级教程，累计下载/播放量3.3亿次，成为B站计算机技术频道第一UP主。累计出版151本计算机类原创教材，其中14部教材入选首批“十四五”职业教育国家规划教材，共计发行800万余册，400余万大学生共同使用，被2600所教育部名单内高校选作授课教材，高校教材覆盖率62.17%，黑马程序员为高校IT教育赋能。</p>
      </div>
    </div>
  </view>
</template>
<script>
export default {
  data() {
    return {
      navTitle: '',
      capsuleBottom: null,
    };
  },
  mounted() {},
  onLoad(option) {
    uni.getSystemInfo({
      success: () => {
        this.capsuleBottom = uni.getMenuButtonBoundingClientRect().bottom + 8;
      },
    });
  }
};
</script>
<style lang="scss">
/deep/ page{
    background: #f8f8f8;
}
</style>
<style lang="scss" scoped>
@import './index.scss';
.wrapper {
  padding: 16rpx;
}
</style>
