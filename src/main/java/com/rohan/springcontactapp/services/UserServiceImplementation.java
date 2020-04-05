
package com.rohan.springcontactapp.services;

import com.rohan.springcontactapp.dao.BaseDAO;
import com.rohan.springcontactapp.dao.UserDAO;

import com.rohan.springcontactapp.domain.User;
import com.rohan.springcontactapp.exception.UserBlockedException;
import com.rohan.springcontactapp.rowmappers.UserRowMapper;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

@Service   // to repreent the service layer
public class UserServiceImplementation extends BaseDAO implements UserService {
    @Autowired
private UserDAO userDAO;   // if operations are already available at DAO, we an use it
    
    
    @Override
    public void register(User u) {
           userDAO.save(u);
    }

    @Override
    public User login(String loginName, String password) throws UserBlockedException {
        String sql = "SELECT userId, name, phone, email, address, role, loginStatus, loginName FROM user WHERE loginName=:ln AND password=:pw";
        Map m = new HashMap();  //binding values for namedParameter
        m.put("ln", loginName);
        m.put("pw", password);
        try {
            User u = getNamedParameterJdbcTemplate().queryForObject(sql, m, new UserRowMapper());
            if (u.getLoginStatus().equals(UserService.LOGIN_STATUS_BLOCKED)) {      // if user is blocked
                throw new UserBlockedException("Your accout has been blocked. Contact to admin.");
            } else {
                
              return u;
            }
        } catch (EmptyResultDataAccessException ex) {
            return null;  //when no record found from database it return null
        }
    }

    @Override
    public List<User> getUserList() {
         return userDAO.findByProperty("role", UserService.ROLE_USER);
    }

    @Override
    public void changeLoginStatus(Integer userId, Integer loginStatus) {
        String sql = "UPDATE user SET loginStatus=:lst WHERE userId=:uid";
        Map m = new HashMap();
        m.put("uid", userId);
        m.put("lst", loginStatus);
        getNamedParameterJdbcTemplate().update(sql, m);
    }
    
     //@Override
    public Boolean isUsernameExist(String username) {
        String sql = "SELECT count(loginName) FROM user WHERE loginName=?";
        Integer count = getJdbcTemplate().queryForObject(sql, new String[]{username}, Integer.class);
        if(count==1){
            return true;
        }else{
            return false;
        }
    }

   
   
}
