<!--操作弹层-->
<template>
  <div class="deleteDialog baseDialog">
    <Modal
      v-model="visible"
      title="确认删除"
      class="operationDialog"
      @on-cancel="handleClose"
    >
      <div v-if="selectCount&&selectCount>0">您确认要删除所选的{{selectCount}}条数据？</div>
      <div v-else-if="groupType===1">是否删除该分组？</div>
      <div v-else>此操作将删除该{{ text }}，是否继续？</div>

      <!-- 此操作将永久删除这条信息，是否继续？ -->
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
    text:{
      type:String,
      default:''
    },
    selectCount:{
      type:Number,
      default:0
    },
    groupType:{
      type:Number,
      default:0
    }
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
