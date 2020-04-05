
package com.rohan.springcontactapp.controllers;

import com.rohan.springcontactapp.domain.Contact;
import com.rohan.springcontactapp.services.ContactService;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author ADMINN
 */
  
@Controller
        
public class ContactController {
    @Autowired
    private ContactService contactService;
    
 @RequestMapping(value="/user/contact_form")
 public String contactForm(Model m){
 Contact contact=new Contact();
 m.addAttribute("command", contact);
 return "contact_form";
 }  
 
  @RequestMapping(value="/user/save_contact")
 public String saveorUpdateContact(@ModelAttribute("command") Contact c, Model m, HttpSession session){
     /*
      try {
          Integer userId = (Integer) session.getAttribute("userId");
          c.setUserId(userId); //FK
          contactService.save(c);
          return "redirect:clist?act=sv";
      } catch (Exception e) {
          e.printStackTrace();
          m.addAttribute("err","Failed to save Conatct");
          return "contact_form";
      }
*/
     Integer contactId=(Integer) session.getAttribute("contactId");
     if(contactId==null){
         //save task
      try {
          // taking the userId beacuse contact belongs to particulat logged in User
          //getting the userId from logged in user from thier session
          Integer userId = (Integer) session.getAttribute("userId");  
          c.setUserId(userId); //Foreing key
          contactService.save(c);  //saving the contact
          return "redirect:clist?act=sv";
      } catch (Exception e) {
          e.printStackTrace();
          m.addAttribute("err","Failed to save Conatct");
          return "contact_form";
      }
     }
     else{
         //updte task
      try {
         
          c.setContactId(contactId); //PK
          contactService.update(c);
          return "redirect:clist?act=ed";
      } catch (Exception e) {
          e.printStackTrace();
          m.addAttribute("err","Failed to Edit Conatct");
          return "contact_form";
      }
     }
 }
 
  @RequestMapping(value="/user/clist")
 public String contactList(Model m, HttpSession session){
     Integer userId=(Integer) session.getAttribute("userId");
 m.addAttribute("contactList", contactService.findUserContact(userId));
 return "clist";
 } 
 
  @RequestMapping(value="/user/del_contact") // contactId associated for deleting contact info
  // and for each link we have assigned cid(unique id) which will bind with contact id, 
          //so that particular contact will be deleted
 public String deleteContact(@RequestParam("cid") Integer contactId){   
     contactService.delete(contactId);
     return "redirect:clist?act=del";
 } 
 
 
  @RequestMapping(value="/user/edit_contact")
 public String preparedEditForm(Model m, HttpSession session, @RequestParam("cid") Integer contactId){
     session.setAttribute("contactId", contactId);// contact id will be stored in sessionScope for future use
     Contact c=contactService.findById(contactId);// fetch complete details for that particular id from dtabase
     m.addAttribute("command", c);// will bind conatact detail in command so that it cn be shown in form
     return "contact_form";// contact form will be viewed where we will save or update the data
     
     // how????
     
     // we have session of contact id. so using that session we will chek weather contact id is present in session scope
     //if present then update or save
 } 
 
 @RequestMapping(value="/user/contact_search")
 public String contactSearch(Model m, HttpSession session, @RequestParam("freeText") String freeText){
     Integer userId=(Integer) session.getAttribute("userId");
 m.addAttribute("contactList", contactService.findUserContact(userId, freeText));
 return "clist";
 } 
 
}
