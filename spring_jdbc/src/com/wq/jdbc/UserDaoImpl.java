package com.wq.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import com.wq.bean.User;

public class UserDaoImpl extends JdbcDaoSupport   implements UserDao {
    //当继承jdbcDaoSupport时不需要配置jdbctemplate
    //private JdbcTemplate jt;

    /*public void setJt(JdbcTemplate jt) {
        this.jt = jt;
    }*/

    @Override
    public void save(User user) {
        // TODO Auto-generated method stub
        String sql = "insert into user(name) values(?)";
        super.getJdbcTemplate().update(sql, user.getName());

    }

    @Override
    public void delete(Integer id) {
        // TODO Auto-generated method stub
        String sql = "delete from user where id=?";
        super.getJdbcTemplate().update(sql, id);
    }

    @Override
    public void update(User user) {
        // TODO Auto-generated method stub
        String sql = "update user set name = ? where id=?";
        super.getJdbcTemplate().update(sql, user.getName(), user.getId());
    }

    @Override
    public List<User> getAll() {
        // TODO Auto-generated method stub
        String sql = "select * from user";
        List<User> list =  super.getJdbcTemplate().query(sql, new RowMapper<User>() {

            @Override
            public User mapRow(ResultSet rs, int arg1) throws SQLException {

                User u = new User();
                u.setId(rs.getInt("id"));
                u.setName(rs.getString("name"));
                return u;
            }
        });
        return list;

    }

    @Override
    public User findById(Integer id) {
        // TODO Auto-generated method stub
        String sql = "select * from user where id=?";
        return  super.getJdbcTemplate().queryForObject(sql, new RowMapper<User>() {

            @Override
            public User mapRow(ResultSet rs, int arg1) throws SQLException {

                User u = new User();
                u.setId(rs.getInt("id"));
                u.setName(rs.getString("name"));
                return u;
            }
        }, id);
    }

    @Override
    public int getTotalCount() {
        // TODO Auto-generated method stub
        String sql = "select count(*) from user";
        Integer count =  super.getJdbcTemplate().queryForObject(sql, Integer.class);
        return count;
    }

}
