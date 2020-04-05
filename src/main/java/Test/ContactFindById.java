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
public class ContactFindById {

   
    public static void main(String[] args) {
        
        ApplicationContext ctx=new AnnotationConfigApplicationContext(SpringRootConfig.class);
        
        ContactDAO contact=ctx.getBean(ContactDAO.class);
        
        Contact c=contact.findById(1);
        
        System.out.println(c.getAddress());
        System.out.println(c.getName());
        System.out.println(c.getPhone());
        System.out.println(c.getEmail());
        System.out.println(c.getRemark());
        System.out.println(c.getUserId());
        
        
        
        
        
    }
    
}
