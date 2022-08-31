/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.sdlas.services;

import com.example.sdlas.entities.Storage;
import org.opfr.springbootstarterauthsso.security.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

/**
 *
 * @author 041AlikinOS
 */

@Service
public class SendMailService {

@Autowired
private JavaMailSender javaMailSender;

@Autowired
private ZirService zirService;

 
    public void sendMail(Storage storage) {
        String email = storage.getUser().getEmail();

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserInfo userDetails = (UserInfo) authentication.getPrincipal();
        String id = userDetails.getUserCode();
        int parseId = Integer.parseInt(id);
        String emailSender = zirService.getEmailUserById(parseId);
        
            SimpleMailMessage simpleMailMessage = new SimpleMailMessage();

            simpleMailMessage.setFrom(emailSender);
            simpleMailMessage.setTo(email);
            simpleMailMessage.setSubject("Подпись за получение НЖМД");
            simpleMailMessage.setText("test test");

            javaMailSender.send(simpleMailMessage);
        
    }
}
