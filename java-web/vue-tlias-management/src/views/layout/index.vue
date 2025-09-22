<script setup>
// 无需额外导入，因为我们只是使用了 Element Plus 和 Vue Router 的基本功能
import {ref, onMounted,reactive} from 'vue'
import { ElMessage, ElMessageBox } from 'element-plus';
import router from '@/router'

const loginName = ref('')
//定义钩子函数, 获取登录用户名
onMounted(() => {
  //获取登录用户名
  let loginUser = JSON.parse(localStorage.getItem('loginUser'))
  if (loginUser) {
    loginName.value = loginUser.name
  }
})

const logout = () => {
  //弹出确认框, 如果确认, 则退出登录, 跳转到登录页面
  ElMessageBox.confirm('确认退出登录吗?', '提示', {
    confirmButtonText: '确定',
    cancelButtonText: '取消',
    type: 'warning'
  }).then(() => {//确认, 则清空登录信息
    ElMessage.success('退出登录成功')
    localStorage.removeItem('loginUser')
    router.push('/login')//跳转到登录页面
  })
}


// 弹框显示状态
const dialogVisible = ref(false)

// 密码显示/隐藏状态
const showCurrentPassword = ref(false)
const showNewPassword = ref(false)
const showConfirmPassword = ref(false)

// 密码强度相关
const passwordStrength = ref('')
const strengthText = ref('')
const successMessage = ref('')

// 表单数据
const passwordForm = reactive({
  currentPassword: '',
  newPassword: '',
  confirmPassword: ''
})

// 错误信息
const errors = reactive({
  currentPassword: '',
  newPassword: '',
  confirmPassword: ''
})

// 打开弹框
const openDialog = () => {
  resetForm()
  dialogVisible.value = true
}

// 关闭弹框
const closeDialog = () => {
  dialogVisible.value = false
}

// 弹框关闭前的处理
const handleClose = (done) => {
  ElMessageBox.confirm('确定要关闭吗？未保存的更改将会丢失', '提示', {
    confirmButtonText: '确定',
    cancelButtonText: '取消',
    type: 'warning'
  }).then(() => {
    done()
  }).catch(() => {
    // 取消关闭
  })
}

// 验证新密码
const validateNewPassword = () => {
  if (!passwordForm.newPassword) {
    errors.newPassword = '新密码不能为空'
    return false
  }
  
  // 密码强度验证
  const hasMinLength = passwordForm.newPassword.length >= 8
  const hasLetters = /[a-zA-Z]/.test(passwordForm.newPassword) // 不区分大小写的字母验证
  const hasNumbers = /\d/.test(passwordForm.newPassword)
  
  if (!hasMinLength || !hasLetters || !hasNumbers) {
    errors.newPassword = '密码必须包含字母、数字且长度至少8位'
    return false
  }
  
  errors.newPassword = ''
  return true
}

// 检查密码强度
const checkPasswordStrength = () => {
  if (!passwordForm.newPassword) {
    passwordStrength.value = ''
    strengthText.value = ''
    return
  }
  
  // 简单的密码强度检测逻辑
  let strength = 0
  
  // 长度检查
  if (passwordForm.newPassword.length >= 8) strength++
  
  // 包含字母（不区分大小写）
  if (/[a-zA-Z]/.test(passwordForm.newPassword)) strength++
  
  // 包含数字
  if (/\d/.test(passwordForm.newPassword)) strength++
  
  // 根据分数设置强度
  if (strength < 2) {
    passwordStrength.value = 'weak'
    strengthText.value = '弱'
  } else if (strength < 3) {
    passwordStrength.value = 'medium'
    strengthText.value = '中'
  } else {
    passwordStrength.value = 'strong'
    strengthText.value = '强'
  }
}

// 重置表单
const resetForm = () => {
  passwordForm.currentPassword = ''
  passwordForm.newPassword = ''
  passwordForm.confirmPassword = ''
  errors.currentPassword = ''
  errors.newPassword = ''
  errors.confirmPassword = ''
  passwordStrength.value = ''
  strengthText.value = ''
  successMessage.value = ''
}
</script>

<template>
  <div class="common-layout">
    <el-container>
      <!-- Header 区域 -->
      <el-header class="header">
        <span class="title">Tlias智能学习辅助系统</span>
        <span class="right_tool">
          <a href="javascript:void(0)"  @click="openDialog">
            <el-icon><EditPen /></el-icon> 修改密码 &nbsp;&nbsp;&nbsp; |  &nbsp;&nbsp;&nbsp;
          </a>
          <a href="javascript:void(0)" @click="logout">
            <el-icon><SwitchButton /></el-icon> 退出登录 【{{ loginName }}】
          </a>
        </span>
      </el-header>
      
      <el-container>
        <!-- 左侧菜单 -->
        <el-aside width="200px" class="aside">

          <el-menu router>
            <!-- 首页菜单 -->
            <el-menu-item index="/index">
              <el-icon><Promotion /></el-icon> 首页
            </el-menu-item>
            
            <!-- 班级管理菜单 -->
            <el-sub-menu index="/manage">
              <template #title>
                <el-icon><Menu /></el-icon> 班级学员管理
              </template>
              <el-menu-item index="/clazz">
                <el-icon><HomeFilled /></el-icon>班级管理
              </el-menu-item>
              <el-menu-item index="/stu">
                <el-icon><UserFilled /></el-icon>学员管理
              </el-menu-item>
            </el-sub-menu>
            
            <!-- 系统信息管理 -->
            <el-sub-menu index="/system">
              <template #title>
                <el-icon><Tools /></el-icon>系统信息管理
              </template>
              <el-menu-item index="/dept">
                <el-icon><HelpFilled /></el-icon>部门管理
              </el-menu-item>
              <el-menu-item index="/emp">
                <el-icon><Avatar /></el-icon>员工管理
              </el-menu-item>
            </el-sub-menu>

            <!-- 数据统计管理 -->
            <el-sub-menu index="/report">
              <template #title>
                <el-icon><Histogram /></el-icon>数据统计管理
              </template>
              <el-menu-item index="/empReport">
                <el-icon><InfoFilled /></el-icon>员工信息统计
              </el-menu-item>
              <el-menu-item index="/stuReport">
                <el-icon><Share /></el-icon>学员信息统计
              </el-menu-item>
              <el-menu-item index="/log">
                <el-icon><Document /></el-icon>日志信息统计
              </el-menu-item>
            </el-sub-menu>
          </el-menu>
        </el-aside>
        
        <!-- 主展示区域 -->
        <el-main>
          <router-view></router-view>
        </el-main>
      </el-container>
    </el-container>
  </div>

  <el-dialog
    v-model="dialogVisible"
    title="修改密码"
    width="500px"
    :before-close="handleClose"
  >
    <el-form :model="passwordForm" label-width="100px">
      <el-form-item label="当前密码" :error="errors.currentPassword">
        <el-input
          v-model="passwordForm.currentPassword"
          :type="showCurrentPassword ? 'text' : 'password'"
          placeholder="请输入当前密码"
          @blur="validateCurrentPassword"
        >
          <template #append>
            <el-button @click="showCurrentPassword = !showCurrentPassword">
              <el-icon v-if="showCurrentPassword"><View /></el-icon>
              <el-icon v-else><Hide /></el-icon>
            </el-button>
          </template>
        </el-input>
      </el-form-item>
      
      <el-form-item label="新密码" :error="errors.newPassword">
        <el-input
          v-model="passwordForm.newPassword"
          :type="showNewPassword ? 'text' : 'password'"
          placeholder="请输入新密码"
          @input="checkPasswordStrength"
          @blur="validateNewPassword"
        >
          <template #append>
            <el-button @click="showNewPassword = !showNewPassword">
              <el-icon v-if="showNewPassword"><View /></el-icon>
              <el-icon v-else><Hide /></el-icon>
            </el-button>
          </template>
        </el-input>
        
        <div class="strength-indicator" :class="passwordStrength" v-if="passwordForm.newPassword">
          <div class="strength-bar">
            <div class="strength-fill"></div>
          </div>
          <span class="strength-text">密码强度: {{ strengthText }}</span>
        </div>
      </el-form-item>
      
      <el-form-item label="确认密码" :error="errors.confirmPassword">
        <el-input
          v-model="passwordForm.confirmPassword"
          :type="showConfirmPassword ? 'text' : 'password'"
          placeholder="请再次输入新密码"
          @blur="validateConfirmPassword"
        >
          <template #append>
            <el-button @click="showConfirmPassword = !showConfirmPassword">
              <el-icon v-if="showConfirmPassword"><View /></el-icon>
              <el-icon v-else><Hide /></el-icon>
            </el-button>
          </template>
        </el-input>
      </el-form-item>
      
      <div class="password-rules">
        <h4>密码设置规则</h4>
        <ul>
          <li>长度至少8个字符</li>
          <li>包含至少一个字母</li>
          <li>包含至少一个数字</li>
        </ul>
      </div>
      
      <div class="success-message" v-if="successMessage">
        <el-icon><SuccessFilled /></el-icon> {{ successMessage }}
      </div>
    </el-form>
    
    <template #footer>
      <span class="dialog-footer">
        <el-button @click="closeDialog">取消</el-button>
        <el-button type="primary" @click="submitForm">确认修改</el-button>
      </span>
    </template>
  </el-dialog>
</template>

<style scoped>
.header {
  background-image: linear-gradient(to right, #00547d, #007fa4, #00aaa0, #00d072, #a8eb12);
}

.title {
  color: white;
  font-size: 40px;
  font-family: 楷体;
  line-height: 60px;
  font-weight: bolder;
}

.right_tool{
  float: right;
  line-height: 60px;
}

a {
  color: white;
  text-decoration: none;
}

.aside {
  width: 220px;
  border-right: 1px solid #ccc;
  height: 730px;
}
</style>