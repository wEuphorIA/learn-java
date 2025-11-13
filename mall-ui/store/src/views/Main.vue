<style lang="scss" scoped>
@import "./main.scss";
</style>

<template>
  <div class="main">
    <div class="sidebar-menu-con menu-bar">
      <div class="logo-con">
        <img :src="storeSideLogo" key="max-logo" />
      </div>
      <shrinkable-menu></shrinkable-menu>
      <div class="user-dropdown-menu-con">
        <Row
          type="flex"
          justify="end"
          align="middle"
          class="user-dropdown-innercon"
        >
          <!-- <ul class="nav-list">
            <li class="nav-item" @click="handleClickSetting">
              <Tooltip content="设置">
                <Icon size="16" type="md-settings" />
              </Tooltip>
            </li>
          </ul> -->
          <div class="dropList">
            <img
              :src="userInfo.storeLogo"
              style="background: #fff; margin-right: 10px"
            />
            <span class="text">{{ userInfo.nickName }}</span>
            <span class="loginOut" @click="loginOut">
              <svg
                xmlns="http://www.w3.org/2000/svg"
                viewBox="0 0 28 29"
                class="design-iconfont"
              >
                <g
                  stroke="#595959"
                  stroke-width="1.3"
                  fill="none"
                  fill-rule="evenodd"
                  stroke-linecap="round"
                  stroke-linejoin="round"
                >
                  <path
                    d="M7.5,11.5 L2,11.5 C0.8954305,11.5 1.3527075e-16,10.6045695 0,9.5 L0,2 C-1.3527075e-16,0.8954305 0.8954305,2.02906125e-16 2,0 L7.5,0 L7.5,0"
                    transform="translate(7 8.44172)"
                  />
                  <path
                    d="M3.75 5.75L12.4916992 5.75"
                    transform="translate(7 8.44172)"
                  />
                  <path
                    transform="rotate(45 3.70510354 18.36439047)"
                    d="M8.3877241 3.60684445L12.4025977 3.60684445 12.4025977 7.78072245"
                  />
                </g>
              </svg>
            </span>
          </div>

          <Dropdown
            transfer
            trigger="hover"
            @on-click="handleClickUserDropdown"
          >
            <span class="set">
              <svg
                xmlns="http://www.w3.org/2000/svg"
                viewBox="0 0 29 29"
                class="design-iconfont"
              >
                <g
                  fill="#D8D8D8"
                  stroke="#191919"
                  stroke-width="1.3"
                  fill-rule="evenodd"
                  stroke-linecap="round"
                  stroke-linejoin="round"
                >
                  <path
                    d="M0.53826904 0.5L12.380188 0.5"
                    transform="translate(8.307416 8.853878)"
                  />
                  <path
                    d="M0.53826904 5.38330078L12.380188 5.38330078"
                    transform="translate(8.307416 8.853878)"
                  />
                  <path
                    d="M0.53826904 10.2666016L12.380188 10.2666016"
                    transform="translate(8.307416 8.853878)"
                  />
                </g>
              </svg>
            </span>

            <!-- <DropdownMenu slot="list">
              <DropdownItem name="changePass">修改密码</DropdownItem>
            </DropdownMenu> -->
          </Dropdown>
        </Row>
      </div>
    </div>
    <!-- 顶部标题栏主体 -->
    <div  class="main-header-con">
      <!-- <div class="main-header">
        <Breadcrumb separator=">">
          <BreadcrumbItem>{{ text.titleFirst }}</BreadcrumbItem>
          <BreadcrumbItem>{{ text.titleTwo }}</BreadcrumbItem>
          <BreadcrumbItem>{{ text.titleThr }}</BreadcrumbItem>
        </Breadcrumb>
      </div> -->
      <div class="tags-con" v-if="setting.isUseTabsRouter">
        <tags-page-opened :pageTagsList="pageTagsList"></tags-page-opened>
      </div>
    </div>
    <!-- <div v-if="routeName==='order-detail'" class="main-header-con">
      <div class="main-header">
        <Breadcrumb separator=">">
          <BreadcrumbItem>订单管理</BreadcrumbItem>
          <BreadcrumbItem>订单列表</BreadcrumbItem>
          <BreadcrumbItem>订单详情</BreadcrumbItem>
        </Breadcrumb>
      </div>
    </div>
    <div v-if="routeName==='return-goods-order-detail'" class="main-header-con">
      <div class="main-header">
        <Breadcrumb separator=">">
          <BreadcrumbItem>售后管理</BreadcrumbItem>
          <BreadcrumbItem>退货管理</BreadcrumbItem>
          <BreadcrumbItem>退货详情</BreadcrumbItem>
        </Breadcrumb>
      </div>
    </div> -->
    <div
      class="single-page-con"
      :style="{
        top: setting.isUseTabsRouter ? '70px' : '70px',
        height: 'calc(100% - 70px)',
      }"
    >
      <div class="single-page">
        <!-- <keep-alive :include="cachePage"> -->
        <!-- </keep-alive> -->
        <keep-alive>
          <router-view v-if="$route.meta.keepAlive"></router-view>
        </keep-alive>
        <router-view v-if="!$route.meta.keepAlive"></router-view>
      </div>
    </div>
    <!-- 全局加载动画 -->
    <circleLoading class="loading-position" v-show="loading" />
    <!-- 右侧抽屉配置 -->
    <configDrawer ref="config" />
  </div>
</template>

<script>
import shrinkableMenu from "./main-components/shrinkable-menu/shrinkable-menu.vue";
import tagsPageOpened from "./main-components/tags-page-opened.vue";
import circleLoading from "@/views/my-components/lili/circle-loading.vue";
import configDrawer from "@/views/main-components/config-drawer.vue";

import Cookies from "js-cookie";
import util from "@/libs/util.js";
import { logout } from "@/api/index";
import { nextTick } from "vue";
const config = require("@/config/index.js");
export default {
  components: {
    shrinkableMenu,
    tagsPageOpened,
    circleLoading,
    configDrawer,
  },
  data() {
    return {
      config,
      sliceNum: 5, // 展示nav数量
      userInfo: {}, // 用户信息
      routeName: "",
      storeSideLogo: require("@/assets/logo.png"), //logo图片
    };
  },
  computed: {
    setting() {
      let data = this.$store.state.setting;

      return data.setting;
    },
    loading() {
      return this.$store.state.app.loading;
    },
    pageTagsList() {
      return this.$store.state.app.storeOpenedList; // 打开的页面的页面对象
    },
    cachePage() {
      return this.$store.state.app.cachePage;
    },
    lang() {
      return this.$store.state.app.lang;
    },
    mesCount() {
      return 0;
    },
    text() {
      let data = {};
      console.log(this.$route)
      const names= this.$route.name
      if(names==='order-detail'||names==='return-goods-order-detail'){
        this.routeName= this.$route.name;
      }
      
      console.log(this.routeName)
      this.$store.state.app.navList.forEach((ele) => {
        ele.children.forEach((val) => {
          val.children.forEach((obj) => {
            if (this.$route.name === obj.name) {
              data = {
                titleFirst: ele.title,
                titleTwo: val.title,
                titleThr: obj.title,
              };
            }
          });
        });
      });
      return data;
    },
  },
  methods: {
    handleClickSetting() {
      this.$refs.config.open();
    },
    // 初始化方法
    init() {
      // 菜单
      let pathArr = util.setCurrentPath(this, this.$route.name);
      if (pathArr.length >= 2) {
        this.$store.commit("addOpenSubmenu", pathArr[1].name);
      }
      // this.storeSideLogo = localStorage.getItem("sellerlogoImg");
      window.document.title = localStorage.getItem("sellersiteName");
      //动态获取icon
      let link =
        document.querySelector("link[rel*='icon']") ||
        document.createElement("link");
      link.type = "image/x-icon";
      link.href = localStorage.getItem("sellerIconImg");
      link.rel = "shortcut icon";
      document.getElementsByTagName("head")[0].appendChild(link);

      let userInfo = JSON.parse(Cookies.get("userInfoSeller"));
      this.userInfo = userInfo;
      this.checkTag(this.$route.name);

      let currWidth = document.body.clientWidth;
      if (currWidth <= 1200) {
        this.sliceNum = 2;
      }
    },
    // 用户头像下拉
    handleClickUserDropdown(name) {
      if (name == "ownSpace") {
        util.openNewPage(this, "personal-enter");
        this.$router.push({
          name: "personal-enter",
        });
      } else if (name == "changePass") {
        util.openNewPage(this, "change_pass");
        this.$router.push({
          name: "change_pass",
        });
      }
    },
    loginOut() {
      logout().then((res) => {
        Cookies.set("accessToken", "");
        this.$store.commit("logout", this);
        this.$store.commit("clearOpenedSubmenu");
        this.setStore("accessToken", "");
        this.setStore("refreshToken", "");
        this.$router.push({ path: "/login" });
      });
    },
    // 快捷页签选中状态
    checkTag(name) {
      let openpageHasTag = this.pageTagsList.some((item) => {
        if (item.name == name) {
          return true;
        }
      });
      if (!openpageHasTag) {
        //  解决关闭当前标签后再点击回退按钮会退到当前页时没有标签的问题
        util.openNewPage(
          this,
          name,
          this.$route.params || {},
          this.$route.query || {}
        );
      }
    },
    // 宽度变化
    resize() {
      let currWidth = document.body.clientWidth;
      let count = currWidth / 300;
      if (count > 6) {
        this.sliceNum = 6;
      } else {
        this.sliceNum = count;
      }
    },
  },
  watch: {
    $route(to) {
      this.$store.commit("setCurrentPageName", to.name);
      let pathArr = util.setCurrentPath(this, to.name);
      if (pathArr.length > 2) {
        this.$store.commit("addOpenSubmenu", pathArr[1].name);
      }
      this.checkTag(to.name);
      localStorage.currentPageName = to.name;
    },
    lang() {
      util.setCurrentPath(this, this.$route.name); // 在切换语言时用于刷新面包屑
    },
  },
  mounted() {
    this.init();
    let that = this;
    this.resize();
    window.addEventListener("resize", function () {
      that.resize();
    });
  },
  created() {
    // 显示打开的页面的列表
    this.$store.commit("setOpenedList");
  },
};
</script>
<style lang="scss" scoped>
.user-dropdown-menu-con {
  .user-dropdown-innercon {
    .text {
      color: var(--color-bk3);
      &::after {
        display: inline-block;
        content: "";
        height: 8px;
        width: 1px;
        background: var(--color-border);
        margin: 0 0 0 5px;
      }
    }
    .loginOut,
    .set {
      display: block;
      width: 30px;
      height: 30px;
      border-radius: 4px;
      cursor: pointer;
      &:hover {
        background: #eaeaea;
      }
      &:active {
        background: #d4d4d4;
      }
    }
    display: flex;
    align-items: center;
    padding: 0 10px 0 20px;
    .dropList {
      flex: 1;
      display: flex;
      align-items: center;
      img{
        width: 32px;
      }
    }
  }
}
.main-header-con {
  height: auto;
  box-shadow: none;
  .ivu-breadcrumb {
    & > span {
      &:last-child {
        font-weight: normal;
        color: var(--color-bk3);
      }
    }
    // :deep(.ivu-breadcrumb-item-link){
    //   cursor: pointer;
    //   &:hover{
    //     color: var(--info-color);
    //   }
    // }
  }
}
.main-header {
  padding: 24px 20px 8px;
  line-height: 22px;
  height: auto;
  box-shadow: none;
  background: transparent;
}
</style>
