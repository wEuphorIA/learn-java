import request from "../utils/request";

export const getEmpList = (name,gender,begin,end,page,pageSize) => 
  request.get(`/emps?name=${name}&gender=${gender}&begin=${begin}&end=${end}&page=${page}&pageSize=${pageSize}`)

//新增
export const addApi = (emp) =>  request.post('/emps', emp);

//根据id查询员工
export const getEmpById = (id) => request.get(`/emps/${id}`);


//修改员工
export const updateEmp = (emp) => request.put(`/emps`, emp);

//删除员工
export const delEmpById = (ids) => request.delete(`/emps?ids=${ids}`);

