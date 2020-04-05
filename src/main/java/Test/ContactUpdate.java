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
public class ContactUpdate {

    
    public static void main(String[] args) {
      
        ApplicationContext ctx=new AnnotationConfigApplicationContext(SpringRootConfig.class);
        
        ContactDAO contact=ctx.getBean(ContactDAO.class);
        
        Contact c=new Contact();
        
        c.setAddress("Pune");
        c.setContactId(1);
        c.setEmail("rohan@gmail.com");
        c.setName("Ronny Kshirsagar");
        c.setPhone("9029153494");
        c.setRemark("nice");
        
        contact.update(c);
        
        System.out.println("Contact Updated");
        
        
    }
    
}
