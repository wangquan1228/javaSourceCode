package com.wq.mapper;

import java.util.List;

import com.wq.bean.Department;
import com.wq.bean.Employee;

public interface DepartmentMapper {
    
    //一对一的方法
    public List<Department> getDepartmentTypeTwo();
   //一对多
    public List<Department> getDepartmentEmp();
    

}
