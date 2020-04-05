
package com.rohan.springcontactapp.dao;

import com.rohan.springcontactapp.domain.User;
import com.rohan.springcontactapp.rowmappers.UserRowMapper;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;

import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

@Repository    // class handling the database must be annotated with Repository
public class UserDAOImple extends BaseDAO implements UserDAO {

    @Override
    public void save(User u) {
      String sql = "INSERT INTO user(name, phone, email, address, loginName, password, role, loginStatus)"
                + " VALUES(:name, :phone, :email, :address, :loginName, :password, :role, :loginStatus)";   //Namedparameters are declare uing colon
        Map m = new HashMap();
        m.put("name", u.getName());
        m.put("phone", u.getPhone());
        m.put("email", u.getEmail());
        m.put("address", u.getAddress());
        m.put("loginName", u.getLoginName());
        m.put("password", u.getPassword());
        m.put("role", u.getRole());
        m.put("loginStatus", u.getLoginStatus());  
        
        
         KeyHolder kh = new GeneratedKeyHolder();
        SqlParameterSource ps = new MapSqlParameterSource(m);
        super.getNamedParameterJdbcTemplate().update(sql, ps, kh);
        Integer userId = kh.getKey().intValue();
        u.setUserId(userId);
        
    }

    @Override
    public void update(User ut) {
 String sql="Update user SET name=:name, phone=:phone, email=:email, address=:address, role=:role, loginStatus=:loginStatus Where userId=:userId";
 
 Map m=new HashMap();
   m.put("name", ut.getName());
        m.put("phone", ut.getPhone());
        m.put("email", ut.getEmail());
        m.put("address", ut.getAddress());
        m.put("role", ut.getRole());
        m.put("loginStatus", ut.getLoginStatus());
        m.put("userId",ut.getUserId());  // binding primary key that is userid will be received from user object
        
        getNamedParameterJdbcTemplate().update(sql,m);
    }

    @Override
    public void delete(User u) {
       this.delete(u.getUserId());  // using this (delete(Integer userId)) over here
    }

    @Override
    public void delete(Integer userId) {
    String sql="DELETE from user WHERE userId=?";
        getJdbcTemplate().update(sql,userId);
    }

    @Override
    public User findById(Integer userId) {   //one primary key value will be passed, so one record from database will be mpped to object
      String sql="SELECT userId, name, email, address, phone, loginName, role, loginStatus FROM user WHERE userId=?";
      
      User u= getJdbcTemplate().queryForObject(sql, new UserRowMapper(), userId);
      return u;
    }

    @Override
    public List<User> findAll() {   //return list of users
        String sql="SELECT userId, name, email, address, phone, loginName, role, loginStatus FROM user";
        
        /*
        List<User> users= getJdbcTemplate().query(sql, new UserRowMapper()); 
        return users;
*/
        return getJdbcTemplate().query(sql, new UserRowMapper());
        
    }

    @Override   // find the value of user whose userid or name will 1 or rohan
    public List<User> findByProperty(String propName, Object propValue) {
       String sql="SELECT userId, name, email, address, phone, loginName, role, loginStatus FROM user WHERE "+propName+"=?";
       
       return getJdbcTemplate().query(sql, new UserRowMapper(), propValue);
    }
    
}
