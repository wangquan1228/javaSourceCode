package com.wq.bean;

import java.io.Serializable;
import java.math.BigDecimal;

public class Employee implements Serializable{
    
    /**
     * 
     */
    private static final long serialVersionUID = 5616502152247147772L;

    private Integer empId;
    
    private String  empName;
    
    private String gender;
    
    private String email;
    
    private BigDecimal salary;
    
    private String jobTitle;
    
    private Integer deptId;
    
    private Department department;

    public Integer getEmpId() {
        return empId;
    }

    public void setEmpId(Integer empId) {
        this.empId = empId;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public Integer getDeptId() {
        return deptId;
    }

    public void setDeptId(Integer deptId) {
        this.deptId = deptId;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    @Override
    public String toString() {
        return "Employee [empId=" + empId + ", empName=" + empName + ", gender=" + gender + ", email=" + email + ", salary=" + salary + ", jobTitle=" + jobTitle + ", deptId=" + deptId
                + ", department=" + department + "]";
    }
    
    
    
    
    
    
}
