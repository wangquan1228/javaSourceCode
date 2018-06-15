package com.wq.service;

import com.wq.entity.SysUser;

public interface SysUserService {
	
	SysUser login(SysUser user);
	
	String upatePwd(SysUser  user,String olduserPassword);
}
