package com.wq.bean;

import java.io.Serializable;

public class Admin implements Serializable {
    /**
     * 
     */
    private static final long serialVersionUID = -228465614865347208L;

    private Integer deptId;

    private String name;

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
        return "Admin [deptId=" + deptId + ", name=" + name + "]";
    }

}
