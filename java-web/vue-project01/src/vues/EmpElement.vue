<script setup>
import axios from "axios";
import { onMounted, ref } from "vue";

const EmpSearch = ref({
  name: "",
  gender: "",
  job: "",
});

const search = async() => {
  console.log("submit!");
  const result = await axios.get(`https://web-server.itheima.net/emps/list?name=${EmpSearch.value.name}&gender=${EmpSearch.value.gender}&job=${EmpSearch.value.job}`);
  EmpList.value = result.data.data;
};
const clear = () => {
  console.log("submit!");

  EmpSearch.value = {
    name: "",
    gender: "",
    job: "",
  };

  search();
};
const EmpList = ref([]);

onMounted(() => {
  search();
});
</script>

<template>

  <el-form :inline="true" :model="EmpSearch" class="demo-form-inline">
    <el-form-item label="姓名">
      <el-input v-model="EmpSearch.name" placeholder="请输入姓名" clearable />
    </el-form-item>
    <el-form-item label="性别">
      <el-select
        v-model="EmpSearch.gender"
        placeholder="请选择"
        clearable
      >
        <el-option label="男" value="1" />
        <el-option label="女" value="2" />
      </el-select>
    </el-form-item>
    <el-form-item label="职位">
      <el-select
        v-model="EmpSearch.job"
        placeholder="请选择" clearable>
        <el-option label="班主任" value="1" />
        <el-option label="教研主管" value="2" />
        <el-option label="其他" value="2" />
      </el-select>
    </el-form-item>
    <el-form-item>
      <el-button type="primary" @click="search">查询</el-button>
      <el-button type="primary" @click="clear">清空</el-button>
    </el-form-item>
  </el-form>

  <el-table :data="EmpList" border style="width: 100%">
    <el-table-column prop="id" label="ID" width="180" />
    <el-table-column prop="name" label="姓名" width="180" />
    <el-table-column prop="image" label="头像">
      <template #default="scope">
        <img :src="scope.row.image" width="50px" height="50px"/>
      </template>
    </el-table-column>
    <el-table-column prop="gender" label="性别">
      <template #default="scope">
        {{ scope.row.gender === 1 ? "男" : "女" }}
      </template>
    </el-table-column>
    <el-table-column prop="job" label="职位" >
      <template #default="scope">
        <span v-if="scope.row.job == 1">班主任</span>
        <span v-else-if="scope.row.job == 2">教研主任</span>
        <span v-else>其他</span>
      </template>
    </el-table-column>
    <el-table-column prop="entrydate" label="入职时间" />
    <el-table-column prop="updatetime" label="更新时间" />

  </el-table>
</template>

<style scoped></style>
