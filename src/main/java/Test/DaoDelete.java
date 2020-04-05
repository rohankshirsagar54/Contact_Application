package Test;


import com.rohan.springcontactapp.configuration.SpringRootConfig;
import com.rohan.springcontactapp.dao.UserDAO;
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
public class DaoDelete {

    
    public static void main(String[] args) {
        
        ApplicationContext ctx1=new AnnotationConfigApplicationContext(SpringRootConfig.class);
        
        UserDAO userdao1=ctx1.getBean(UserDAO.class);
        
        userdao1.delete(15);
        
        System.out.println("deleted");
        
        
    }
    
}
