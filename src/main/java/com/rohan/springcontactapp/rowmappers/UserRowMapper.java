
package com.rohan.springcontactapp.rowmappers;

import com.rohan.springcontactapp.domain.User;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;


public class UserRowMapper implements RowMapper<User> {
    
 //abstract method of Row Mapper

    @Override
    public User mapRow(ResultSet rs, int i) throws SQLException {
        
        
        User u= new User();
        
        u.setUserId(rs.getInt("userId"));
        u.setName(rs.getString("name"));
        u.setEmail(rs.getString("email"));
        u.setPhone(rs.getString("phone"));
        u.setAddress(rs.getString("address"));
        u.setLoginName(rs.getString("loginName"));
        u.setLoginStatus(rs.getInt("loginStatus"));
        u.setRole(rs.getInt("role"));
        
        return u;
    }
    
    
    
}
