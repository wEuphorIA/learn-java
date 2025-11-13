<template>
  <div>
    <Modal v-model="visible" title="提示" class="operationDialog" @on-cancel="handleClose">
      确认禁用 {{text}}？
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
    visible:{
      type:Boolean,
      default:false
    },
    text: {
      type: String,
      default: "",
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
