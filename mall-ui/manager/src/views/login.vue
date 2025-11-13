<template>
  <div class="login">
    <Row @keydown.enter.native="submitLogin" class="flex">
      <Col span="10" class="frm-col">
        <div class="leftForm">
          <Row class="header">
            <div class="logo"></div>
          </Row>
          <Row style="flex-direction: column">
            <Form
              ref="usernameLoginForm"
              :model="form"
              :rules="rules"
              class="form"
            >
              <FormItem prop="username">
                <Input
                  v-model="form.username"
                  prefix="ios-contact"
                  size="large"
                  clearable
                  placeholder="请输入用户名"
                  autocomplete="off"
                />
              </FormItem>
              <FormItem prop="password">
                <Input
                  type="password"
                  v-model="form.password"
                  prefix="ios-lock"
                  size="large"
                  password
                  placeholder="请输入密码"
                  autocomplete="off"
                />
              </FormItem>
            </Form>

            <Row>
              <div
                class="login-btn"
                type="primary"
                size="large"
                :loading="loading"
                @click="submitLogin"
                long
              >
                <span v-if="!loading">登录</span>
                <span v-else>登录中</span>
              </div>
            </Row>
          </Row>
          <!-- <Footer /> -->
        </div>
      </Col>
      <Col span="14"> <div class="rightBg"></div> </Col>
      <!-- <LangSwitch /> -->
    </Row>
  </div>
</template>

<script>
import { login, userInfo } from "@/api/index";
import Cookies from "js-cookie";
import Header from "@/views/main-parts/header";
import Footer from "@/views/main-parts/footer";
import LangSwitch from "@/views/main-parts/lang-switch";
import util from "@/libs/util.js";
import verify from "@/components/verify";

export default {
  components: {
    LangSwitch,
    Header,
    Footer,
    verify,
  },
  data() {
    return {
      loading: false, // 加载状态
      form: {
        // 表单数据
        username: "admin",
        password: "111111",
        mobile: "",
        code: "",
      },
      rules: {
        // 验证规则
        username: [
          {
            required: true,
            message: "账号不能为空",
            trigger: "blur",
          },
        ],
        password: [
          {
            required: true,
            message: "密码不能为空",
            trigger: "blur",
          },
        ],
      },
    };
  },
  methods: {
    afterLogin(res) {
      // 登录成功后处理
      let accessToken = res.result.accessToken;
      let refreshToken = res.result.refreshToken;
      this.setStore("accessToken", accessToken);
      this.setStore("refreshToken", refreshToken);
      // 获取用户信息
      userInfo().then((res) => {
        if (res.success) {
          // 加载菜单
          Cookies.set("userInfoManager", JSON.stringify(res.result));
          this.$store.commit("setAvatarPath", res.result.avatar);
          util.initRouter(this);
          const redirectRouter = this.$route.query.redirect;
          // 加载菜单
          const push = {
            path: redirectRouter || "/home",
          };

          this.$router.push(push);
        } else {
          this.loading = false;
        }
      });
    },
    submitLogin() {
      // 登录操作
      this.$refs.usernameLoginForm.validate((valid) => {
        if (valid) {
          // this.$refs.verify.init();

          let fd = new FormData();
          fd.append("username", this.form.username);
          fd.append("password", this.md5(this.form.password));
          login(fd)
            .then((res) => {
              this.loading = false;
              if (res && res.success) {
                this.afterLogin(res);
              }
            })
            .catch(() => {
              this.loading = false;
            });
        }
      });
    },
    verifyChange(con) {
      // 拼图验证码回显
      if (!con.status) return;

      this.loading = true;

      let fd = new FormData();
      fd.append("username", this.form.username);
      fd.append("password", this.md5(this.form.password));
      login(fd)
        .then((res) => {
          if (res && res.success) {
            this.afterLogin(res);
          } else {
            this.loading = false;
          }
        })
        .catch(() => {
          this.loading = false;
        });
      this.$refs.verify.show = false;
    },
  },
};
</script>
<style lang="scss" scoped src="./../styles/login.scss"></style>
