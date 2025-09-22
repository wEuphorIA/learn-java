<script setup>
import { ref, onMounted } from "vue";
import { ElMessage,ElMessageBox  } from "element-plus";
import { getDeptList, addDept, getById, updateDept,deleteDept } from "@/api/dept";

// 声明列表展示数据
let deptList = ref([]);

// 动态加载数据 - 查询部门
const queryAll = async () => {
  const result = await getDeptList();
  deptList.value = result.data;
};

// 钩子函数
onMounted(() => {
  queryAll();
});

// 删除部门 - 根据ID删除部门
const handleDelete = (id) => {
  console.log(`Delete item with ID ${id}`);
  //删除部门时, 需要弹出一个确认框, 如果是确认, 则删除部门
  ElMessageBox.confirm('此操作将永久删除该部门, 是否继续?', '提示', {
    confirmButtonText: '确定',
    cancelButtonText: '取消',
    type: 'warning'
  }).then(async () => {
    // 删除部门
    const result = await deleteDept(id)
    if(result.code){
      ElMessage.success('删除成功')
      queryAll()
    }
  })
};

const formTitle = ref("");
//新增部门
const add = () => {
  formTitle.value = "新增部门";
  showDialog.value = true;
  deptForm.value = { name: "" };
};

// 新增部门对话框的状态
const showDialog = ref(false);
// 表单数据
const deptForm = ref({ name: "" });
// 表单验证规则
const formRules = ref({
  name: [
    { required: true, message: "请输入部门名称", trigger: "blur" },
    { min: 2, max: 10, message: "长度在 2 到 10 个字符", trigger: "blur" },
  ],
});

// 表单标签宽度
const formLabelWidth = ref("120px");
// 表单引用
const deptFormRef = ref(null);

// 重置表单
const resetForm = () => {
  deptFormRef.value.resetFields();
};

// 提交表单
const save = async () => {
  await deptFormRef.value.validate(async (valid) => {
    if (!valid) return;
   // 提交表单
   let result = null;
    if(deptForm.value.id){
      result = await updateDept(deptForm.value) // 修改
    }else {
      result = await addDept(deptForm.value) // 新增
    } 
    if (result.code) {
      ElMessage.success("操作成功");
      // 关闭对话框
      showDialog.value = false;
      // 重置表单
      resetForm();
      // 重新加载数据
      queryAll();
    } else {
      ElMessage.error(result.msg);
    }
  });
};

// 编辑部门 - 根据ID查询回显数据
const handleEdit = async (id) => {
  console.log(`Edit item with ID ${id}`);
  formTitle.value = "修改部门";
  showDialog.value = true;
  deptForm.value = { name: "" };

  const result = await getById(id);
  if (result.code) {
    deptForm.value = result.data;
  }
};
</script>

<template>
  <h1>部门管理</h1>

  <!-- 按钮靠页面右侧显示 -->
  <el-button type="primary" @click="add()" style="float: right">
    + 新增部门</el-button
  >
  <br /><br />

  <!-- 数据展示表格 -->
  <el-table :data="deptList" border style="width: 100%">
    <el-table-column type="index" label="序号" width="100" align="center" />
    <el-table-column prop="name" label="部门名称" width="300" align="center" />
    <el-table-column
      prop="updateTime"
      label="最后修改时间"
      width="300"
      align="center"
    />
    <el-table-column fixed="right" label="操作" align="center">
      <template #default="scope">
        <el-button size="small" @click="handleEdit(scope.row.id)"
          >修改</el-button
        >
        <el-button
          size="small"
          type="danger"
          @click="handleDelete(scope.row.id)"
          >删除</el-button
        >
      </template>
    </el-table-column>
  </el-table>

  <!-- 新增部门的对话框 -->
  <el-dialog
    v-model="showDialog"
    :title="formTitle"
    width="30%"
    @close="resetForm"
  >
    <el-form :model="deptForm" :rules="formRules" ref="deptFormRef">
      <el-form-item label="部门名称" prop="name" label-width="80px">
        <el-input v-model="deptForm.name" autocomplete="off"></el-input>
      </el-form-item>
    </el-form>

    <template #footer>
      <span class="dialog-footer">
        <el-button @click="showDialog = false">取消</el-button>
        <el-button type="primary" @click="save">确定</el-button>
      </span>
    </template>
  </el-dialog>
</template>

<style scoped></style>
