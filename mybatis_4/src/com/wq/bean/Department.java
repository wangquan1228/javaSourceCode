package com.wq.bean;

import java.io.Serializable;
import java.util.List;

public class Department implements Serializable{

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    private Integer deptId;

    private String deptName;
    
    private List<Employee> emps;
    
    public List<Employee> getEmps() {
        return emps;
    }

    public void setEmps(List<Employee> emps) {
        this.emps = emps;
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

    @Override
    public String toString() {
        return "Department [deptId=" + deptId + ", deptName=" + deptName + ", emps=" + emps + "]";
    }

   

}
