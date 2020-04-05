
package com.rohan.springcontactapp.configuration;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import java.beans.PropertyVetoException;
//import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;


        
 @Configuration 
 @ComponentScan(basePackages ={"com.rohan.springcontactapp.dao","com.rohan.springcontactapp.services"})
public class SpringRootConfig {
    
// business layer, dao, services

//dbcp2
 /*    
     @Bean
public BasicDataSource getDataSource(){

    BasicDataSource ds= new BasicDataSource();
    ds.setDriverClassName("com.mysql.jdbc.Driver");
    
    ds.setUrl("jdbc:mysql://localhost:3306/contact_db");
    
    ds.setUsername("root");
    ds.setPassword("Ramesh@1994");
    
    ds.setMaxTotal(2);
    ds.setInitialSize(1);
    ds.setTestOnBorrow(true);
    ds.setValidationQuery("SELECT 1");
    ds.setDefaultAutoCommit(true);
    
    return ds;

}
*/

     // c3p0
     @Bean(name="bussService")
     public ComboPooledDataSource dataSource() throws PropertyVetoException{
    ComboPooledDataSource ds = new ComboPooledDataSource();
    {
     ds.setDriverClass("com.mysql.jdbc.Driver");
    
    ds.setJdbcUrl("jdbc:mysql://localhost:3306/contact_db");
    
    ds.setUser("root");
    ds.setPassword("Ramesh@1994");
    
   // ds.setMaxTotal(2);
    //ds.setInitialSize(1);
    //ds.setTestOnBorrow(true);
    //ds.setValidationQuery("SELECT 1");
    //ds.setDefaultAutoCommit(true);
    
    return ds;
     
     }
     
     } 
     
}
