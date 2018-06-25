package com.wq.dao;

import java.util.List;

import com.wq.entity.Person;

public interface PersonDao {
	//添加人
	void addPreson(Person p);
	//修改信息
	Person update(Person p);
	//删除
	void remove(int id);
	//查找
	Person findByID(int id);
	//显示
	List<Person> show();

}
