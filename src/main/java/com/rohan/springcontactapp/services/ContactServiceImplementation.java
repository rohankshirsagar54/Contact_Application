/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rohan.springcontactapp.services;

import com.rohan.springcontactapp.dao.BaseDAO;
import com.rohan.springcontactapp.dao.ContactDAO;
import com.rohan.springcontactapp.domain.Contact;
import com.rohan.springcontactapp.rowmappers.ContactRowMapper;
import com.rohan.springcontactapp.utility.StringUtility;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContactServiceImplementation extends BaseDAO implements ContactService {
    @Autowired
    private ContactDAO contactDAO;   // always communicate with interface from one layer to another

    @Override
    public void save(Contact c) {
        contactDAO.save(c);
    }

    @Override
    public void update(Contact c) {
         contactDAO.update(c);
    }

    @Override
    public void delete(Integer contactId) {
        contactDAO.delete(contactId);
    }

    @Override   // customized query
    public void delete(Integer[] contactIds) {
        String ids=StringUtility.toCommaSeparatedString(contactIds);
         String sql="DELETE from contact WHERE contactId IN("+ids+")";  //IN(paasing all the ids which will be deleted)
         getJdbcTemplate().update(sql);
    }

    @Override   //("userId"--returns all the value for thi userId, value will be input userid
    public List<Contact> findUserContact(Integer userId) {
         return contactDAO.findByProperty("userId", userId);
    }

    @Override
    public List<Contact> findUserContact(Integer userId, String txt) {  
      //userId=? will be given by user AND pattern matching
        String sql="SELECT contactId,userId, name, phone, email, address, remark FROM contact WHERE userId=? AND (name LIKE '%"+txt+"%' OR address LIKE '%"+txt+"%' OR phone LIKE '%"+txt+"%' OR email LIKE '%"+txt+"%' OR remark LIKE '%"+txt+"%' )";
      
      return getJdbcTemplate().query(sql, new ContactRowMapper(), userId);
    }

    @Override
    public Contact findById(Integer contactId) {
         return contactDAO.findById(contactId);
    }
    
}
