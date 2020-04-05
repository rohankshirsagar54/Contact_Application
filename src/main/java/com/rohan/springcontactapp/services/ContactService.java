/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rohan.springcontactapp.services;

import com.rohan.springcontactapp.domain.Contact;
import java.util.List;

/**
 * the interface related to contact
 * @
 */
public interface ContactService {
    
    public void save(Contact c);
    public void update(Contact c);
    public void delete(Integer contactId);   //one by one u can delete contact using primary key
    public void delete(Integer[] contactIds); // multiple can be deleted
    public Contact findById(Integer contactId);
    public List<Contact> findUserContact(Integer userId); //logged in user can only see his/her personal phonebook contacts
    public List<Contact> findUserContact(Integer userId, String txt); //user account will be searched using txt(text searching) criteria
}
