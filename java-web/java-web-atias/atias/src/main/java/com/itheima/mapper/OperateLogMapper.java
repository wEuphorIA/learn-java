package com.itheima.mapper;


import com.github.pagehelper.Page;
import com.itheima.domain.pojo.OperateLog;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface OperateLogMapper {

    //插入日志数据
    @Insert("insert into operate_log (operate_emp_id, operate_time, class_name, method_name, method_params, return_value, cost_time) " +
            "values (#{operateEmpId}, #{operateTime}, #{className}, #{methodName}, #{methodParams}, #{returnValue}, #{costTime});")
    public void insert(OperateLog log);

    @Select("select ol.*,e.name operateEmpName from operate_log ol,emp e where e.id = ol.operate_emp_id order by operate_time desc")
    Page<OperateLog> page(Integer page, Integer pageSize);
}
