package com.wq.mapper;

import java.util.List;

import com.wq.bean.Employee;
import com.wq.dto.EmployeeDto;

public interface EmployeeMapper {
     //一对一
    public List<Employee> getEmpByEmployeeDto(EmployeeDto employeeDto);
    
    ///一对多
    public List<Employee> getEmpdepartment(Integer deptId);
    
   
}
