/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.sdlas.auth;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.opfr.springbootstarterauthsso.security.UserInfo;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

/**
 *
 * @author 041AlikinOS
 */

@Component
@Getter
@Setter
@NoArgsConstructor
public class AuthenticationService {
    
    public UserInfo authUser() { 
    Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
    UserInfo userDetails = (UserInfo) authentication.getPrincipal();
    return userDetails;
    }
}
