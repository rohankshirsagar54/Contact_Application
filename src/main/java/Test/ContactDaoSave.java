/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Test;

import com.rohan.springcontactapp.configuration.SpringRootConfig;
import com.rohan.springcontactapp.dao.ContactDAO;
import com.rohan.springcontactapp.domain.Contact;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 *
 * @author ADMINN
 */
public class ContactDaoSave {

    
    public static void main(String[] args) {
     
        ApplicationContext ctx=new AnnotationConfigApplicationContext(SpringRootConfig.class);
        
        ContactDAO dao=ctx.getBean(ContactDAO.class);
        
        Contact c=new Contact();
        
        c.setUserId(14);
        c.setAddress("Mumbai");
        c.setEmail("ronny@gmail.com");
        c.setName("ronny");
        c.setPhone("9702402953");
        c.setRemark("good");
        
        dao.save(c);
        
        System.out.println("contact saved");
        
        
        
    }
    
}
