<template>
  <div class="base-detail goodDetail">
    <div class="boxBg">
      <Card>
        <div class="base-info-item">
          <div class="title">基本信息</div>
          <div class="form-item-view">
            <div class="info-item">
              <div class="lText">商品分类：</div>
              <span v-for="(item, index) in goods.categoryName" :key="index">
                {{ item }}
                <i v-if="index !== goods.categoryName.length - 1">&gt;</i>
              </span>
            </div>
            <div class="info-item">
              <div class="lText">商品名称：</div>
              <span>{{ goods.goodsName }}</span>
            </div>

            <div class="info-item">
              <div class="lText">商品卖点：</div>
              <span>{{ goods.sellingPoint }}</span>
            </div>
            <div class="info-item info-100">
              <div class="lText">商品参数：</div>
              <div
                v-if="
                  goods.goodsParamsDTOList && goods.goodsParamsDTOList.length
                "
                v-for="(item, index) in goods.goodsParamsDTOList"
                :key="index"
              >
                <div
                  style="
                    margin-bottom: 10px;
                    display: flex;
                    align-items: center;
                  "
                >
                  {{ item.groupName }}：
                  <tag
                    v-for="(child, i) in item.goodsParamsItemDTOList"
                    :key="i"
                  >
                    {{ child.paramName }} - {{ child.paramValue }}
                  </tag>
                </div>
              </div>
            </div>
          </div>
          <div class="title">商品交易信息</div>
          <div class="form-item-view">
            <div class="info-item">
              <div class="lText">计量单位：</div>
              <span> {{ goods.goodsUnit }}</span>
            </div>
            <div class="info-item">
              <div class="lText">销售模式：</div>
              <span>{{
                goods.salesModel === "RETAIL" ? "零售型" : "批发型"
              }}</span>
            </div>
            <div class="info-item" v-if="goods.salesModel !== 'RETAIL'">
              <div class="lText">销售规则：</div>
              <Table
                border
                :columns="wholesalePreviewColumns"
                :data="wholesaleData"
              >
              </Table>
            </div>
          </div>
          <div class="title">商品规格及图片</div>
          <div class="form-item-view">
            <div class="info-item">
              <div class="lText">商品编号：</div>
              <span> {{ goods.id }}</span>
            </div>
            <div class="info-item">
              <div class="lText">商品价格：</div>
              <span>
                <priceColorScheme
                  :value="goods.price"
                  :color="$mainColor"
                ></priceColorScheme>
              </span>
            </div>
            <div class="info-item">
              <div class="lText">商品图片：</div>
              <div
                class="demo-upload-list"
                v-for="(item, __index) in goods.goodsGalleryList"
                :key="__index"
              >
                <img :src="item" />
                <div class="demo-upload-list-cover">
                  <Icon
                    type="ios-eye-outline"
                    @click.native="handleViewGoodsPicture(item)"
                  ></Icon>
                </div>
                <Modal title="View Image" v-model="goodsPictureVisible">
                  <img
                    :src="previewGoodsPicture"
                    v-if="goodsPictureVisible"
                    style="width: 100%"
                  />
                </Modal>
              </div>
            </div>
            <div class="info-item">
              <div class="lText">商品视频：</div>
              <span
                ><video
                  v-if="goods.goodsVideo"
                  controls
                  class="player"
                  :src="goods.goodsVideo"
              /></span>
            </div>
            <div class="info-item info-100">
              <div class="lText">商品规格：</div>
              <Table :columns="skuColumn" :data="skuData" class="goodTable">
                <template slot="showImage" slot-scope="scope">
                  <div style="margin-top: 5px; display: flex">
                    <div>
                      <img
                        v-for="(item, index) in scope.row.image"
                        :key="index"
                        :src="item"
                        style="height: 60px; margin: 10px; width: 60px"
                      />
                    </div>
                  </div>
                </template>
                <template slot-scope="{ row }" slot="wholePrice0">
                  <Input
                    v-if="wholesaleData[0]"
                    clearable
                    disabled
                    v-model="wholesaleData[0].price"
                  >
                    <span slot="append">元</span>
                  </Input>
                </template>
                <template slot-scope="{ row }" slot="wholePrice1">
                  <Input
                    v-if="wholesaleData[1]"
                    clearable
                    disabled
                    v-model="wholesaleData[1].price"
                  >
                    <span slot="append">元</span>
                  </Input>
                </template>
                <template slot-scope="{ row }" slot="wholePrice2">
                  <Input
                    v-if="wholesaleData[2]"
                    clearable
                    disabled
                    v-model="wholesaleData[2].price"
                  >
                    <span slot="append">元</span>
                  </Input>
                </template>
              </Table>
            </div>
          </div>
          <div class="title">商品详情描述</div>
          <div class="form-item-view">
            <div class="info-item">
              <div class="lText">商品描述：</div>
              <div v-html="goods.intro"></div>
            </div>
            <div class="info-item" label="">
              <div class="lText">移动端描述：</div>
              <div v-html="goods.mobileIntro"></div>
            </div>
          </div>
        </div>
        <div class="footBtn goBack">
        <Button type="default" @click="handleBack" class="btn">返回</Button>
      </div>
      </Card>
    </div>
  </div>
</template>
<script>
import { getGoodsDetail } from "@/api/goods";
export default {
  name: "goodsDetail",
  data() {
    return {
      goods: {}, // 商品信息
      previewGoodsPicture: "", // 预览图片
      goodsPictureVisible: false, // 预览图片模态框
      wholesalePreviewColumns: [
        {
          title: "销售规则",
          width: 300,
          render: (h, params) => {
            let guide =
              "当商品购买数量 ≥" +
              params.row.num +
              " 时，售价为 ￥" +
              params.row.price +
              " /" +
              this.goods.goodsUnit;
            return h("div", guide);
          },
        },
      ],
      wholesaleData: [],
      skuColumn: [
        // 规格表头
        {
          title: "规格",
          key: "specs",
        },
        {
          title: "编号",
          key: "sn",
        },
        {
          title: "重量(kg)",
          key: "weight",
        },
      ],
      skuData: [], // sku数据
    };
  },
  mounted() {
    this.initGoods(this.$route.query.id);
  },
  methods: {
    // 初始化数据，获取商品详情
    initGoods(id) {
      getGoodsDetail(id).then((res) => {
        this.goods = res.result;
        let that = this;
        res.result.skuList.forEach(function (sku, index, array) {
          that.skuData.push({
            specs: sku.goodsName,
            sn: sku.sn,
            weight: sku.weight,
            cost: sku.cost,
            price: sku.price,
            image: sku.goodsGalleryList,
            quantity: sku.quantity,
          });
        });
        if (res.result.salesModel === "WHOLESALE" && res.result.wholesaleList) {
          res.result.wholesaleList.forEach((item, index) => {
            this.skuColumn.push({
              title: "购买量 ≥ " + item.num,
              slot: "wholePrice" + index,
            });
          });
        } else {
          this.skuColumn.push(
            // {
            //   title: "成本",
            //   key: "cost",
            //   render: (h, params) => {
            //     console.log(params)
            //     return h("priceColorScheme", {props:{value:params.row.cost,color:this.$mainColor}} );
            //   },
            // },
            {
              title: "价格",
              key: "price",
              render: (h, params) => {
                return h("priceColorScheme", {
                  props: { value: params.row.price, color: this.$mainColor },
                });
              },
            },
            {
              title: "库存",
              key: "quantity",
            }
          );
        }
        this.skuColumn.push({
          title: "图片",
          slot: "showImage",
        });
        this.wholesaleData = res.result.wholesaleList;
      });
    },
    // 预览商品图片
    handleViewGoodsPicture(url) {
      this.previewGoodsPicture = url;
      this.goodsPictureVisible = true;
    },
    // 返回商品列表
    handleBack() {
      this.$options.filters.customRouterPush({
        name: "managerGoods",
      });
    },
  },
};
</script>

<style lang="scss" soped>
/*平铺*/
.goodDetail{
  .base-info-item {
  padding: 20px;
  .title {
    color: var(--color-bk1);
    font-weight: 600;
    line-height: 25px;
    font-size: 18px;
    padding-bottom: 18px;
  }

  .form-item-view {
    display: flex;
    justify-content: space-between;
    flex-wrap: wrap;
    border-bottom: 1px solid var(--color-border);
    padding-bottom: 12px;
    margin-bottom: 20px;
    &:last-child{
      border: 0 none;
      padding: 0;
      margin: 0;
    }
    .info-item {
      padding: 8px 0;
      line-height: 22px;
      display: flex;
      color: var(--color-bk1);
      width: 50%;
      &.info-100{
        width: 100%;
      }
    }
  }
  .lText {
    width: 108px;
    padding-left: 24px;
    color: var(--color-bk3);
  }
}
}


.demo-upload-list {
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
.demo-upload-list img {
  width: 100%;
  height: 100%;
}
.demo-upload-list-cover {
  display: none;
  position: absolute;
  top: 0;
  bottom: 0;
  left: 0;
  right: 0;
  background: rgba(0, 0, 0, 0.6);
}
.demo-upload-list:hover .demo-upload-list-cover {
  display: block;
}
.demo-upload-list-cover i {
  color: #fff;
  font-size: 20px;
  cursor: pointer;
  margin: 0 2px;
}
.ivu-table table {
  width: 100% !important;
}
.goodTable{
  width: 100%;
}
</style>
