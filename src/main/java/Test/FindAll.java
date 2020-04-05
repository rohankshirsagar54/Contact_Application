package Test;


import com.rohan.springcontactapp.configuration.SpringRootConfig;
import com.rohan.springcontactapp.dao.UserDAO;
import com.rohan.springcontactapp.domain.User;
import java.util.List;
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
public class FindAll {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       
         ApplicationContext ctx1=new AnnotationConfigApplicationContext(SpringRootConfig.class);
        
        UserDAO userdao3=ctx1.getBean(UserDAO.class);
        
        List<User> users= userdao3.findAll();
        
        for(User u: users){
        
        System.out.println(u.getUserId()+" "+ u.getName()+ " "+ u.getEmail());
        }
        
        
    
    }
    
}
