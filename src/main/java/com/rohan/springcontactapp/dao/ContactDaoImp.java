/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rohan.springcontactapp.dao;

import com.rohan.springcontactapp.domain.Contact;
import com.rohan.springcontactapp.rowmappers.ContactRowMapper;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

@Repository
public class ContactDaoImp extends BaseDAO implements ContactDAO {

    @Override
    public void save(Contact c) {
       
        String sql="INSERT into contact(userId, name, phone, email, address, remark) VALUES (:userId,:name,:phone, :email,:address, :remark)";
        
        Map m=new HashMap();
        m.put("userId", c.getUserId());
        m.put("name", c.getName());
        m.put("phone", c.getPhone());
        m.put("email", c.getEmail());
        m.put("address", c.getAddress());
        m.put("remark", c.getRemark());
        
        
        SqlParameterSource sc=new MapSqlParameterSource(m);
        KeyHolder kh=new GeneratedKeyHolder();
        getNamedParameterJdbcTemplate().update(sql,sc, kh);
        c.setContactId(kh.getKey().intValue());   //setting the unique key generated from each contact id
        
        
    }

    @Override
    public void update(Contact c) {
        String sql="UPDATE contact SET   name=:name, phone=:phone, email=:email, address=:address, remark=:remark WHERE contactId=:contactId";
        Map m=new HashMap();
        m.put("contactId", c.getContactId());
        m.put("name", c.getName());
        m.put("phone", c.getPhone());
        m.put("email", c.getEmail());
        m.put("address", c.getAddress());
        m.put("remark", c.getRemark());
        
        getNamedParameterJdbcTemplate().update(sql,m);
        
    }

    @Override
    public void delete(Contact c) {     // Contact c is object 
        this.delete(c.getContactId());   // from this (c) object we are getting getContactId() and passing to next delete()
    }

    @Override
    public void delete(Integer contactId) {
         String sql="DELETE from contact WHERE contactId=?";
         getJdbcTemplate().update(sql, contactId);
    }

    @Override
    public Contact findById(Integer contactId) {
      String sql="SELECT contactId,userId, name, phone, email, address, remark FROM contact WHERE contactId=?";
      
      return getJdbcTemplate().queryForObject(sql, new ContactRowMapper(), contactId);
    }

    @Override
    public List<Contact> findAll() {
        String sql="SELECT contactId,userId, name, phone, email, address, remark FROM contact";
      
      return getJdbcTemplate().query(sql, new ContactRowMapper());
    }

    @Override
    public List<Contact> findByProperty(String propName, Object propValue) {
      String sql="SELECT contactId,userId, name, phone, email, address, remark FROM contact WHERE "+propName+"=?";
      
      return getJdbcTemplate().query(sql, new ContactRowMapper(),propValue );
    }
    
}
