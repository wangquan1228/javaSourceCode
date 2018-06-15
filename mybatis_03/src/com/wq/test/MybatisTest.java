package com.wq.test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import com.wq.bean.Admin;
import com.wq.bean.Department;
import com.wq.bean.Employee;
import com.wq.dto.EmployeeDto;
import com.wq.mapper.AdminMapper;
import com.wq.mapper.DepartmentMapper;
import com.wq.mapper.EmployeeMapper;
import com.wq.util.MyBatisUtils;

public class MybatisTest {

    @Test
    public void getEmpByEmployeeDtoTest() {
        SqlSession session = MyBatisUtils.getSession();
        // 获取代理接口
        EmployeeMapper mapper = session.getMapper(EmployeeMapper.class);
        EmployeeDto employeeDto = new EmployeeDto();
        Employee employee = new Employee();
        employee.setEmpName("黄");
        // employee.setGender("男 ");
        List<Integer> ids = new ArrayList<>();
        ids.add(1001);
        ids.add(1002);
        ids.add(1003);
        employeeDto.setEmployee(employee);
        employeeDto.setIds(ids);
        // 使用方法
        List<Employee> lists = mapper.getEmpByEmployeeDto(employeeDto);

        for (Employee employee1 : lists) {
            System.out.println(employee1);
        }

    }

    @Test
    public void selectKeyTest() {
        SqlSession session = MyBatisUtils.getSession();
        // 获取代理接口
        AdminMapper mapper = session.getMapper(AdminMapper.class);
        Admin admin = new Admin();
        admin.setName("南阳理工学院");
        mapper.addAdmin(admin);
        session.commit();
        session.close();
    }
    //一对一department.dept_id=admin.dept_id
    @Test
    public void getAdminAllTest() {
        SqlSession session = MyBatisUtils.getSession();
        // 获取代理接口
        AdminMapper mapper = session.getMapper(AdminMapper.class);
        List<Admin> adminAll = mapper.getAdminAll();
        for (Admin admin : adminAll) {
            System.out.println(admin);
        }

    }
    //一对一
    @Test
    public void getAdminAllTwoTest() {
        SqlSession session = MyBatisUtils.getSession();
        // 获取代理接口
       DepartmentMapper mapper = session.getMapper(DepartmentMapper.class);
          List<Department> departmentTypeTwo = mapper.getDepartmentTypeTwo();
        for (Department department : departmentTypeTwo) {
            System.out.println(department);
        }

    }
    
    @Test 
    public void getDepartmentEmpTest() {
        SqlSession session=MyBatisUtils.getSession();
        DepartmentMapper mapper=session.getMapper(DepartmentMapper.class);
       List<Department> departmentEmp =mapper.getDepartmentEmp();
        for (Department department : departmentEmp) {
            System.out.println(department);
        }
    } 
    
    
    @Test
    public void getEmpdepartmentTest() {
        SqlSession session=MyBatisUtils.getSession();
        EmployeeMapper mapper = session.getMapper(EmployeeMapper.class);
        List<Employee> empdepartment = mapper.getEmpdepartment(1002);
        for (Employee employee : empdepartment) {
            System.out.println(employee);
        }
    }
}
