import request from '@/utils/request' // 假设已配置基础Axios实例

/**
 * 学员管理接口集合
 */
const studentApi = {
  /**
   * 1. 学员列表条件分页查询
   * @param {Object} params - 查询参数
   * @param {string} [params.name] - 学员姓名
   * @param {number} [params.degree] - 学历(1-6)
   * @param {number} [params.clazzId] - 班级ID
   * @param {number} params.page - 页码
   * @param {number} params.pageSize - 每页条数
   * @returns {Promise} - 响应数据
   */
  getStudentList: (params) => {
    return request({
      url: '/students',
      method: 'GET',
      params
    })
  },

  /**
   * 2. 删除学员（支持批量）
   * @param {Array<number>} ids - 学员ID数组
   * @returns {Promise} - 响应数据
   */
  deleteStudent: (ids) => {
    return request({
      url: `/students/${ids.join(',')}`,
      method: 'DELETE'
    })
  },

  /**
   * 3. 添加学员
   * @param {Object} data - 学员信息
   * @returns {Promise} - 响应数据
   */
  addStudent: (data) => {
    return request({
      url: '/students',
      method: 'POST',
      data
    })
  },

  /**
   * 4. 根据ID查询学员
   * @param {number} id - 学员ID
   * @returns {Promise} - 响应数据
   */
  getStudentById: (id) => {
    return request({
      url: `/students/${id}`,
      method: 'GET'
    })
  },

  /**
   * 5. 修改学员信息
   * @param {Object} data - 学员更新信息（含id）
   * @returns {Promise} - 响应数据
   */
  updateStudent: (data) => {
    return request({
      url: '/students',
      method: 'PUT',
      data
    })
  },

  /**
   * 6. 学员违纪处理
   * @param {number} id - 学员ID
   * @param {number} score - 扣除分数
   * @returns {Promise} - 响应数据
   */
  handleViolation: (id, score) => {
    return request({
      url: `/students/violation/${id}/${score}`,
      method: 'PUT'
    })
  },

  /**
   * 7. 获取班级列表（用于下拉选择）
   * @returns {Promise} - 班级列表数据
   * 注：假设班级接口路径为/clazzes，需根据实际后端接口调整
   */
  getClazzList: () => {
    return request({
      url: '/clazzes',
      method: 'GET'
    })
  }
}

export default studentApi