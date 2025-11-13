<template>
  <div class="contentBox">
    <div class="boxBg boxPad">
      <div class="tableBox">
        <div class="export">
          <Button @click="handleAddParamsGroup" type="primary">添加</Button>
        </div>

        <div class="row">
          <Card v-if="paramsGroup.length == 0"> 暂无参数绑定信息 </Card>
          <div class="paramsGroup" v-else>
            <Card
              v-for="(group, index) in paramsGroup"
              :key="index"
              :bordered="false"
            >
              <p slot="title">
                {{ group.groupName }}
              </p>
              <p slot="extra">
                <Dropdown slot="extra">
                  <a href="javascript:void(0)">
                    操作
                    <Icon type="ios-arrow-down"></Icon>
                  </a>
                  <Dropdown-menu slot="list">
                    <Dropdown-item @click.native="handleEditParamsGroup(group)"
                      >编辑</Dropdown-item
                    >
                    <Dropdown-item @click.native="handleOpen(group)"
                      >删除</Dropdown-item
                    >
                  </Dropdown-menu>
                </Dropdown>
                <Icon type="arrow-down-b"></Icon>
              </p>
              <template v-if="group.params && group.params.length > 0">
                <div
                  v-for="(param, paramId) in group.params"
                  :key="paramId"
                  class="params"
                >
                  <span>{{ param.paramName }}</span>

                  <span>
                    <span
                      class="fontCol"
                      @click="handleEditParams(group, param)"
                      >编辑</span
                    >
                    <span
                      class="fontCol ml_10"
                      @click="handleOpen(group, param)"
                      >删除</span
                    >
                  </span>
                </div>
              </template>
              <div v-else style="align-content: center">暂无数据...</div>
              <div class="footBtn">
                <i-button type="text" @click="handleAddParams(group)"
                  >添加</i-button
                >
              </div>
            </Card>
          </div>
        </div>
      </div>
      <div>
        <Modal
          :title="modalTitle"
          v-model="dialogParamsVisible"
          :mask-closable="false"
        >
          <div class="dialogCenter">
            <Form
              ref="paramForm"
              :model="paramForm"
              :label-width="100"
              :rules="formValidate"
            >
              <FormItem label="参数名称：" prop="paramName">
                <Input v-model="paramForm.paramName" class="wt-400" />
              </FormItem>
              <FormItem label="可选值：" prop="options">
                <Select
                  v-model="paramForm.options"
                  placeholder="输入后回车添加"
                  multiple
                  filterable
                  allow-create
                  :popper-append-to-body="false"
                  popper-class="spec-values-popper"
                  class="wt-400"
                >
                  <Option
                    v-for="(item, itemIndex) in ops.options"
                    :value="item"
                    :key="itemIndex"
                    :label="item"
                  >
                    {{ item }}
                  </Option>
                </Select>
              </FormItem>
              <FormItem label="选项：" prop="specName3">
                <Checkbox label="1" v-model="paramForm.required">必填</Checkbox>
                <Checkbox label="1" v-model="paramForm.isIndex"
                  >可索引</Checkbox
                >
              </FormItem>
              <FormItem label="排序：" prop="sort">
                <InputNumber :min="0" type="number" v-model="paramForm.sort" />
              </FormItem>
            </Form>
          </div>
          <div slot="footer">
            <Button type="text" @click="dialogParamsVisible = false"
              >取消</Button
            >
            <Button
              type="primary"
              :loading="submitLoading"
              @click="submitParamForm"
              >提交</Button
            >
          </div>
        </Modal>
      </div>

      <div>
        <Modal
          :title="modalTitle"
          v-model="dialogParamsGroupVisible"
          :mask-closable="false"
        >
          <div class="dialogCenter">
            <Form
              @submit.native.prevent
              @keydown.enter.native="submitParamGroupForm"
              ref="paramGroupForm"
              :model="paramGroupForm"
              :label-width="100"
              :rules="paramGroupValidate"
            >
              <FormItem label="参数名称：" prop="groupName">
                <Input v-model="paramGroupForm.groupName" class="wt-400" />
              </FormItem>
            </Form>
          </div>
          <div slot="footer">
            <Button type="text" @click="dialogParamsGroupVisible = false"
              >取消</Button
            >
            <Button
              type="primary"
              :loading="submitLoading"
              @click="submitParamGroupForm"
              >提交</Button
            >
          </div>
        </Modal>
      </div>
      <!-- 删除弹层 -->
      <OperateDialog
        :visible="delectVisible"
        :text="goodsText"
        @handleSubmit="handleDeleteParam"
        @handleClose="handleClose"
      ></OperateDialog>
      <!-- end -->
    </div>
  </div>
</template>
<script>
import {
  getCategoryParamsListData,
  insertGoodsParams,
  updateGoodsParams,
  deleteParams,
  insertParamsGroup,
  updateParamsGroup,
  deleteParamsGroup,
} from "@/api/goods";

import { regular } from "@/utils";
// 删除弹窗
import OperateDialog from "@/components/OperateDialog/index.vue";
export default {
  name: "categoryParams",
  components: {
    OperateDialog,
  },
  data() {
    return {
      submitLoading: false,
      /** 分类ID */
      categoryId: this.$route.query.id,
      /** 参数组 */
      paramsGroup: [],
      /** 添加或编辑标识 */
      modalType: 0,
      /** 添加或编辑标题 */
      modalTitle: "",
      /** 参数添加或编辑弹出框 */
      dialogParamsVisible: false,
      /** 参数组添加或编辑弹出框 */
      dialogParamsGroupVisible: false,
      //参数表单
      paramForm: {
        sort: 1,
      },
      /** 参数值 **/
      ops: {
        options: [],
      },
      // 参数表单
      paramGroupForm: {},
      /** 添加、编辑参数 规格 */
      formValidate: {
        paramName: [regular.REQUIRED, regular.VARCHAR5],
        options: [regular.REQUIRED, regular.VARCHAR255],
        sort: [regular.REQUIRED, regular.INTEGER],
      },
      /** 参数组*/
      paramGroupValidate: {
        groupName: [regular.REQUIRED, regular.VARCHAR5],
      },
      delectVisible: false,
      goodsId: "",
      goodsText: "",
    };
  },
  filters: {
    paramTypeFilter(val) {
      return val === 1 ? "输入项" : "选择项";
    },
  },

  methods: {
    // 初始化数据
    init() {
      this.getDataList();
    },
    //弹出添加参数框
    handleAddParams(group) {
      this.paramForm = {
        paramName: "",
        paramType: 1,
        options: "",
        required: false,
        isIndex: false,
        sort: 0,
        groupId: group.groupId,
        categoryId: this.categoryId,
        groupType: null,
      };
      this.modalTitle = "添加参数";
      this.modalType = 0;
      this.dialogParamsVisible = true;
    },
    //弹出修改参数框
    handleEditParams(group, param) {
      console.log(group, param);
      this.paramForm = {
        paramName: param.paramName,
        options: param.options.split(","),
        required: param.required == 1 ? true : false,
        isIndex: param.isIndex == 1 ? true : false,
        groupId: param.groupId || "",
        categoryId: param.categoryId || "",
        sort: param.sort || 1,
        id: param.id,
      };
      this.ops.options = this.paramForm.options;
      this.modalType = 1;
      this.modalTitle = "修改参数";
      this.dialogParamsVisible = true;
    },
    //弹出修改参数组框
    handleEditParamsGroup(group) {
      this.paramGroupForm = {
        groupName: group.groupName,
        categoryId: this.categoryId,
        id: group.groupId,
      };
      this.modalType = 1;
      this.modalTitle = "修改参数组";
      this.dialogParamsGroupVisible = true;
    },
    // 添加参数
    handleAddParamsGroup() {
      this.paramGroupForm = {};
      this.ops = {};
      (this.paramGroupForm.categoryId = this.categoryId), (this.modalType = 0);

      this.modalTitle = "添加参数组";
      this.dialogParamsGroupVisible = true;
    },
    //保存参数组
    submitParamGroupForm() {
      this.$refs.paramGroupForm.validate((valid) => {
        if (valid) {
          if (this.modalType === 0) {
            insertParamsGroup(this.paramGroupForm).then((res) => {
              this.submitLoading = false;
              if (res.success) {
                this.$Message.success("参数组修改成功");
                this.getDataList();
                this.dialogParamsVisible = false;
              }
            });
          } else {
            console.warn(this.paramGroupForm);
            updateParamsGroup(this.paramGroupForm).then((res) => {
              this.submitLoading = false;
              if (res.success) {
                this.$Message.success("参数组修改成功");
                this.getDataList();
                this.dialogParamsVisible = false;
              }
            });
          }
          this.dialogParamsGroupVisible = false;
        }
      });
    },
    //保存参数
    submitParamForm() {
      this.$refs.paramForm.validate((valid) => {
        if (valid) {
          this.submitLoading = true;
          let data = JSON.parse(JSON.stringify(this.paramForm));
          data.isIndex = Number(data.isIndex);
          data.required = Number(data.required);
          if (this.modalType === 0) {
            insertGoodsParams(data).then((res) => {
              this.submitLoading = false;
              if (res.success) {
                this.$Message.success("参数添加成功");
                this.getDataList();
                this.dialogParamsVisible = false;
              }
            });
          } else {
            console.warn(data.isIndex);
            data.isIndex = Number(data.isIndex);
            data.required = Number(data.required);
            updateGoodsParams(data).then((res) => {
              this.submitLoading = false;
              if (res.success) {
                this.$Message.success("参数修改成功");
                this.getDataList();
                this.dialogParamsVisible = false;
              }
            });
          }
        }
      });
    },
    // 获取分类列表
    getDataList() {
      getCategoryParamsListData(this.categoryId).then((res) => {
        if (res.success) {
          this.paramsGroup = res.result;
        }
      });
    },
    handleOpen(item, param) {
      if (param === undefined) {
        this.goodsId = item.groupId;
        this.goodsText = item.groupName;
        this.groupType = 0;
      } else {
        this.goodsId = param.id;
        this.goodsText = param.paramName;
        this.groupType = 1;
      }

      
      this.delectVisible = true;
    },
    handleClose() {
      this.delectVisible = false;
    },
    //删除参数方法
    handleDeleteParam() {
      // 删除
      if (this.groupType === 0) {
        deleteParamsGroup(this.goodsId).then((res) => {
          this.$Modal.remove();
          if (res.success) {
            this.$Message.success("删除参数成功");
            this.handleClose()
            this.getDataList();
            
          }
        });
      } else {
        deleteParams(this.goodsId).then((res) => {
          this.$Modal.remove();
          if (res.success) {
            this.$Message.success("删除参数成功");
            this.handleClose()
            this.getDataList();
          }
        });
      }
    },
    //删除参数组方法
    handleDeleteParamGroup(group) {
      this.$Modal.confirm({
        title: "确认删除",
        // 记得确认修改此处
        content: "您确认要删除 " + group.groupName + " ?",
        loading: true,
        onOk: () => {
          // 删除
        },
      });
    },
  },
  mounted() {
    this.init();
  },
};
</script>
<style lang="scss">
.row {
  overflow: hidden;
  margin: 20px 0;
}

.params {
  align-items: center;
  display: flex;
  padding: 8px 3px;
  font-size: 14px;
  justify-content: space-between;
}

.ivu-card-head {
  background-color: #f5f7fa;
}

.ivu-btn {
  font-size: 13px;
}

.paramsGroup {
  flex-wrap: wrap;
  display: flex;
  margin-left: -20px;
  .ivu-card-body {
    padding: 10px;
  }
  .ivu-card {
    border: 1px solid var(--color-border);
    width: calc(33.3% - 20px);
    margin-left: 20px;
    margin-bottom: 20px;
  }
  .footBtn{
    padding: 20px;
  }
}
</style>
