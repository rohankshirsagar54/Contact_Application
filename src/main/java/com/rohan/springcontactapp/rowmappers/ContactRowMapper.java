/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rohan.springcontactapp.rowmappers;

import com.rohan.springcontactapp.domain.Contact;
import com.rohan.springcontactapp.domain.User;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author ADMINN
 */
public class ContactRowMapper implements RowMapper<Contact> {
    
 //abstract method of Row Mapper

    @Override
    public Contact mapRow(ResultSet rs, int i) throws SQLException {
        
        
        Contact c= new Contact();
        
        c.setContactId(rs.getInt("contactId"));
        c.setUserId(rs.getInt("userId"));
        c.setName(rs.getString("name"));
        c.setEmail(rs.getString("email"));
        c.setPhone(rs.getString("phone"));
        c.setAddress(rs.getString("address"));
        c.setRemark(rs.getString("remark"));
        
        return c;
    }
     
    
}
