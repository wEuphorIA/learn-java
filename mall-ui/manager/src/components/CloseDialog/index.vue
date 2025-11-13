<!--操作弹层-->
<template>
  <div class="deleteDialog baseDialog">
    <Modal
      v-model="visible"
      :title="type === 'close' ? '确认关闭' : '确认开启'"
      class="operationDialog"
      @on-cancel="handleClose"
    >
      <div>
        您确认要{{ type === "close" ? "关闭" : "开启" }}店铺 {{ text }}？
      </div>
      <div slot="footer">
        <Button @click="handleClose">取消</Button>
        <Button type="primary" @click="handleSubmit">确定</Button>
      </div>
    </Modal>
  </div>
</template>
<script>
export default {
  props: {
    visible: {
      type: Boolean,
      default: false,
    },
    type: {
      type: String,
      default: "",
    },
    text: {
      type: String,
      default: "",
    },
    selectCount: {
      type: Number,
      default: 0,
    },
  },
  methods: {
    handleClose() {
      this.$emit("handleClose");
    },
    handleSubmit() {
      this.$emit("handleSubmit");
    },
  },
};
</script>
