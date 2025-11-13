<style lang="scss">
@import "./main.scss";
</style>
<template>
  <div class="main">
    <!-- 左侧菜单 -->
    <div class="sidebar-menu-con menu-bar">
      <div class="logo-con">
        <img :src="storeSideLogo" key="max-logo" />
        <!-- <img :src="domainLogo" key="max-logo" /> -->
      </div>
      <shrinkable-menu></shrinkable-menu>
      <div class="user-dropdown-menu-con">
        <Row
          type="flex"
          justify="end"
          align="middle"
          class="user-dropdown-innercon"
        >
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
                  fill="#7E736F"
                  stroke="#7E736F"
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
    <div class="main-header-con">
      <!-- 已打开的页面标签 -->
      <div class="tags-con" v-if="setting.isUseTabsRouter">
        <tags-page-opened :pageTagsList="pageTagsList"></tags-page-opened>
      </div>
    </div>
    <div
      class="single-page-con"
      :style="{
        top: setting.isUseTabsRouter ? '70px' : '70px',
        height: 'calc(100% - 70px)',
      }"
    >
      <div class="single-page">
        <!-- <keep-alive :include="cachePage"> -->
        <!-- <router-view></router-view> -->
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
import shrinkableMenu from "./main-parts/shrinkable-menu/shrinkable-menu.vue";
import tagsPageOpened from "./main-parts/tags-page-opened.vue";
import messageTip from "./main-parts/message-tip.vue";
import circleLoading from "@/components/lili/circle-loading.vue";
import configDrawer from "@/components/lili/config-drawer.vue";
import Cookies from "js-cookie";
import util from "@/libs/util.js";
import { getNoticePage, logout } from "@/api/index";
import { getBaseSite } from "@/api/common";

var client;
const config = require("@/config/index.js");
export default {
  components: {
    shrinkableMenu,
    tagsPageOpened,
    messageTip,
    circleLoading,
    configDrawer,
  },
  data() {
    return {
      config,
      sliceNum: 5, // 展示nav数量
      userInfo: "", // 用户信息
      tipsMessage: "", // 通知消息
      domainLogo: "",
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
      return this.$store.state.app.pageOpenedList; // 打开的页面的页面对象
    },
    avatarPath() {
      return localStorage.avatorImgPath;
    },
    lang() {
      return this.$store.state.app.lang;
    },
  },

  methods: {
    handleClickSetting() {
      this.$refs.config.open();
    },
    init() {
      // 菜单初始化
      let userInfo = JSON.parse(Cookies.get("userInfoManager"));

      this.userInfo = userInfo;
      this.checkTag(this.$route.name);
      let currWidth = document.body.clientWidth;
      if (currWidth <= 1200) {
        this.sliceNum = 2;
      }
      this.domainLogo = localStorage.getItem("icon");
      let link =
        document.querySelector("link[rel*='icon']") ||
        document.createElement("link");
      link.type = "image/x-icon";
      link.href = localStorage.getItem("domainIcon");
      link.rel = "shortcut icon";
      document.getElementsByTagName("head")[0].appendChild(link);
      window.document.title = localStorage.getItem("title") + " - 运营后台";
      // 读取未读消息数
      getNoticePage({}).then((res) => {
        if (res.success) {
          this.tipsMessage = res.result;

          this.$store.state.notices = res.result;
        }
      });
    },

    //用户头像下方抽屉点击
    handleClickUserDropdown(name) {
      //个人中心
      if (name === "personalCenter") {
        util.openNewPage(this, "personal-center");
        this.$router.push({
          name: "personal-center",
        });
      }
      //修改密码
      else if (name === "changePass") {
        util.openNewPage(this, "change-password");
        this.$router.push({
          name: "change_password",
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
    //切换标签
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
    //宽度动态计算
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
    $route(to, from) {
      this.checkTag(to.name);
      localStorage.currentPageName = to.name;
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
        background: #7E736F;
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
      img {
        width: 24px;
        height: 24px;
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
