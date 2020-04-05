/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rohan.springcontactapp.controllers;

import java.util.Date;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author ADMINN
 */
 @Controller       
public class TestController {
     
     @RequestMapping("/test/hello")
     public String Hello(){
     return "hello";
     }
     
     @RequestMapping("/test/ajax_test")
     public String testPage(){
     return "test";
     }
     
      @RequestMapping("/test/get_time")
      @ResponseBody
     public String getServerTime(){
         Date d=new Date();
     return d.toString();
     }
    
}
