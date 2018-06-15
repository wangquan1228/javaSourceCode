package com.wq.mapper;

 

import com.wq.bean.Department;
 

public interface DepartmentMapper {
    /**
     * 根据部门id查询部门
     * @param deptId
     * @return
     */
    public Department getDepartmentByDeptId(Integer deptId);
    
    /**
     * 根据部门id查询部门
     * @param deptId
     * @return
     */
    public Department getDepartmentByDeptId1(Integer deptId);
    
   
}
