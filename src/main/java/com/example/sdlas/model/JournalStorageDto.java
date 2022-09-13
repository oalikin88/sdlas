/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.sdlas.model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author 041AlikinOS
 */
@Getter
@Setter
public class JournalStorageDto {
    
    public static final SimpleDateFormat dateFormat
      = new SimpleDateFormat("dd.MM.yyyy");
    public Long id;
    public String number;
    public String dateRegistration;
    public String type;
    public String storageType;
    public String tag;
    public String manufactureNumber;
    public String capacity;
    public String measure;
    public String fromPlace;
    public String pcNumber;
    public String comment;
    public String employee;
    public String employeeSecurity;
    public boolean signEmployee;
    public boolean signToBack;
    public String RegistrationEndSign;
    public String getBackToSecurityUser;
    public String dateSignEmployee;
   
    



    
    public Date getConvertedDate() throws ParseException {
        Date currentDate;
        try {
            currentDate = dateFormat.parse(dateRegistration);
        } catch (ParseException e) {
            currentDate = new Date();
            System.out.println(e.getMessage());
        }
        
        return currentDate;
    }
    
}
