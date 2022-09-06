/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.sdlas.mappers;

import com.example.sdlas.model.UserDto;
import org.opfr.springbootstarterauthsso.security.UserInfo;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;


/**
 *
 * @author 041AlikinOS
 */
public class UserMapper  {
    
    public static UserDto getUserData(String fioFromZir) {
        UserDto dto = new UserDto();
      
        int count = 0;
        String s = "";
        String[] buf = new String[5];
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
        Integer i = Integer.parseInt(buf[0]);
        dto.id = i;
        dto.lastName = buf[1];
        dto.firstName = buf[2];
        dto.fathersName = buf[3];
        dto.email = buf[4];
        
    return dto;
    }
    
    public static UserDto getEmployeeSecurity() {
        
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserInfo userDetails = (UserInfo) authentication.getPrincipal();
        String fio = userDetails.getUserCode() + " " + userDetails.getFio();
        UserDto dto = getUserData(fio);
        return dto;
    }
    
}
