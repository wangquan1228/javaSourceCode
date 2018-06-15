package com.wq.jdbc;

import java.beans.PropertyVetoException;
import java.util.List;

import javax.annotation.Resource;

 
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.jdbc.core.JdbcTemplate;
 
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.mchange.v2.c3p0.ComboPooledDataSource;
 
import com.wq.bean.User;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class Demo {
    
    @Resource(name="userDao")
    private UserDao dao;
    
    
    /*@Test
    public  void fun1() throws PropertyVetoException {
        //1 准备链接池
         ComboPooledDataSource source = new ComboPooledDataSource();
         
         source.setDriverClass("com.mysql.jdbc.Driver");
         source.setJdbcUrl("jdbc:mysql:///hibernate");
         source.setUser("root");
         source.setPassword("wq951228");
         
         //2 准备JDBC模板
          JdbcTemplate template = new JdbcTemplate();
          template.setDataSource(source);
          String sql="insert into user(name) value('wq2')";
          
          template.update(sql);
    }*/
    /*
     * 添加
     */
    @Test
    public void fun2() {
        User user=new User();
        user.setName("胡司令");
        dao.save(user);
    }
    /*
     * 删除
     */
    @Test
    public void fun3() {
        dao.delete(2);
    }
    /*
     * 修改
     */
    @Test
    public void fun4() {
        User user=new User();
        user.setId(2);
        user.setName("沙奶奶");
        dao.update(user);
    }
    /*'
     * 删除
     */
    @Test
    public void fun5() {
      dao.delete(2);
    }
    /*
     * 查找个人
     * 
     */
    @Test
    public void fun6() {
     User user= dao.findById(3);
     System.out.println(user);
    }
    /*
     *查找总人数 
     */
    @Test
    public void fun7() {
      int i=dao.getTotalCount();
      System.out.println(i);
    }
    /*
     * 查找所有人
     */
    @Test
    public void fun8() {
        List<User> list=dao.getAll();
      System.out.println(list);
    }
}

