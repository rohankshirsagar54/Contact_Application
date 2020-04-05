/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Test;

import com.rohan.springcontactapp.configuration.SpringRootConfig;
import com.rohan.springcontactapp.dao.ContactDAO;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 *
 * @author ADMINN
 */
public class ContactDelete {

    
    public static void main(String[] args) {
         ApplicationContext ctx=new AnnotationConfigApplicationContext(SpringRootConfig.class);
        
        ContactDAO contact=ctx.getBean(ContactDAO.class);
        
        contact.delete(2);
        
        System.out.print("Contact deleted for based on userId");
    }
    
}
