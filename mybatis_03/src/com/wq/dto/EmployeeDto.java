package com.wq.dto;

import java.io.Serializable;
import java.util.List;

import com.wq.bean.Employee;

public class EmployeeDto implements Serializable {
    
    private Employee employee;

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
    
    private List<Integer> ids;

    public List<Integer> getIds() {
        return ids;
    }

    public void setIds(List<Integer> ids) {
        this.ids = ids;
    }
    
}
