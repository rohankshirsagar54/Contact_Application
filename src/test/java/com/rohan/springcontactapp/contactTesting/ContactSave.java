/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rohan.springcontactapp.contactTesting;

import com.rohan.springcontactapp.configuration.SpringRootConfig;
import com.rohan.springcontactapp.dao.ContactDAO;
import com.rohan.springcontactapp.dao.UserDAO;
import com.rohan.springcontactapp.domain.Contact;
import com.rohan.springcontactapp.domain.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 *
 * @author ADMINN
 */
public class ContactSave {

    
    public static void main(String[] args) {
      ApplicationContext ctx1=new AnnotationConfigApplicationContext(SpringRootConfig.class);
        
        ContactDAO contactdao=ctx1.getBean(ContactDAO.class);
        
        //taking from user at time of registartion
        
        
        Contact c=new Contact();
        c.setName("rohan11");
        c.setAddress("pune, up");
        c.setEmail("rohan54@gmail.com");
        c.setPhone("8082668811");
        c.setRemark("done well");
      
        
        contactdao.save(c);
        
        System.out.print("completed");
    }
    
}
