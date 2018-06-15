package com.wq.bean;

import java.util.List;

public class Department {

    private Integer deptId;

    private String deptName;

 /*   private Admin admin;

    public Admin getAdmin() {
        return admin;
    }

    public void setAdmin(Admin admin) {
        this.admin = admin;
    }*/

    // 一对多

    private List<Employee> emp;

    public List<Employee> getEmp() {
        return emp;
    }
 
    public void setEmp(List<Employee> emp) {
        this.emp = emp;
    }

    public Integer getDeptId() {
        return deptId;
    }

    public void setDeptId(Integer deptId) {
        this.deptId = deptId;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

   

   /* @Override  一对一
    public String toString() {
        return "Department [deptId=" + deptId + ", deptName=" + deptName + ", admin=" + admin + "]";
    }*/

    @Override
    public String toString() {
        return "Department [deptId=" + deptId + ", deptName=" + deptName + ", emp=" + emp + "]";
    }

}
