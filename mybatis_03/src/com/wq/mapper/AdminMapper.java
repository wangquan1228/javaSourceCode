package com.wq.mapper;

import java.util.List;

import com.wq.bean.Admin;

public interface AdminMapper {
    
    public void addAdmin(Admin admin);
    
    public List<Admin> getAdminAll();
    
    

}
