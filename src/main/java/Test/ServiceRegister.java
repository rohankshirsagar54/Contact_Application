package Test;


import com.rohan.springcontactapp.configuration.SpringRootConfig;
import com.rohan.springcontactapp.dao.UserDAO;
import com.rohan.springcontactapp.domain.User;
import com.rohan.springcontactapp.services.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ADMINN
 */
public class ServiceRegister {

    
    public static void main(String[] args) {
         ApplicationContext ctx1=new AnnotationConfigApplicationContext(SpringRootConfig.class);
        
        UserService userService=ctx1.getBean(UserService.class);
        
        //taking from user at time of egistartion
        
        
        User u=new User();
        u.setName("ramesh");
        u.setAddress("girgaon");
        u.setEmail("ramesh@gmail.com");
        u.setLoginName("ramesh11");
        u.setPassword("ramesh");
        u.setPhone("9702402953");
        u.setRole(UserService.ROLE_ADMIN);
        u.setLoginStatus(UserService.LOGIN_STATUS_ACTIVE);
        
        userService.register(u);
        
        System.out.print("completed");
    }
    
}
