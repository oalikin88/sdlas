/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.sdlas.model;

import static com.example.sdlas.model.StorageDto.dateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author 041AlikinOS
 */
public class JournalPassHandOutDto {
    
    public static final SimpleDateFormat dateFormat
      = new SimpleDateFormat("yyyy-MM-dd");
    
    public String fioEmployee;
    public String doc;
    public String handOut;
    public String getBack;
    public String fioSecure;
    public boolean employeeSign;
    public boolean secureSign;
    
     public Date getConvertedDate() throws ParseException {
        Date currentDate;
        currentDate = dateFormat.parse(handOut);
        return currentDate;
    }   
}
