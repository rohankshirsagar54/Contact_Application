/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rohan.springcontactapp.services;

import com.rohan.springcontactapp.domain.User;
import com.rohan.springcontactapp.exception.UserBlockedException;
import java.util.List;
//import java.awt.List;


public interface UserService {
    //determines the status of user wether active or not
    public static final Integer LOGIN_STATUS_ACTIVE=1;
    public static final Integer LOGIN_STATUS_BLOCKED=2;
    
    //determines the role 
    public static final Integer ROLE_ADMIN=1;
    public static final Integer ROLE_USER=2;
    
    
    
    public void register(User u);
    /*
    if authentication fails then returns null;
    and if user account is blocked then we will get an exception(user defined) here
    
    and
    
     //when user is successfully loogeg in , we will get User object
    */
    public User login(String loginName, String password) throws UserBlockedException; 
    
    //call this method to get registerede Users
    public List<User> getUserList();
    
    /*
    this method change the user login status for details passed as argument
    */
    public void changeLoginStatus(Integer userId, Integer loginStatus);

    public Boolean isUsernameExist(String username);
    
}
