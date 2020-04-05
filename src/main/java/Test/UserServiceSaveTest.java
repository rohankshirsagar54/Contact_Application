/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Test;

import com.rohan.springcontactapp.configuration.SpringRootConfig;
//import com.rohan.springcontactapp.dao.UserDAO;
import com.rohan.springcontactapp.domain.User;
import com.rohan.springcontactapp.exception.UserBlockedException;
import com.rohan.springcontactapp.services.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 *
 * @author ADMINN
 */
public class UserServiceSaveTest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws UserBlockedException {
         ApplicationContext ctx1=new AnnotationConfigApplicationContext(SpringRootConfig.class);
        
        UserService userdao3=ctx1.getBean(UserService.class);
        
        User u=userdao3.login("ramesh11", "ramesh");
        
     System.out.println(u);
        
    }
    
}
