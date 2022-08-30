/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.sdlas.mappers;

import com.example.sdlas.interfaces.UnboxingZirData;
import com.example.sdlas.model.UserDto;


/**
 *
 * @author 041AlikinOS
 */
public class UserMapper implements UnboxingZirData {
    
    public static UserDto getUserData(String fioFromZir) {
        UserDto dto = new UserDto();
      
        int count = 0;
        String s = "";
        String[] buf = new String[4];
        char[] array = fioFromZir.toCharArray();
        char a = ' ';
        char b = ',';
        for(int i = 0; i < array.length; i++) {
            if(a != array[i] && b != array[i]) {
                s += array[i];
                if(i == (array.length - 1)) {
                    buf[count] = s;
                    break;
                }
                
            } else {
                if(buf[count] == null) {
                    buf[count] = s;
                }
                
                if(!s.isEmpty() && !s.isBlank()) {
                    s = "";
                    count++;
                }
                
                }
            
            
        }
        
        dto.lastName = buf[0];
        dto.firstName = buf[1];
        dto.fathersName = buf[2];
        dto.email = buf[3];
        
    return dto;
    }
    
}
