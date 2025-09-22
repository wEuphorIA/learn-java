import request from "../utils/request";

///api/report/studentCountData
export const getStudentCountData = () => 
  request.get("/report/studentCountData");


  //getStudentDegreeData
export const getStudentDegreeData = () =>
{
  return request.get("/report/studentDegreeData");
}