<template>
  <div class="student-management">
    <h2>学员管理</h2>

    <!-- 查询区域 -->
    <el-form :inline="true" :model="searchForm" class="search-form">
      <el-form-item label="姓名">
        <el-input
          v-model="searchForm.name"
          placeholder="请输入学员姓名"
        ></el-input>
      </el-form-item>
      <el-form-item label="最高学历">
        <el-select v-model="searchForm.education" placeholder="请选择">
          <el-option label="初中" value="初中"></el-option>
          <el-option label="高中" value="高中"></el-option>
          <el-option label="大专" value="大专"></el-option>
          <el-option label="本科" value="本科"></el-option>
          <el-option label="硕士" value="硕士"></el-option>
          <el-option label="博士" value="博士"></el-option>
        </el-select>
      </el-form-item>
      <el-form-item label="所属班级">
        <el-select
          v-model="searchForm.clazzId"
          placeholder="请选择"
          @change="handleClassChange"
        >
          <el-option
            v-for="clazz in clazzList"
            :key="clazz.id"
            :label="clazz.name"
            :value="clazz.id"
          ></el-option>
        </el-select>
      </el-form-item>
      <el-form-item>
        <el-button type="primary" @click="handleSearch">查询</el-button>
        <el-button @click="handleReset">清空</el-button>
      </el-form-item>
    </el-form>

    <!-- 操作按钮区域 -->
    <div class="operation-buttons">
      <el-button type="primary" icon="Plus" @click="handleAdd"
        >添加学员</el-button
      >
      <el-button
        type="danger"
        icon="Delete"
        @click="handleBatchDelete"
        :disabled="selectedRows.length === 0"
        >批量删除</el-button
      >
    </div>

    <!-- 学员表格区域 -->
    <el-table
      :data="tableData"
      border
      style="width: 100%"
      @selection-change="handleSelectionChange"
    >
      <el-table-column type="selection" width="55"></el-table-column>
      <el-table-column prop="name" label="姓名" width="70"></el-table-column>
      <el-table-column
        prop="no"
        label="学号"
        width="110"
      ></el-table-column>
      <el-table-column prop="clazzName" label="班级"></el-table-column>
      <el-table-column prop="gender" label="性别" width="55"></el-table-column>
      <el-table-column
        prop="phone"
        label="手机号"
        width="125"
      ></el-table-column>
      <el-table-column
        prop="degree"
        label="最高学历"
        width="85"
      ></el-table-column>
      <el-table-column
        prop="violationCount"
        label="违纪次数"
        width="85"
      ></el-table-column>
      <el-table-column
        prop="violationScore"
        label="违纪扣分"
        width="85"
      ></el-table-column>
      <el-table-column
        prop="updateTime"
        label="最后操作时间"
      ></el-table-column>
      <el-table-column label="操作">
        <template #default="scope">
          <el-button type="text" @click="handleEdit(scope.row)">编辑</el-button>
          <el-button type="text" @click="handleViolation(scope.row)"
            >违纪</el-button
          >
          <el-button type="text" @click="handleDelete(scope.row)"
            >删除</el-button
          >
        </template>
      </el-table-column>
    </el-table>

    <!-- 分页区域 -->
    <el-pagination
      @size-change="handleSizeChange"
      @current-change="handleCurrentChange"
      :current-page="currentPage"
      :page-sizes="[10, 20, 50, 100]"
      :page-size="pageSize"
      layout="total, sizes, prev, pager, next, jumper"
      :total="total"
      class="pagination"
    ></el-pagination>

    <!-- 统一的添加/编辑学员弹窗 -->
    <el-dialog :title="dialogTitle" v-model="formDialogVisible" width="60%">
      <el-form
        :model="formData"
        ref="formRef"
        :rules="formRules"
        label-width="120px"
      >
        <el-form-item label="姓名" prop="name">
          <el-input v-model="formData.name" placeholder="请输入姓名"></el-input>
        </el-form-item>
        <el-form-item label="学号" prop="studentNo">
          <el-input
            v-model="formData.studentNo"
            placeholder="请输入学号"
            :disabled="isEditMode"
          ></el-input>
        </el-form-item>
        <el-form-item label="性别" prop="gender">
          <el-select v-model="formData.gender" placeholder="请选择性别">
            <el-option label="男" value="男"></el-option>
            <el-option label="女" value="女"></el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="手机号" prop="phone">
          <el-input
            v-model="formData.phone"
            placeholder="请输入手机号"
          ></el-input>
        </el-form-item>
        <el-form-item label="身份证号" prop="idCard">
          <el-input
            v-model="formData.idCard"
            placeholder="请输入身份证号"
          ></el-input>
        </el-form-item>
        <el-form-item label="是否院校学院" prop="isCollegeStudent">
          <el-select v-model="formData.isCollegeStudent" placeholder="请选择">
            <el-option label="是" value="是"></el-option>
            <el-option label="否" value="否"></el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="联系地址">
          <el-input
            v-model="formData.address"
            placeholder="请输入联系地址"
          ></el-input>
        </el-form-item>
        <el-form-item label="最高学历">
          <el-select v-model="formData.education" placeholder="请选择（选填）">
            <el-option label="初中" value="初中"></el-option>
            <el-option label="高中" value="高中"></el-option>
            <el-option label="大专" value="大专"></el-option>
            <el-option label="本科" value="本科"></el-option>
            <el-option label="硕士" value="硕士"></el-option>
            <el-option label="博士" value="博士"></el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="毕业时间">
          <el-date-picker
            v-model="formData.graduationTime"
            type="date"
            placeholder="选择毕业时间（选填）"
            value-format="YYYY-MM-DD"
          ></el-date-picker>
        </el-form-item>
        <el-form-item label="所属班级">
          <el-select v-model="formData.clazzId" placeholder="请选择（选填）">
            <el-option
              v-for="clazz in clazzList"
              :key="clazz.id"
              :label="clazz.name"
              :value="clazz.id"
            ></el-option>
          </el-select>
        </el-form-item>
      </el-form>
      <template #footer>
        <span class="dialog-footer">
          <el-button @click="formDialogVisible = false">取消</el-button>
          <el-button type="primary" @click="handleFormSubmit">确定</el-button>
        </span>
      </template>
    </el-dialog>

    <!-- 违纪处理弹窗 -->
    <el-dialog title="违纪处理" v-model="violationDialogVisible" width="40%">
      <el-form
        :model="violationForm"
        ref="violationFormRef"
        :rules="violationRules"
        label-width="100px"
      >
        <el-form-item label="违纪扣分" prop="score">
          <el-input
            v-model.number="violationForm.score"
            placeholder="请输入违纪扣分"
          ></el-input>
        </el-form-item>
      </el-form>
      <template #footer>
        <span class="dialog-footer">
          <el-button @click="violationDialogVisible = false">取消</el-button>
          <el-button type="primary" @click="handleViolationSubmit"
            >确定</el-button
          >
        </span>
      </template>
    </el-dialog>
  </div>
</template>

<script setup>
import { ref, onMounted } from "vue";
import { ElMessage, ElMessageBox } from "element-plus";
import studentApi from "@/api/stu";

// 搜索表单数据
const searchForm = ref({
  name: "",
  education: "",
  clazzId: "",
});

// 表格数据
const tableData = ref([]);
const selectedRows = ref([]);
const clazzList = ref([]);

// 分页数据
const currentPage = ref(1);
const pageSize = ref(10);
const total = ref(0);

// 统一表单弹窗相关
const formDialogVisible = ref(false);
const dialogTitle = ref("添加学员");
const isEditMode = ref(false); // 标记当前是添加还是编辑模式
const formData = ref({
  id: "",
  name: "",
  no: "",
  gender: "",
  phone: "",
  degree: "",
  idCard: "",
  isCollege: "",
  address: "",
  graduationDate: "",
  violationCount: "",
  violationScore: "",
  clazzName: "",
  clazzId: "",
  updateTime: "",
});
const formRef = ref(null);
const formRules = ref({
  name: [
    { required: true, message: "请输入姓名", trigger: "blur" },
    { min: 2, max: 10, message: "姓名长度在2到10个字符之间", trigger: "blur" },
  ],
  studentNo: [
    { required: true, message: "请输入学号", trigger: "blur" },
    { len: 10, message: "学号长度固定为10位", trigger: "blur" },
  ],
  gender: [{ required: true, message: "请选择性别", trigger: "change" }],
  phone: [
    { required: true, message: "请输入手机号", trigger: "blur" },
    {
      pattern: /^1[3-9]\d{9}$/,
      message: "请输入正确的手机号格式",
      trigger: "blur",
    },
  ],
  idCard: [
    { required: true, message: "请输入身份证号", trigger: "blur" },
    {
      pattern: /(^\d{15}$)|(^\d{18}$)|(^\d{17}(\d|X|x)$)/,
      message: "请输入正确的身份证号格式",
      trigger: "blur",
    },
  ],
  isCollegeStudent: [
    { required: true, message: "请选择是否院校学院", trigger: "change" },
  ],
});

// 违纪处理弹窗相关
const violationDialogVisible = ref(false);
const violationForm = ref({
  score: "",
});
const violationFormRef = ref(null);
const violationRules = ref({
  score: [
    { required: true, message: "请输入违纪扣分", trigger: "blur" },
    { type: "number", message: "请输入数字", trigger: "blur" },
    { min: 1, message: "扣分值至少为1", trigger: "blur" },
  ],
});
let currentViolationId = ref("");

// 获取班级列表
const getClazzList = async () => {
  try {
    const res = await studentApi.getClazzList();
    clazzList.value = res.data;
  } catch (error) {
    ElMessage.error("获取班级列表失败");
  }
};

// 获取学员列表
const getStudentList = async () => {
  try {
    const params = {
      name: searchForm.value.name,
      degree: getDegreeCode(searchForm.value.education),
      clazzId: searchForm.value.clazzId,
      page: currentPage.value,
      pageSize: pageSize.value,
    };
    const res = await studentApi.getStudentList(params);
    tableData.value = res.data.rows;
    total.value = res.data.total;
  } catch (error) {
    ElMessage.error("获取学员列表失败");
  }
};

// 学历名称转编码
const getDegreeCode = (education) => {
  const degreeMap = {
    初中: 1,
    高中: 2,
    大专: 3,
    本科: 4,
    硕士: 5,
    博士: 6,
  };
  return degreeMap[education] || "";
};

// 初始化
onMounted(() => {
  getClazzList();
  getStudentList();
});

// 搜索和重置
const handleSearch = () => {
  currentPage.value = 1;
  getStudentList();
};

const handleReset = () => {
  searchForm.value = {
    name: "",
    education: "",
    clazzId: "",
  };
  currentPage.value = 1;
  getStudentList();
};

// 添加学员
const handleAdd = () => {
  isEditMode.value = false;
  dialogTitle.value = "添加学员";
  formData.value = {
    id: "",
    name: "",
    studentNo: "",
    gender: "",
    phone: "",
    idCard: "",
    isCollegeStudent: "",
    address: "",
    education: "",
    graduationTime: "",
    clazzId: "",
  };
  formDialogVisible.value = true;
  if (formRef.value) {
    formRef.value.resetFields();
  }
};

// 编辑学员
const handleEdit = async (row) => {
  try {
    isEditMode.value = true;
    dialogTitle.value = "编辑学员";
    const res = await studentApi.getStudentById(row.id);
    formData.value = { ...res.data };
    formDialogVisible.value = true;
  } catch (error) {
    ElMessage.error("获取学员详情失败");
  }
};

// 表单提交（添加或编辑）
const handleFormSubmit = async () => {
  try {
    await formRef.value.validate();

    if (isEditMode.value) {
      // 编辑模式
      await studentApi.updateStudent(formData.value);
      ElMessage.success("学员信息更新成功");
    } else {
      // 添加模式
      await studentApi.addStudent(formData.value);
      ElMessage.success("学员添加成功");
    }

    formDialogVisible.value = false;
    getStudentList();
  } catch (error) {
    if (error.name !== "Error") return; // 忽略校验失败的错误
    ElMessage.error(isEditMode.value ? "更新失败" : "添加失败");
  }
};

// 违纪处理
const handleViolation = (row) => {
  currentViolationId.value = row.id;
  violationForm.value = { score: "" };
  violationDialogVisible.value = true;
};

const handleViolationSubmit = async () => {
  try {
    await violationFormRef.value.validate();
    await studentApi.handleViolation(
      currentViolationId.value,
      violationForm.value.score
    );
    ElMessage.success("违纪处理成功");
    violationDialogVisible.value = false;
    getStudentList();
  } catch (error) {
    if (error.name !== "Error") return;
    ElMessage.error("违纪处理失败");
  }
};

// 删除功能
const handleDelete = async (row) => {
  try {
    await ElMessageBox.confirm("确定要删除该学员吗？", "提示", {
      confirmButtonText: "确定",
      cancelButtonText: "取消",
      type: "warning",
    });
    await studentApi.deleteStudent([row.id]);
    ElMessage.success("删除成功");
    getStudentList();
  } catch (error) {
    if (error === "cancel") return;
    ElMessage.error("删除失败");
  }
};

// 批量删除
const handleBatchDelete = async () => {
  if (selectedRows.value.length === 0) return;

  try {
    const ids = selectedRows.value.map((row) => row.id);
    await ElMessageBox.confirm(
      `确定要删除选中的${ids.length}名学员吗？`,
      "提示",
      {
        confirmButtonText: "确定",
        cancelButtonText: "取消",
        type: "warning",
      }
    );
    await studentApi.deleteStudent(ids);
    ElMessage.success("批量删除成功");
    selectedRows.value = [];
    getStudentList();
  } catch (error) {
    if (error === "cancel") return;
    ElMessage.error("批量删除失败");
  }
};

// 分页和选择相关方法
const handleSelectionChange = (rows) => {
  selectedRows.value = rows;
};

const handleSizeChange = (val) => {
  pageSize.value = val;
  currentPage.value = 1;
  getStudentList();
};

const handleCurrentChange = (val) => {
  currentPage.value = val;
  getStudentList();
};

const handleClassChange = () => {
  currentPage.value = 1;
};
</script>

<style scoped>
.student-management {
  padding: 20px;
  max-width: 1400px;
  margin: 0 auto;
}

.search-form {
  margin-bottom: 20px;
  padding: 15px;
  background-color: #f5f7fa;
  border-radius: 6px;
}

.operation-buttons {
  margin-bottom: 20px;
  display: flex;
  gap: 10px;
}

.pagination {
  margin-top: 20px;
  text-align: right;
}

h2 {
  color: #1f2329;
  margin-bottom: 25px;
  font-size: 20px;
  font-weight: 600;
}
</style>
