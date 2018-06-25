package com.wq.test;

import java.util.List;

import org.junit.Test;

import com.wq.dao.PersonDao;
import com.wq.dao.implment.PersonDaoImp;
import com.wq.entity.Person;



public class PersonTest {
	@Test
	public void addTest(){
		PersonDao dao=new PersonDaoImp();
		dao.addPreson(new Person(2,"天涯","345","男","上海"));
		
	}
	
   @Test
	 public void updateTest(){
		PersonDao dao= new PersonDaoImp();
		Person p=new Person(2, "天涯", "345", "女", "北京");
		dao.update(p);
		
	} 
   @Test
   public void removeTest(){
	   PersonDao dao =new PersonDaoImp();
	   dao.remove(2);
	   
   }
   @Test 
   public void showTest(){
	   PersonDao dao=new PersonDaoImp();
		List<Person> list=dao.show();
		System.out.println(list);
   }
	

}
