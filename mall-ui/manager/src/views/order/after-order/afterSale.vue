<template>
  <div class="contentBox">
    <div class="boxBg boxPad">
      <Tabs value="RETURN_MONEY" @on-click="handleClickType">
        <TabPane
          v-for="(item, index) in baseStatus"
          :key="index"
          :label="item.title"
          :name="item.value"
        ></TabPane>
      </Tabs>
      <div class="export">
        <Button @click="add" type="primary">添加</Button>
        <Button @click="getDataList" class="ml_20" icon="md-refresh">刷新</Button>
      </div>
      <div class="tableBox">
        <Table
          :loading="loading"
          border
          :columns="columns"
          :data="data"
          ref="table"
        ></Table>
        <Row type="flex" justify="end" class="mt_20">
          <Page
            :current="searchForm.pageNumber"
            :total="total"
            :page-size="searchForm.pageSize"
            @on-change="changePage"
            @on-page-size-change="changePageSize"
            :page-size-opts="[10, 20, 50]"
            show-sizer
          ></Page>
        </Row>
      </div>
      <Modal :title="modalTitle" v-model="modalVisible" :mask-closable="false">
        <Form ref="form" :model="form" :label-width="88" :rules="formValidate">
          <FormItem label="售后原因：" prop="reason">
            <Input
              v-model="form.reason"
              maxlength="20"
              clearable
              style="width: 100%"
            />
          </FormItem>
        </Form>
        <div slot="footer">
          <Button type="text" @click="modalVisible = false">取消</Button>
          <Button type="primary" :loading="submitLoading" @click="handleSubmit"
            >提交
          </Button>
        </div>
      </Modal>
    </div>
    <!-- 删除弹层 -->
    <OperateDialog
      :visible="delectVisible"
      :text="orderText"
      @handleSubmit="remove"
      @handleClose="handleClose"
    ></OperateDialog>
    <!-- 报警提示弹层 -->
  </div>
</template>
<script>
import * as API_Order from "@/api/order";
// 删除弹窗
import OperateDialog from "@/components/OperateDialog/index.vue";
export default {
  components: {
    OperateDialog,
  },
  data() {
    return {
      modalVisible: false, //添加售后原因弹出框
      modalTitle: "", //添加售后原因弹出框标题
      loading: true, // 表单加载状态
      submitLoading: false, // 添加或编辑提交状态
      form: {
        reason: "",
      }, //添加编辑表单
      formValidate: {
        reason: [
          {
            required: true,
            message: "请输入售后原因",
            trigger: "blur",
          },
        ],
      },
      searchForm: {
        // 搜索框初始化对象
        pageNumber: 1, // 当前页数
        pageSize: 10, // 页面大小
        sort: "createTime", // 默认排序字段
        order: "desc", // 默认排序方式
        serviceType: "RETURN_MONEY",
      },
      baseStatus: [
        { title: "退款", value: "RETURN_MONEY" },
        { title: "取消", value: "CANCEL" },
        { title: "退货", value: "RETURN_GOODS" },
        { title: "投诉", value: "COMPLAIN" },
      ],
      columns: [
        {
          title: "创建人",
          key: "createBy",
          minWidth: 120,
        },
        {
          title: "原因",
          key: "reason",
          minWidth: 400,
        },
        {
          title: "时间",
          key: "createTime",
          minWidth: 100,
        },
        {
          title: "操作",
          key: "action",
          align: "center",
          width: 125,
          render: (h, params) => {
            return h("div", [
              h(
                "span",
                {
                  class: "fontCol",
                  on: {
                    click: () => {
                      this.edit(params.row);
                    },
                  },
                },
                "编辑"
              ),
              h(
                "span",
                {
                  class: "fontCol",
                  on: {
                    click: () => {
                      this.handleOpen(params.row);
                    },
                  },
                },
                "删除"
              ),
            ]);
          },
        },
      ],
      data: [], // 表单数据
      total: 0, //条数
      delectVisible:false,
      orderId:'',
      orderText:''
    };
  },

  methods: {
    // 分页 修改页码
    changePage(v) {
      this.searchForm.pageNumber = v;
      this.getDataList();
      this.clearSelectAll();
    },
    // 分页 修改页数
    changePageSize(v) {
      this.searchForm.pageNumber = 1;
      this.searchForm.pageSize = v;
      this.getDataList();
    },
    //切换tab
    handleClickType(v) {
      this.searchForm.pageNumber = 1; // 当前页数
      this.searchForm.pageSize = 10; // 页面大小
      //退款
      if (v == "RETURN_MONEY") {
        this.searchForm.serviceType = "RETURN_MONEY";
      }
      //退货
      if (v == "RETURN_GOODS") {
        this.searchForm.serviceType = "RETURN_GOODS";
      }
      //取消
      if (v == "CANCEL") {
        this.searchForm.serviceType = "CANCEL";
      }
      //取消
      if (v == "COMPLAIN") {
        this.searchForm.serviceType = "COMPLAIN";
      }
      this.getDataList();
    },
    //获取售后原因数据
    getDataList() {
      this.loading = true;
      API_Order.getAfterSaleReasonPage(this.searchForm).then((res) => {
        this.loading = false;
        if (res.success) {
          this.data = res.result.records;
          this.total = res.result.total;
        }
      });
      this.loading = false;
    },
    //添加售后原因
    add() {
      this.form.reason = "";
      this.modalVisible = true;
      this.modalTitle = "添加售后原因";
    },
    //修改售后原因
    edit(v) {
      this.form.reason = v.reason;
      this.form.id = v.id;

      this.modalVisible = true;
      this.modalTitle = "修改售后原因";
    },
    //提交表单
    handleSubmit() {
      this.form.serviceType = this.searchForm.serviceType;
      this.$refs.form.validate((valid) => {
        if (valid) {
          this.submitLoading = true;
          if (this.modalTitle == "添加售后原因") {
            // 添加
            delete this.form.id;
            API_Order.addAfterSaleReason(this.form).then((res) => {
              this.submitLoading = false;
              if (res.success) {
                this.$Message.success("添加成功");
                this.getDataList();
                this.modalVisible = false;
              }
            });
          } else {
            // 编辑
            API_Order.editAfterSaleReason(this.form.id, this.form).then(
              (res) => {
                this.submitLoading = false;
                if (res.success) {
                  this.$Message.success("修改成功");
                  this.getDataList();
                  this.modalVisible = false;
                }
              }
            );
          }
        }
      });
    },
    handleOpen(item) {
      this.orderId = item.id;
      this.orderText = item.reason
      this.delectVisible = true;
    },
    handleClose() {
      this.delectVisible = false;
    },
    //删除售后原因
    remove() {
      API_Order.delAfterSaleReason(this.orderId).then((res) => {
            this.$Modal.remove();
            if (res.success) {
              this.$Message.success("售后原因已删除");
              this.getDataList();
            }
          });
    },
  },
  mounted() {
    this.getDataList();
  },
};
</script>
