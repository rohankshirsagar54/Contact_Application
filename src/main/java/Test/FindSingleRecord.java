package Test;


import com.rohan.springcontactapp.configuration.SpringRootConfig;
import com.rohan.springcontactapp.dao.UserDAO;
import com.rohan.springcontactapp.domain.User;
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
public class FindSingleRecord {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       
            ApplicationContext ctx1=new AnnotationConfigApplicationContext(SpringRootConfig.class);
        
        UserDAO userdao2=ctx1.getBean(UserDAO.class);
        
     User u=userdao2.findById(10);
        
        System.out.println("User Details");
        
        System.out.println(u.getUserId());
        System.out.println(u.getName());
        System.out.println(u.getPhone());
        System.out.println(u.getEmail());
        System.out.println(u.getAddress());
        System.out.println(u.getLoginName());
        System.out.println(u.getLoginStatus());
        System.out.println(u.getRole());
        
    }
    
}
