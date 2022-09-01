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
            simpleMailMessage.setSubject("Подпись за получение " + storage.getType());
            simpleMailMessage.setText("Добрый день, " + storage.getUser().getFirstName() + " " + storage.getUser().getFathersName() + ", вам передано устройство: " + storage.getType() + ", имеющее инвентарный №:" + storage.getNumber() + ". Для того, чтобы поставить отметку о получении данного устройства пройдите по ссылке:" + "http://10.41.200.15:8080/myaccount" + " \n\n\n\n\nС уважением, " + userDetails.getFio());
     

            javaMailSender.send(simpleMailMessage);
        
    }
}
