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
public class dapupdate {

    
    public static void main(String[] args) {
        
        ApplicationContext ctx1=new AnnotationConfigApplicationContext(SpringRootConfig.class);
        
        UserDAO userdao=ctx1.getBean(UserDAO.class);
        
        //taking from user at time of egistartion
        
        
        User ut=new User();
        ut.setUserId(10);  //update the value for 11
        ut.setName("Rohan123");
        ut.setAddress("Mumbai");
        ut.setEmail("rohan@gmail.com");
       
        ut.setPhone("8082668841");
        ut.setRole(1);
        ut.setLoginStatus(1);
        
        userdao.update(ut);
        
        System.out.print("completed 1");
        
    }
    
}
