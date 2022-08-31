/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.sdlas.controllers;

import com.example.sdlas.entities.Hdd;
import com.example.sdlas.entities.User;
import com.example.sdlas.repositories.UserRepo;
import com.example.sdlas.services.RequestService;
import com.example.sdlas.services.ZirService;
import java.util.List;
import org.opfr.springbootstarterauthsso.security.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author 041AlikinOS
 */
@RestController
public class Employee {
    
    @Autowired
    private RequestService requestService;
    @Autowired
    private ZirService ZirService;
    @Autowired
    private UserRepo userRepo;
         
    @GetMapping("/account")
    public List<Hdd> getData(Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserInfo userDetails = (UserInfo) authentication.getPrincipal();
        String notParseId = userDetails.getUserCode();
        int id = Integer.parseInt(notParseId);
        String emailUser = ZirService.getEmailUserById(id);
        User user = userRepo.findByEmail(emailUser);
       List<Hdd> hdd = requestService.getAllDevices(user);
   //    model.addAttribute("hdd", hdd);
        return hdd;
    }
    
}
