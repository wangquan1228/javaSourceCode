package com.wq.dao;
 
import com.wq.entity.SysUser;

public interface SysUserDao {

	SysUser login(SysUser user); 
	 
	String  updatePwd(SysUser user,String olduserPassword);
}
