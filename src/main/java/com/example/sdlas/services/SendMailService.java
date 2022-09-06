/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.sdlas.services;

import com.example.sdlas.entities.JournalStorage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

/**
 *
 * @author 041AlikinOS
 */

@Service
public class SendMailService {

@Autowired
private JavaMailSender javaMailSender;


 
    public void sendMail(JournalStorage journalStorage) {
        String emailEmployee = journalStorage.getEmployee().getEmail();
        String emailEmployeeSecurity = journalStorage.getSecurityEmployee().getEmail();
        
            SimpleMailMessage simpleMailMessage = new SimpleMailMessage();

            simpleMailMessage.setFrom(emailEmployeeSecurity);
            simpleMailMessage.setTo(emailEmployee);
            simpleMailMessage.setSubject("Подпись за получение " + journalStorage.getStorage().getType());
            simpleMailMessage.setText("Добрый день, " + journalStorage.getEmployee().getFirstName() + " " + journalStorage.getEmployee().getFathersName() +
                    ", вам передано устройство: " + journalStorage.getStorage().getType() + ", имеющее инвентарный №:" + 
                    journalStorage.getStorage().getNumber() + ". Для того, чтобы поставить отметку о получении данного устройства пройдите по ссылке:" + 
                    "http://10.41.200.15:8080/myaccount" + " \n\n\n\n\nС уважением, " + journalStorage.getSecurityEmployee().getLastName() + " " + journalStorage.getSecurityEmployee().getFirstName() +
                    " " + journalStorage.getSecurityEmployee().getFathersName());
     

            javaMailSender.send(simpleMailMessage);
        
    }
}
