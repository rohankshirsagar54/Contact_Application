/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rohan.springcontactapp.exception;

/**
 *
 * @author ADMINN
 */
public class UserBlockedException extends Exception{
    
    //Creates userObject without error description
    public UserBlockedException(){
    }
    
    //creates userObject with error decsription
    public UserBlockedException (String errDesc){
super(errDesc);
}
    
}

