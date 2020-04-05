
package com.rohan.springcontactapp.commands;

/**
 * its a pojo class communicating with form,take data from controller to view(edit view) and 
 * vice-versa(while submitting the form to the save/update data)
 * 
 */
public class LoginCommand {
    
  private  String loginName;
  private  String password;

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
}
