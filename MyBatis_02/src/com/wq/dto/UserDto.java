package com.wq.dto;

import java.io.Serializable;
import java.util.List;

import com.wq.bean.User;
/**
 * 包装类
 * @author Administrator
 *
 */
public class UserDto  implements Serializable{

    private static final long serialVersionUID = 1L;
    
    private User user;
  

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

     

    
    
    
    

}
