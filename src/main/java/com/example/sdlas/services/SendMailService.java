/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.sdlas.services;

import com.example.sdlas.entities.JournalStorage;
import org.opfr.springBootStarterDictionary.clientImpl.EmployeeClient;
import org.opfr.springBootStarterDictionary.models.DictionaryEmployee;
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
@Autowired
private EmployeeClient employeeClient;

 
    public void sendMail(JournalStorage journalStorage) {
    DictionaryEmployee employee = employeeClient.getEmployeeByCode(journalStorage.getEmployee());
    DictionaryEmployee employeeSecurity = employeeClient.getEmployeeByCode(journalStorage.getEmployee());
        String emailEmployee = employee.getEmail();
        String emailEmployeeSecurity = employeeSecurity.getEmail();
        
            SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
            simpleMailMessage.setFrom(emailEmployeeSecurity);
            simpleMailMessage.setTo(emailEmployee);
            simpleMailMessage.setSubject("Подпись за получение " + journalStorage.getStorage().getType());
            simpleMailMessage.setText("Добрый день, " + employee.getSurname() + " " + " " + employee.getName() + " " + employee.getMiddlename() +
                    ", вам передано устройство: " + journalStorage.getStorage().getType() + ", имеющее инвентарный №:" + 
                    journalStorage.getStorage().getNumber() + ". Для того, чтобы поставить отметку о получении данного устройства пройдите по ссылке:" + 
                    "http://10.41.200.15:8080/myaccount" + " \n\n\n\n\nС уважением, " + employeeSecurity.getSurname() + " " + employeeSecurity.getName() + " " + employeeSecurity.getMiddlename());
     

            javaMailSender.send(simpleMailMessage);
        
    }
    
    
 
}
