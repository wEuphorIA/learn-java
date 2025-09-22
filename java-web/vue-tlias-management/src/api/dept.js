import request from "../utils/request";

export const getDeptList = () => request.get(`/depts`);

export const addDept = (data) => request.post(`/depts`, data);

export const getById = (id) => request.get(`/depts/${id}`);

export const updateDept = (data) => request.put(`/depts`, data);

export const deleteDept = (id) => request.delete(`/depts?id=${id}`);


