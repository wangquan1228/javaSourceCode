package com.wq.test;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import com.wq.bean.Department;
import com.wq.bean.Employee;
import com.wq.mapper.DepartmentMapper;
import com.wq.mapper.EmployeeMapper;
import com.wq.util.MyBatisUtils;

public class MybatisTest {
    @Test
    public void getDepartmentByDeptIdTest() {
        SqlSession session=MyBatisUtils.getSession();
        DepartmentMapper mapper = session.getMapper(DepartmentMapper.class);
        Department department = mapper.getDepartmentByDeptId(1002);
        System.out.println(department);
    }
    
    @Test
    public void getEmployeeByEmpIdTest() {
        SqlSession session=MyBatisUtils.getSession();
        EmployeeMapper mapper = session.getMapper(EmployeeMapper.class);
        Employee employee = mapper.getEmployeeByEmpId(45);
        System.out.println(employee);
    }
     
    @Test
    public void getEmployeeByDeptIdTest() {
        SqlSession session=MyBatisUtils.getSession();
        EmployeeMapper mapper = session.getMapper(EmployeeMapper.class);
        List<Employee>  employees = mapper.getEmployeeByDeptId(1002);
        for (Employee employee : employees) {
            System.out.println(employee);
        }
      
    }
    @Test
    public void cacheTest() {
        SqlSession session=MyBatisUtils.getSession();
        DepartmentMapper mapper = session.getMapper(DepartmentMapper.class);
        Department department = mapper.getDepartmentByDeptId(1002);
        System.out.println(department);
        session.close();
        SqlSession session1=MyBatisUtils.getSession();
        DepartmentMapper mapper1 = session1.getMapper(DepartmentMapper.class);
        Department department1 = mapper1.getDepartmentByDeptId(1002);
        System.out.println(department1);
        session1.close();
    }
}
