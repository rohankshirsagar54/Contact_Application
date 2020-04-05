
package com.rohan.springcontactapp.controllers;

import com.rohan.springcontactapp.commands.LoginCommand;
import com.rohan.springcontactapp.commands.UserCommand;
import com.rohan.springcontactapp.domain.User;
import com.rohan.springcontactapp.exception.UserBlockedException;
import com.rohan.springcontactapp.services.UserService;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
//import java.util.logging.Level;
//import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UserController {
    
    /*
    "/"--means even without /index u can get the page output with help of "/"
    */
    @Autowired
    private UserService userService;
    
    @RequestMapping(value={"/","/index"})   
    public String index(Model m){
        m.addAttribute("command", new LoginCommand());
    return "index";
    }
    
     @RequestMapping(value="/login", method=RequestMethod.POST)   
    public String handleLogin(@ModelAttribute("command") LoginCommand cmd, Model m, HttpSession session) {
        try {
            User loggedInUser=userService.login(cmd.getLoginName(), cmd.getPassword());
            if(loggedInUser==null){
             m.addAttribute("err", "Login Failed!, Enter valid credentails");
            return "index";
            }
            else{
            //sucess part
            //check the role and redirect to appropiate dashboard
            if(loggedInUser.getRole().equals(UserService.ROLE_ADMIN)){
                addUserInSession(loggedInUser, session);
                return "redirect:admin/dashboard";
            }
            else if(loggedInUser.getRole().equals(UserService.ROLE_USER)){
                addUserInSession(loggedInUser, session);
                return "redirect:user/dashboard";
            }
            else{
             //add error message and go back to form if somw=ethin else is found
            m.addAttribute("err", "Invalid User Role");
            return "index";
            }
            }
        } catch (UserBlockedException ex) {
            //add error message and go back to form
            m.addAttribute("err", ex.getMessage());
            return "index";
        }
    }
    
     @RequestMapping(value="/logout")   
    public String logout(HttpSession session){
        session.invalidate();
    return "redirect:index?act=lo";
    }
    
     @RequestMapping(value={"/user/dashboard"})   
    public String userDashboard(){
    return "dashboard_user";
    }
    
     @RequestMapping(value={"/admin/dashboard"})   
    public String adminDashboard(){
    return "dashboard_admin";
    }
    
    @RequestMapping(value={"/admin/users"})   
    public String getUserList(Model m){
    m.addAttribute("userList", userService.getUserList());
    return "users";
    }
    
    @RequestMapping(value="/reg_form")
    public String registrationForm(Model m){
            UserCommand cmd=new UserCommand();
        m.addAttribute("command", cmd);
    return "reg_form";
    }
    
     @RequestMapping(value="/register")
    public String registerUser(@ModelAttribute("command") UserCommand cmd, Model m){     
         try {
             User user = cmd.getUser();
             user.setRole(UserService.ROLE_USER);
             user.setLoginStatus(UserService.LOGIN_STATUS_ACTIVE);
             userService.register(user);
             return "redirect:index?act=reg";  //if sucessful the login page
         } catch (DuplicateKeyException e) {
             m.addAttribute("err", "User is already Register");
             return "reg_form";
         }
    
    }
    
    private void addUserInSession(User u, HttpSession session){
    session.setAttribute("user",u);
    session.setAttribute("userId",u.getUserId());
    session.setAttribute("role",u.getRole());
    }
    
     @RequestMapping(value="/admin/change_status")
     @ResponseBody
    public String changeLoginStatus(@RequestParam Integer userId, @RequestParam Integer loginStatus){
         try {
             userService.changeLoginStatus(userId, loginStatus);
             return "SUCCESS: Status Changed";
         } catch (Exception e) {
             e.printStackTrace();
             return "ERROR: Unable to Change Status";
         }
    }
    
    @RequestMapping(value="/check_avail")
     @ResponseBody
    public String checkAvailability(@RequestParam String username){
         
           if(userService.isUsernameExist(username)){  
             return "Already taken, choose another!!";
         } else{
             return "Success";
         }
    }
    
    @RequestMapping(value="/website_about")
   public void showPDF(HttpServletResponse response) throws IOException {
    response.setContentType("application/pdf"); //viewing in web browser
    String filepath="/static/templates/Rohan Resume.pdf";  
 
    //for downloading the file directly if viewing is not possible
response.setHeader("Content-Disposition", "inline; filename="+filepath+";");  

   // InputStream inputStream = new FileInputStream(new File("/Rohan Resume.pdf"));
    //int nRead;
    //while ((nRead = inputStream.read()) != -1) {
      //  response.getWriter().write(nRead);
    //}
   }
}
    

