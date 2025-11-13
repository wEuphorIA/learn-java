<template>
<div class="boxBg boxPad">
  <Card>
    <div class="step-list" v-if="!checked">
      <div class="step-item" @click="downLoad">
        <div class="imgs">
          <img class="img" src="@/assets/download.png" alt="" />
        </div>
        <div class="tit">下载模板</div>
      </div>
      <div class="step-item">
        <div class="upload">
          <Upload
            :before-upload="handleUpload"
            :on-success="handleSuccess"
            name="files"
            accept="application/vnd.openxmlformats-officedocument.spreadsheetml.sheet, application/vnd.ms-excel"
            multiple
            type="drag"
            :action="action"
            :headers="accessToken"
          >
            <img class="img" src="@/assets/upload.png" alt="" />
          </Upload>
        </div>
        <div class="tit">上传数据</div>
      </div>
    </div>
    <!-- 上传 -->
    <div v-else class="tpl success">
      <div class="iconBox">
        <div class="icon"><Icon type="md-checkmark" /></div>
      </div>

      <div class="tit">发货完成</div>

      <div>
        <Button class="btn" @click="close">关闭页面</Button>
        <Button class="btn" type="primary" @click="navigationToGoodsOrder"
          >商品订单</Button
        >
      </div>
    </div>
  </Card>
  </div>
</template>

<script>
import JsonExcel from "vue-json-excel";
import { downLoadDeliverExcel, uploadDeliverExcel } from "@/api/order.js";
import { baseUrl } from "@/libs/axios.js";
export default {
  components: {
    "download-excel": JsonExcel,
  },
  data() {
    return {
      file: "",
      action: baseUrl + "/order/order/batchDeliver", // 上传接口
      accessToken: {}, // 验证token
      // 步骤集合
      stepList: [
        {
          img: require("@/assets/download.png"),
          title: "下载模板",
          checked: true,
        },
        {
          img: require("@/assets/upload.png"),
          title: "上传数据",
          checked: false,
        },
        {
          img: require("@/assets/success.png"),
          title: "3.完成",
          checked: false,
        },
      ],
      checked: false,
    };
  },
  mounted() {
    this.accessToken.accessToken = this.getStore("accessToken");
  },
  methods: {
    // // 点击选择步骤
    // handleCheckStep(val) {
    //   if (val.title.search("3") == -1) {
    //     this.stepList.map((item) => {
    //       item.checked = false;
    //     });
    //     val.checked = true;
    //   }
    // },
    // 上传数据
    handleUpload(file) {
      this.file = file;
      this.upload();
      return false;
    },
    handleSuccess(response, file, fileList) {
      console.log(response, file, fileList, 4555);
    },
    // 跳转订单列表
    navigationToGoodsOrder() {
      this.$router.push({
        path: "/orderList",
      });
    },
    // 关闭页面
    close() {
      this.$store.commit("removeTag", "export-order-deliver");
      localStorage.storeOpenedList = JSON.stringify(
        this.$store.state.app.storeOpenedList
      );
      this.$router.go(-1);
    },

    /**
     * 上传文件
     */
    async upload() {
      let fd = new FormData();
      fd.append("files", this.file);
      let res = await uploadDeliverExcel(fd);
      if (res.success) {
        this.stepList.map((item) => {
          item.checked = false;
        });

        this.checked = true;
      }
    },

    /**
     * 下载excel
     */
    downLoad() {
      downLoadDeliverExcel()
        .then((res) => {
          const blob = new Blob([res], {
            type: "application/vnd.ms-excel;charset=utf-8",
          });
          //对于<a>标签，只有 Firefox 和 Chrome（内核） 支持 download 属性
          //IE10以上支持blob但是依然不支持download
          if ("download" in document.createElement("a")) {
            //支持a标签download的浏览器
            const link = document.createElement("a"); //创建a标签
            link.download = "批量发货导入模板.xls"; //a标签添加属性
            link.style.display = "none";
            link.href = URL.createObjectURL(blob);
            document.body.appendChild(link);
            link.click(); //执行下载
            URL.revokeObjectURL(link.href); //释放url
            document.body.removeChild(link); //释放标签
          } else {
            navigator.msSaveBlob(blob, fileName);
          }
        })
        .catch((err) => {
          console.log(err);
        });
    },
  },
};
</script>

<style lang="scss" scoped>
.boxBg{
  height:calc(100vh - 100px);
  display: flex;
  align-items: center;
}
.step-list {
  width: 80%;
  min-width: 500px;
  max-width: 1160px;
  margin: 0 auto;
  display: flex;
  padding: 40px;
  justify-content: space-between;
}
h2 {
  text-align: center;
  margin: 10px 0;
}
.tpl {
  display: flex;
  justify-content: center;
}
.active {
  // background: #efefef;
  // border-radius: 0.8em;
}
.tit {
  font-size: 16px;
  line-height: 22px;
  color: #191919;
  font-weight: 600;
  padding-top: 28px;
}
.step-item {
  width: 100%;
  padding: 0 20px;
  display: flex;
  align-items: center;
  flex-direction: column;
  justify-content: center;
  transition: 0.35s;
  cursor: pointer;

  .upload {
    width: 238px;
    height: 238px;
    .ivu-upload {
      :deep(.ivu-upload-drag) {
        width: 238px !important;
        height: 238px !important;
        display: flex;
        align-items: center;
        justify-content: center;
        img {
          width: 166px;
          height: 166px;
        }
      }
    }
  }
}
.imgs {
  width: 238px;
  height: 238px;
  background: #fdfbfa;
  border: 1px dashed rgba($color: #000000, $alpha: 0.15);
  display: flex;
  align-items: center;
  justify-content: center;
  &:hover {
    border-color: var(--info-color);
  }
  img {
    width: 166px;
    height: 166px;
  }
}
.iconBox {
  .icon {
    width: 72px;
    height: 72px;
    border-radius: 36px;
    background: #27ba9b;
    display: flex;
    align-items: center;
    justify-content: center;
  }
  .ivu-icon {
    color: #fff;
    font-size: 50px;
  }
  
}
.success {
  align-items: center;
  flex-direction: column;
  .tit {
    padding-top: 24px;
  }
  /deep/ .btn {
    margin: 24px 4px 0px;
    height: 32px;
    line-height: 32px;
  }
  .ivu-btn-default{
    background: #fff;
    border: 1px solid #d9d9d9;
  }
}
</style>
