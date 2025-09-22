<script setup>
import { ref, watch, onMounted } from "vue";
import { queryPageApi, getEmpList, add, getById,update,delById } from "@/api/clazz";
import { ElMessage ,ElMessageBox } from "element-plus";

//删除班级
const deleteById = (id) => {
  //弹出确认框
  ElMessageBox.confirm('您确认删除该班级吗?','提示',
    { confirmButtonText: '确认',cancelButtonText: '取消',type: 'warning'}
  ).then(async () => { //确认
    const result = await delById(id);
    if(result.code){
      ElMessage.success('删除成功');
      search();
    }else{
      ElMessage.error(result.msg);
    }
  }).catch(() => { //取消
    ElMessage.info('您已取消删除');
  })
}
// 核心：序号计算方法
const indexMethod = (index) => {
  return (currentPage.value - 1) * pageSize.value + index + 1;
};
//修改
const edit = async (id) => {
  const result = await getById(id);
  if (result.code) {
    dialogVisible.value = true;
    dialogTitle.value = "修改员工";
    clazz.value = result.data;

    if (clazzFormRef.value) {
      clazzFormRef.value.resetFields();
    }
  }
};

const headTeachers = ref([]);
//保存班级
//保存员工信息
const save = async () => {
  clazzFormRef.value.validate(async (valid) => {
    if (!valid) {
      return;
    }
    let result;
    if (clazz.value.id) {
      //修改
      result = await update(clazz.value);
      if (result.code) {
        ElMessage.success("修改班级成功");
        dialogVisible.value = false;
        search();
      } else {
        ElMessage.error(result.msg);
      }
    } else {
      //新增
      result = await add(clazz.value);
      if (result.code) {
        ElMessage.success("新增班级成功");
        dialogVisible.value = false;
        search();
      } else {
        ElMessage.error(result.msg);
      }
    }
  });
};

const fetchHeadTeachers = async () => {
  try {
    const result = await getEmpList();
    headTeachers.value = result.data;
    if (result.code === 1) {
      // 转换为需要的格式
      headTeachers.value = result.data.map((teacher) => ({
        name: teacher.name,
        value: teacher.id,
      }));
    } else {
      console.error("获取数据失败:", result.msg);
      return [];
    }
  } catch (error) {
    console.error("请求失败:", error);
    return [];
  }
};

const searchClazz = ref({
  name: "",
  date: [],
  begin: "",
  end: "",
});

//侦听searchClazz中的date属性
watch(
  () => searchClazz.value.date,
  (newValue, oldValue) => {
    if (newValue.length == 2) {
      searchClazz.value.begin = newValue[0];
      searchClazz.value.end = newValue[1];
    } else {
      searchClazz.value.begin = "";
      searchClazz.value.end = "";
    }
  }
);

onMounted(() => {
  search();
  fetchHeadTeachers();
});

//查询员工
const search = async () => {
  console.log("Search:", searchClazz.value);
  const result = await queryPageApi(
    searchClazz.value.name,
    searchClazz.value.begin,
    searchClazz.value.end,
    currentPage.value,
    pageSize.value
  );
  if (result.code) {
    clazzList.value = result.data.rows;
    total.value = result.data.total;
  }
};

const clear = () => {
  // 清空表单
  searchClazz.value = {
    name: "",
    date: [],
    begin: "",
    end: "",
  };
  search();
};

// 示例数据
const clazzList = ref([]);

// 分页配置
const currentPage = ref(1);
const pageSize = ref(10);
const total = ref(0);

// 分页处理
const handleSizeChange = (val) => {
  search();
};
const handleCurrentChange = (val) => {
  search();
};

//新增班级
const addClazz = () => {
  dialogVisible.value = true;
  dialogTitle.value = "新增班级";
  clazz.value = {
    name: "",
    room: "",
    beginDate: "",
    endDate: "",
    masterId: "",
    subject: "",
  };
  if (clazzFormRef.value) {
    clazzFormRef.value.resetFields();
  }
};

//新增/修改表单
const clazzFormRef = ref(null);

const clazz = ref({
  name: "",
  room: "",
  beginDate: "",
  endDate: "",
  masterId: "",
  subject: "",
});

const rules = {
  name: [{ required: true, message: "班级名称不能为空", trigger: "blur" }],
  beginDate: [{ required: true, message: "请选择开课时间", trigger: "change" }],
  endDate: [{ required: true, message: "请选择结课时间", trigger: "change" }],
  subject: [{ required: true, message: "请选择学科", trigger: "change" }],
};

// 控制弹窗
const dialogVisible = ref(false);
const dialogTitle = ref("新增班级");
</script>

<template>
  <h1>班级管理</h1>
  <br />
  <el-form :inline="true" :model="searchEmp">
    <el-form-item label="班级名称">
      <el-input
        v-model="searchClazz.name"
        placeholder="请输入班级名称"
      ></el-input>
    </el-form-item>

    <el-form-item label="结课时间">
      <el-date-picker
        v-model="searchClazz.date"
        type="daterange"
        range-separator="至"
        start-placeholder="开始日期"
        end-placeholder="结束日期"
        value-format="YYYY-MM-DD"
      ></el-date-picker>
    </el-form-item>

    <el-form-item>
      <el-button type="primary" @click="search">查询</el-button>
      <el-button @click="clear">清空</el-button>
    </el-form-item>
  </el-form>

  <el-button type="primary" @click="addClazz"> + 新增班级</el-button>
  <br /><br />

  <!-- 表格 -->
  <el-table :data="clazzList" border style="width: 100%">
    <el-table-column type="index" label="序号" width="100" align="center" :index="indexMethod"/>
    <el-table-column
      prop="name"
      label="班级名称"
      width="120"
      align="center"
    ></el-table-column>
    <el-table-column label="班级教室" width="100" prop="room" align="center">
    </el-table-column>
    <el-table-column
      label="班主任"
      width="100"
      align="center"
      prop="masterName"
    >
    </el-table-column>

    <el-table-column
      prop="beginDate"
      label="开课时间"
      width="170"
      align="center"
    ></el-table-column>
    <el-table-column
      prop="endDate"
      label="结课时间"
      width="170"
      align="center"
    ></el-table-column>

    <el-table-column label="状态" width="120" align="center" prop="status">
    </el-table-column>

    <el-table-column
      prop="updateTime"
      label="最后操作时间"
      width="210"
      align="center"
    ></el-table-column>
    <el-table-column label="操作" fixed="right" align="center">
      <template #default="scope">
        <el-button size="small" type="primary" @click="edit(scope.row.id)"
          >编辑</el-button
        >
        <el-button size="small" type="danger" @click="deleteById(scope.row.id)">删除</el-button>
      </template>
    </el-table-column>
  </el-table>

  <br />

  <!-- 分页 -->
  <el-pagination
    v-model:current-page="currentPage"
    v-model:page-size="pageSize"
    :page-sizes="[5, 10, 20, 30, 50, 75, 100]"
    :background="background"
    layout="total, sizes, prev, pager, next, jumper"
    :total="total"
    @size-change="handleSizeChange"
    @current-change="handleCurrentChange"
  ></el-pagination>

  <!-- 新增/修改员工的对话框 -->
  <el-dialog v-model="dialogVisible" :title="dialogTitle">
    <el-form
      ref="clazzFormRef"
      :rules="rules"
      :model="clazz"
      label-width="80px"
    >
      <!-- 基本信息 -->
      <!-- 第一行 -->
      <el-row :gutter="20">
        <el-col :span="24">
          <el-form-item label="班级名称" style="width: 80%" prop="name">
            <el-input
              v-model="clazz.name"
              placeholder="请输入班级名称，如：西安黑马JavaEE就业100期"
            ></el-input>
          </el-form-item>
        </el-col>
      </el-row>

      <!-- 第二行 -->
      <el-row :gutter="20">
        <el-col :span="24">
          <el-form-item label="班级教室" style="width: 80%">
            <el-input
              v-model="clazz.room"
              placeholder="请填写班级教室"
            ></el-input>
          </el-form-item>
        </el-col>
      </el-row>

      <!-- 第三行 -->
      <el-row :gutter="20">
        <el-col :span="24">
          <el-form-item label="开课时间" style="width: 80%" prop="beginDate">
            <el-date-picker
              v-model="clazz.beginDate"
              type="date"
              style="width: 100%"
              placeholder="选择日期"
              format="YYYY-MM-DD"
              value-format="YYYY-MM-DD"
            >
            </el-date-picker>
          </el-form-item>
        </el-col>
      </el-row>

      <!-- 第四行 -->
      <el-row :gutter="20">
        <el-col :span="24">
          <el-form-item label="结课时间" style="width: 80%" prop="endDate">
            <el-date-picker
              v-model="clazz.endDate"
              type="date"
              style="width: 100%"
              placeholder="选择日期"
              format="YYYY-MM-DD"
              value-format="YYYY-MM-DD"
            >
            </el-date-picker>
          </el-form-item>
        </el-col>
      </el-row>

      <!-- 第五行 -->
      <el-row :gutter="20">
        <el-col :span="24">
          <el-form-item label="班主任" style="width: 80%">
            <el-select
              v-model="clazz.masterId"
              placeholder="请选择"
              style="width: 100%"
            >
              <el-option
                v-for="teacher in headTeachers"
                :key="teacher.value"
                :label="teacher.name"
                :value="teacher.value"
              >
              </el-option>
            </el-select>
          </el-form-item>
        </el-col>
      </el-row>

      <!-- 第六行 -->
      <el-row :gutter="20">
        <el-col :span="24">
          <el-form-item label="学科" prop="subject">
            <el-select
              v-model="clazz.subject"
              placeholder="请选择"
              style="width: 78%"
            >
              <el-option label="java" :value="1"></el-option>
              <el-option label="前端" :value="2"></el-option>
              <el-option label="大数据" :value="3"></el-option>
              <el-option label="Python" :value="4"></el-option>
              <el-option label="Go" :value="5"></el-option>
              <el-option label="嵌入式" :value="6"></el-option>
            </el-select>
          </el-form-item>
        </el-col>
      </el-row>
    </el-form>
    <!-- 底部按钮 -->
    <template #footer>
      <span
        class="dialog-footer"
        style="display: flex; justify-content: center"
      >
        <el-button type="primary" @click="save">保存</el-button>
        <el-button @click="dialogVisible = false">取消</el-button>
      </span>
    </template>
  </el-dialog>
</template>

<style scoped>
.avatar {
  height: 40px;
}
.avatar-uploader .avatar {
  width: 78px;
  height: 78px;
  display: block;
}
.avatar-uploader .el-upload {
  border: 1px dashed var(--el-border-color);
  border-radius: 6px;
  cursor: pointer;
  position: relative;
  overflow: hidden;
  transition: var(--el-transition-duration-fast);
}

.avatar-uploader .el-upload:hover {
  border-color: var(--el-color-primary);
}

.el-icon.avatar-uploader-icon {
  font-size: 28px;
  color: #8c939d;
  width: 78px;
  height: 78px;
  text-align: center;
  /* 添加灰色的虚线边框 */
  border: 1px dashed var(--el-border-color);
}
</style>
