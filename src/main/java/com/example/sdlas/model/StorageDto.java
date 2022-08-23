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
public class StorageDto {
    
    public static final SimpleDateFormat dateFormat
      = new SimpleDateFormat("yyyy-MM-dd");
    
    public String number;
    public String dateRegistration;
    public String type;
    public String tag;
    public String manufactureNumber;
    public String capacity;
    public String fromPlace;
    public String pcNumber;
    public boolean signEmployee;
    public boolean signToBack;
    public String registrationEndSign;
    public String comment;
    public String name;
    



    
    public Date getConvertedDate() throws ParseException {
        Date currentDate;
        currentDate = dateFormat.parse(dateRegistration);
        return currentDate;
    }
    
}
