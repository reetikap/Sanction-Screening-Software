package com.cbp;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class UserDAO {
	@Autowired
    private JdbcTemplate jdbcTemplate;
  
    @Transactional
    public int add(User user) {
        return jdbcTemplate.update("INSERT INTO users(username,email,password) VALUES(?,?,?)", user.getUserName(), user.getEmailId(),user.getPassword());
    }
  
    @Transactional(readOnly=true)
    public User searchEmailId(String emailId) {
    	String sql = "SELECT * FROM users WHERE email="+"'"+emailId+"'";
   	 
        User user = jdbcTemplate.query(sql,
        		new UserRowMapper()).get(0);
     
        return user;
    }
    
    @Transactional(readOnly=true)
    public User searchEmailIdAndPassword(String emailId, String password) {
    	String sql = "SELECT * FROM users WHERE email='"+emailId+"' AND password='"+password+"'";
        User user = jdbcTemplate.query(sql,
        		new UserRowMapper()).get(0);
     
        return user;
    }
}
class UserRowMapper implements RowMapper<User>
{
    @Override
    public User mapRow(ResultSet rs, int rowNum) throws SQLException {
        User user = new User();
        user.setId(rs.getInt("user_id"));
        user.setUserName(rs.getString("username"));
        user.setEmailId(rs.getString("email"));
        user.setPassword(rs.getString("password"));
        return user;
    }
}


