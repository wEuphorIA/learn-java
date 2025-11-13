<template>
  <div class="search base-detail">
    <Card>
      <div class="boxBg">
        <div class="main-content">
          <div>
            <h3 class="tit">订单相关信息</h3>
            <div class="div-form-default formOrder">
              <dl>
                <dt>订单编号：</dt>
                <dd>
                  {{ afterSaleInfo.orderSn }}
                </dd>
              </dl>
              <dl v-if="afterSaleInfo.bankDepositName">
                <dt>银行开户行：</dt>
                <dd>
                  {{ afterSaleInfo.bankDepositName }}
                </dd>
              </dl>
              <dl v-if="afterSaleInfo.bankAccountName">
                <dt>银行开户名：</dt>
                <dd>
                  {{ afterSaleInfo.bankAccountName }}
                </dd>
              </dl>
              <dl v-if="afterSaleInfo.bankAccountNumber">
                <dt>银行卡号：</dt>
                <dd>
                  {{ afterSaleInfo.bankAccountNumber }}
                </dd>
              </dl>
            </div>
          </div>
          <div>
            <h3 class="tit">退货申请</h3>
            <div class="div-form-default">
              <dl>
                <dt>退货商品：</dt>
                <dd>
                  <div class="lImg">
                    <img :src="afterSaleInfo.goodsImage" />
                  </div>
                  <a @click="linkTo(afterSaleInfo.goodsId, afterSaleInfo.skuId)"
                    >{{ afterSaleInfo.goodsName }} </a
                  ><br />

                  <span>{{ afterSaleInfo.num }}(数量)</span>
                </dd>
              </dl>
              <dl>
                <dt>退货状态：</dt>
                <dd>{{ afterSaleInfo.serviceName }}</dd>
              </dl>
              <dl>
                <dt>退货退款编号：</dt>
                <dd>{{ afterSaleInfo.sn }}</dd>
              </dl>
              <dl>
                <dt>退货退款原因：</dt>
                <dd>{{ afterSaleInfo.reason }}</dd>
              </dl>
              <dl>
                <dt>申请退款金额：</dt>
                <dd>
                  <priceColorScheme
                    :value="afterSaleInfo.applyRefundPrice"
                    :color="$mainColor"
                  ></priceColorScheme>
                </dd>
              </dl>
              <dl v-if="afterSaleInfo.actualRefundPrice">
                <dt>实际退款金额：</dt>
                <dd>
                  <priceColorScheme
                    :value="afterSaleInfo.applyRefundPrice"
                    :color="$mainColor"
                  ></priceColorScheme>
                </dd>
              </dl>
              <dl v-if="afterSaleInfo.refundPoint">
                <dt>退还积分：</dt>
                <dd>{{ afterSaleInfo.refundPoint }}</dd>
              </dl>
              <dl>
                <dt>退货数量：</dt>
                <dd>{{ afterSaleInfo.num }}</dd>
              </dl>
              <dl>
                <dt>问题描述：</dt>
                <dd>{{ afterSaleInfo.problemDesc }}</dd>
              </dl>
              <dl>
                <dt>凭证：</dt>
                <dd v-if="afterSaleImage == ''">暂无凭证</dd>
                <dd v-else>
                  <div
                    class="div-img"
                    v-for="(item, index) in afterSaleImage"
                    :key="index"
                  >
                    <img class="complain-img" :src="item" />
                  </div>
                </dd>
              </dl>
            </div>
          </div>
        </div>
      </div>
      <div class="boxBg mt_20">
        <div class="main-content adviceRow">
          <div
            class="div-form-default"
            v-if="afterSaleInfo.serviceStatus == 'APPLY'"
          >
            <h3 class="tit">处理意见</h3>
            <dl>
              <dt>商家：</dt>
              <dd>
                <div class="div-content">
                  {{ afterSaleInfo.storeName }}
                </div>
              </dd>
            </dl>
            <dl>
              <dt>是否同意：</dt>
              <dd>
                <div class="div-content">
                  <RadioGroup
                    button-style="solid"
                    v-model="params.serviceStatus"
                  >
                    <Radio label="PASS">
                      <span>同意</span>
                    </Radio>
                    <Radio label="REFUSE">
                      <span>拒绝</span>
                    </Radio>
                  </RadioGroup>
                </div>
              </dd>
            </dl>
            <dl>
              <dt>申请退款金额：</dt>
              <dd>
                <priceColorScheme
                  :value="afterSaleInfo.applyRefundPrice"
                  :color="$mainColor"
                ></priceColorScheme>
              </dd>
            </dl>
            <dl>
              <dt>实际退款金额：</dt>
              <dd>
                <InputNumber
                  :min="0"
                  v-model="params.actualRefundPrice"
                  class="wt-400"
                />
              </dd>
            </dl>
            <dl class="remarkText">
              <dt class="remarkText">备注信息：</dt>
              <dd>
                <Input
                  v-model="params.remark"
                  type="textarea"
                  maxlength="200"
                  :rows="4"
                  clearable
                  class="wt-400"
                />
              </dd>
            </dl>
          </div>
          <div
            class="div-form-default"
            v-if="afterSaleInfo.serviceStatus != 'APPLY'"
          >
            <h3 class="tit">商家处理</h3>
            <dl>
              <dt>商家：</dt>
              <dd>
                <div class="div-content">
                  {{ afterSaleInfo.storeName }}
                </div>
              </dd>
            </dl>
            <!-- <dl>
              <dt>审核结果</dt>
              <dd>
                <div class="div-content">
                  <span v-if="params.serviceStatus=='PASS'">
                    审核通过
                  </span>
                  <span v-else>
                    审核拒绝
                  </span>
                </div>

              </dd>
            </dl> -->
            <dl>
              <dt>备注信息：</dt>
              <dd>
                {{ afterSaleInfo.auditRemark || "暂无备注信息" }}
              </dd>
            </dl>
          </div>

          <div
            class="div-form-default"
            v-if="
              afterSaleInfo.afterSaleAllowOperationVO &&
              afterSaleInfo.afterSaleAllowOperationVO.refund
            "
          >
            <h3 class="tit">平台退款</h3>
            <dl>
              <dt>银行开户行：</dt>
              <dd>
                {{ afterSaleInfo.bankDepositName }}
              </dd>
            </dl>
            <dl>
              <dt>银行开户名：</dt>
              <dd>
                {{ afterSaleInfo.bankAccountName }}
              </dd>
            </dl>
            <dl>
              <dt>银行卡号：</dt>
              <dd>
                {{ afterSaleInfo.bankAccountNumber }}
              </dd>
            </dl>
            <dl class="remarkText">
              <dt>备注信息：</dt>
              <dd>
                <Input
                  v-model="refundPriceForm.remark"
                  type="textarea"
                  maxlength="200"
                  :rows="4"
                  clearable
                  class="wt-400"
                />
              </dd>
            </dl>
            <dl>
              <dt>操作：</dt>
              <dd>
                <Button
                  type="primary"
                  :loading="submitLoading"
                  @click="refundPriceSubmit"
                  style="margin-left: 5px"
                >
                  退款
                </Button>
              </dd>
            </dl>
          </div>
          <div
            class="div-form-default"
            v-if="
              afterSaleInfo.showDelivery &&
              afterSaleInfo.serviceType === 'RETURN_GOODS'
            "
          >
            <h3 class="tit">物流信息</h3>
            <dl>
              <dt>收货商家：</dt>
              <dd>{{ afterSaleInfo.storeName }}</dd>
            </dl>
            <dl>
              <dt>收货商家手机：</dt>
              <dd>{{ storeMsg.salesConsigneeMobile }}</dd>
            </dl>
            <dl>
              <dt>收货地址：</dt>
              <dd>
                {{ storeMsg.salesConsigneeAddressPath }}
                {{ storeMsg.salesConsigneeDetail }}
              </dd>
            </dl>
            <dl>
              <dt>物流公司：</dt>
              <dd>{{ afterSaleInfo.mlogisticsName }}</dd>
            </dl>
            <dl>
              <dt>物流单号：</dt>
              <dd>
                {{ afterSaleInfo.mlogisticsNo }}
              </dd>
            </dl>
            <dl>
              <dt>操作：</dt>
              <dd>
                <Button
                  type="info"
                  :loading="submitLoading"
                  @click="logisticsSeller()"
                  style="margin-left: 5px"
                >
                  查询物流
                </Button>
              </dd>
            </dl>
          </div>
          <div class="footBtn">
              <Button
                type="default"
                :loading="submitLoading"
                @click="handleBack"
                class="btn mr_20"
              >
                返回
              </Button>
              <Button
              v-if="afterSaleInfo.serviceStatus == 'APPLY'"
                type="primary"
                :loading="submitLoading"
                @click="handleSubmit"
                class="btn"
              >
                确定
              </Button>
            </div>
        </div>
      </div>
    </Card>
    <!-- 查询物流 -->
    <Modal v-model="logisticsModal" width="40">
      <p slot="header">
        <span>查询物流</span>
      </p>
      <div class="layui-layer-wrap">
        <dl>
          <dt>售后单号：</dt>
          <dd>
            <div class="text-box">{{ sn }}</div>
          </dd>
        </dl>
        <dl>
          <dt>物流公司：</dt>
          <dd>
            <div class="text-box">{{ afterSaleInfo.mlogisticsName }}</div>
          </dd>
        </dl>
        <dl>
          <dt>物流单号：</dt>
          <dd>
            <div class="text-box">{{ afterSaleInfo.mlogisticsNo }}</div>
          </dd>
        </dl>
        <div class="div-express-log">
          <ul class="express-log">
            <template v-if="Object.keys(logisticsInfo).length">
              <li v-for="(item, index) in logisticsInfo.traces" :key="index">
                <span class="time">{{ item.AcceptTime }}</span>
                <span class="detail">{{ item.AcceptStation }}</span>
              </li>
            </template>
            <template v-else>
              <li style="text-align: center">暂无物流信息</li>
            </template>
          </ul>
        </div>
      </div>
      <div slot="footer" style="text-align: right">
        <Button @click="logisticsClose">取消</Button>
      </div>
    </Modal>
  </div>
</template>

<script>
import * as API_Order from "@/api/order";
import vueQr from "vue-qr";
export default {
  components: {
    "vue-qr": vueQr,
  },
  name: "orderDetail",
  data() {
    return {
      sn: "", // 订单号
      logisticsModal: false, //查询物流模态框

      logisticsInfo: {}, //物流信息
      afterSaleInfo: {}, // 售后信息
      afterSaleImage: [], //会员申诉图片
      submitLoading: false, // 添加或编辑提交状态
      storeMsg: {}, // 商家地址信息
      //商家处理意见
      params: {
        serviceStatus: "PASS",
        remark: "",
      },
      //平台退款
      refundPriceForm: {
        remark: "",
      },
      afterSaleStatusList: [
        // 售后状态列表
        {
          name: "申请中",
          status: "APPLY",
        },
        {
          name: "通过",
          status: "PASS",
        },
        {
          name: "拒绝",
          status: "REFUSE",
        },
        {
          name: "买家退货，待卖家收货",
          status: "BUYER_RETURN",
        },
        {
          name: "卖家确认收货",
          status: "SELLER_CONFIRM",
        },
        {
          name: "卖家终止售后",
          status: "SELLER_TERMINATION",
        },
        {
          name: "买家取消售后",
          status: "BUYER_CANCEL",
        },
        {
          name: "完成售后",
          status: "COMPLETE",
        },
        {
          name: "等待平台退款",
          status: "WAIT_REFUND",
        },
      ],
    };
  },
  methods: {
    // 获取售后详情
    getDetail() {
      this.loading = true;
      API_Order.getAfterSaleOrderDetail(this.sn).then((res) => {
        this.loading = false;
        if (res.success) {
          this.afterSaleInfo = res.result;
          this.afterSaleInfo.showDelivery = this.showDelivery(
            this.afterSaleInfo.serviceStatus
          );
          this.afterSaleInfo.serviceName = this.filterOrderStatus(
            this.afterSaleInfo.serviceStatus
          );
          this.afterSaleImage = (res.result.afterSaleImage || "").split(",");
          //退货地址去掉逗号
          if (this.afterSaleInfo.mconsigneeAddressPath)
            this.afterSaleInfo.mconsigneeAddressPath =
              this.afterSaleInfo.mconsigneeAddressPath.replaceAll(",", " ");

          this.$set(
            this.params,
            "actualRefundPrice",
            this.afterSaleInfo.applyRefundPrice
          );
          // 如果显示物流信息，展示商家地址
          if (this.afterSaleInfo.showDelivery) {
            API_Order.storeAddress(this.sn).then((resu) => {
              if (resu.success) {
                const obj = resu.result;
                obj.salesConsigneeAddressPath =
                  obj.salesConsigneeAddressPath.replaceAll(",", "");
                this.storeMsg = obj;
              }
            });
          }
        }
      });
    },
    //平台退款
    refundPriceSubmit() {
      if (this.refundPriceForm.remark == "") {
        this.$Message.error("请输入退款备注");
        return;
      }
      this.$Modal.confirm({
        title: "确认退款",
        content: "请确认退款？",
        loading: true,
        onOk: () => {
          API_Order.refundPrice(this.sn, this.refundPriceForm).then((res) => {
            this.$Modal.remove();
            if (res.success) {
              this.$Message.success("收款成功");
              this.getDetail();
            }
          });
        },
      });
    },
    //查询物流
    logisticsSeller() {
      this.logisticsModal = true;
      API_Order.getAfterSaleTraces(this.sn).then((res) => {
        if (res.success && res.result != null) {
          this.logisticsInfo = res.result;
        }
      });
    },
    //关闭物流弹出框
    logisticsClose() {
      this.logisticsModal = false;
    },
    //回复
    handleSubmit() {
      if (this.params.remark == "") {
        this.$Message.error("请输入备注信息");
        return;
      }
      if (this.params.actualRefundPrice == "") {
        this.$Message.error("请输入退款金额");
        return;
      }
      API_Order.afterSaleSellerReview(this.sn, this.params).then((res) => {
        this.submitLoading = false;
        if (res.success) {
          this.$Message.success("审核成功");
          this.params.remark = "";
          this.getDetail();
        }
      });
    },
    filterOrderStatus(status) {
      // 获取订单状态中文
      const ob = this.afterSaleStatusList.filter((e) => {
        return e.status === status;
      });
      return ob[0].name;
    },
    // 根据订单状态判断是否显示物流信息
    showDelivery(status) {
      let flag = false;
      this.afterSaleStatusList.forEach((e, index) => {
        // 订单为买家退货，待卖家收货之后的状态，并且不是买家取消售后，展示物流信息
        if (e.status === status && index >= 3 && index !== 6) {
          flag = true;
        }
      });
      return flag;
    },
    // 返回订单列表
    handleBack() {
      this.$options.filters.customRouterPush({
        name: "afterSaleOrder",
      });
    },
  },
  mounted() {
    this.sn = this.$route.query.sn;
    this.getDetail();
  },
};
</script>
<style lang="scss">
/deep/ .ivu-col {
  width: 100% !important;
}
.complain-upload-list {
  display: inline-block;
  width: 60px;
  height: 60px;
  text-align: center;
  line-height: 60px;
  border: 1px solid transparent;
  border-radius: 4px;
  overflow: hidden;
  background: #fff;
  position: relative;
  box-shadow: 0 1px 1px rgba(0, 0, 0, 0.2);
  margin-right: 4px;
}
.complain-upload-list img {
  width: 100%;
  height: 100%;
}
.complain-upload-list-cover {
  display: none;
  position: absolute;
  top: 0;
  bottom: 0;
  left: 0;
  right: 0;
  background: rgba(0, 0, 0, 0.6);
}
.complain-upload-list:hover .complain-upload-list-cover {
  display: block;
}
.complain-upload-list-cover i {
  color: #fff;
  font-size: 20px;
  cursor: pointer;
  margin: 0 2px;
}
</style>
