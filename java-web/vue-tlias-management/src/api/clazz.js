import request from "../utils/request";

export const queryPageApi = (name,begin,end,page,pageSize) => 
  request.get(`/clazzs?name=${name}&begin=${begin}&end=${end}&page=${page}&pageSize=${pageSize}`)

export const getEmpList = () => request.get(`/emps/list`);

//新增班级
export const add = (data) => request.post(`/clazzs`, data);

//根据id查询班级
export const getById = (id) => request.get(`/clazzs/${id}`);

//修改班级
export const update = (data) => request.put(`/clazzs`, data);

//根据id删除班级
export const delById = (id) => request.delete(`/clazzs/${id}`);