/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Test;

import com.rohan.springcontactapp.configuration.SpringRootConfig;
import com.rohan.springcontactapp.dao.ContactDAO;
import com.rohan.springcontactapp.domain.Contact;
import java.util.List;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 *
 * @author ADMINN
 */
public class ContactFindByProperty {

   
    public static void main(String[] args) {
       
        
        ApplicationContext ctx=new AnnotationConfigApplicationContext(SpringRootConfig.class);
        
        ContactDAO contact=ctx.getBean(ContactDAO.class);
        
        List<Contact> con=contact.findByProperty("remark", "nice");
        
        for(Contact c:con){
        System.out.println(c.getAddress()+"  "+c.getPhone());
        }
        
        
    }
    
}
