/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rohan.springcontactapp.configuration;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;


public class ContactAppDispatcherServletInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    @Override
     protected Class<?>[] getRootConfigClasses() {
     return new Class[]{SpringRootConfig.class};   
    }

    @Override
     protected Class<?>[] getServletConfigClasses() {
        return new Class[]{SpringWebConfig.class};
    }

    @Override
     protected String[] getServletMappings() {
     return new String[]{"/"};                // servlet mapping as used to do in [web.xml] for front controller
    }
    
    @Override
     public void onStartup(ServletContext servletContext) throws ServletException{
     super.onStartup(servletContext);
    
    }
       
}
