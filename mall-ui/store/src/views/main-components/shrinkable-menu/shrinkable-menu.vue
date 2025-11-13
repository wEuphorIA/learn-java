<style lang="scss" scoped>
@import "./styles/menu.scss";
</style>
<template>
  <div class="ivu-shrinkable-menu">
    <Menu
      ref="sideMenu"
      width="208px"
      @on-select="changeMenu"
      :active-name="currNav"
      theme="light"
      accordion
    >
      <MenuItem name="index" class="home"
        ><i class="iconfont icon-menu-home"></i>首页</MenuItem
      >
      <Submenu v-for="(item, o) in navList" :key="'1-' + o" :name="'1-' + o">
        <template slot="title">
          <i class="iconfont" :class="'icon-menu-' + item.name"></i>
          {{ item.title }}
        </template>
        <Submenu  v-for="val in item.children" :key="val.id" :name="val.id">
          <template slot="title">{{ val.title }}</template>
          <MenuItem
            v-for="obj in val.children"
            :key="obj.name"
            :name="obj.name"
            >{{ obj.title }}</MenuItem
          >
        </Submenu>
      </Submenu>
    </Menu>
  </div>
</template>

<script>
import util from "@/libs/util.js";
export default {
  name: "shrinkableMenu",
  computed: {
    // 二级菜单列表
    menuList() {
      return this.$store.state.app.menuList;
    },
    // 一级菜单
    navList() {
      return this.$store.state.app.navList;
    },
    // 当前一级菜单
    currNav() {
      return this.$store.state.app.currNav;
    },
  },
  watch: {
    // 监听路由变化
    $route: {
      handler: function (val, oldVal) {
        if (
          val.meta.firstRouterName &&
          val.meta.firstRouterName !== this.currNav
        ) {
          this.selectNav(val.meta.firstRouterName);
        }
      },
    },
  },
  methods: {
    changeMenu(name) {
      if (name === "index") {
        this.$router.push({
          path: "/",
        });
      } else {
        //二级路由点击
        this.$router.push({
          name: name,
        });
      }
    },
    selectNav(name) {
      console.log(name);
      // // 一级路由点击
      // this.$store.commit("childrenMenu", this.$refs.childrenMenu);
      // this.$store.commit("setCurrNav", name);
      // this.setStore("currNav", name);
      // util.initRouter(this);
    },
  },
};
</script>
<style lang="scss" scoped>
.ivu-menu-dark.ivu-menu-vertical .ivu-menu-item-active:not(.ivu-menu-submenu),
.ivu-menu-dark.ivu-menu-vertical
  .ivu-menu-submenu-title-active:not(.ivu-menu-submenu) {
  color: var(--info-color);
}
:deep(.ivu-menu-vertical) {
  .ivu-menu-item {
    height: 40px;
    line-height: 40px;
    padding: 0;
    padding-left: 57px !important;
    display: flex;
    align-items: center;
    .iconfont {
      margin-right: 8px;
      font-size: 28px;
    }
  }
  .home{
    &.ivu-menu-item {
      padding-left: 14px !important;
    }
  }
  .ivu-menu-submenu-title {
    display: flex;
    align-items: center;
    padding: 8px 14px;
    i > {
      margin-right: 0;
    }
    .iconfont {
      margin-right: 8px;
      font-size: 28px;
    }
  }
  .ivu-menu-submenu-title-icon {
    right: 18px;
  }
  .ivu-menu {
    .ivu-menu-submenu {
      padding-left: 14px;
    }
  }
  .ivu-menu-item:hover,
  .ivu-menu-submenu-title:hover {
    color: var(--info-color);
  }
  .ivu-menu-child-item-active {
    color: var(--info-color);
    & > .ivu-menu-submenu-title {
      color: var(--info-color);
    }
    .ivu-menu-item-active {
      color: var(--info-color);
    }
    .ivu-menu-item-active {
      background: #fff6f2;
      &::after {
        width: 4px;
        background: var(--info-color);
      }
    }
  }
}
// .ivu-menu-light.ivu-menu-vertical .ivu-menu-item-active {
//     color: var(--info-color);
//     background: #FFF6F2;
//   }
.ivu-menu-light.ivu-menu-vertical .ivu-menu-item-active:not(.ivu-menu-submenu) {
  background: #fff6f2;
  color: var(--info-color);
  &::after {
    width: 4px;
    background: var(--info-color);
  }
}
.ivu-menu-vertical.ivu-menu-light:after {
  display: none;
}
</style>
