package com.wq.bean;

public class Admin {
    private Integer deptId;
    
    private String name;
    
    private String deptName;
    
    public String getDeptName() {
        return deptName;
    }
    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }
    public Integer getDeptId() {
        return deptId;
    }
    public void setDeptId(Integer deptId) {
        this.deptId = deptId;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    @Override
    public String toString() {
        return "Admin [deptId=" + deptId + ", name=" + name + ", deptName=" + deptName + "]";
    }
    
    
}
