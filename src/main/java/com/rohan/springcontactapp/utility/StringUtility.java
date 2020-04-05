/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rohan.springcontactapp.utility;


public class StringUtility {

    //static method because we dont want to cereate any object from it
  //helper method to convert array into comma separated string  
public static String toCommaSeparatedString(Object[] items){

    StringBuilder sb=new StringBuilder();
    for(Object item: items){
    sb.append(item).append(",");   // all items will be added with commaa seprated in string
    }
    if(sb.length()>0){
    sb.deleteCharAt(sb.length()-1);   // after adding all items u will get comma at end, and we dont want tht comma
    }
    return sb.toString();   // returning StringBuilder to String format
    
}
    
}
