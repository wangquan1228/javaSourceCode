package com.wq.mapper;

import java.util.List;

import com.wq.bean.Employee;
import com.wq.dto.EmployeeDto;

public interface EmployeeMapper {
    /**
     * 根据id查询员工信息
     * @param empId
     * @return
     */
    public Employee getEmployeeByEmpId(Integer empId);
    
    /**
     * 根据部门Id查询员工
     * @param deptId
     * @return
     */
    public List<Employee> getEmployeeByDeptId(Integer deptId);
   
}
