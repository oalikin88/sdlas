/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.sdlas.services;

import com.example.sdlas.entities.JournalStorage;
import com.example.sdlas.model.SignDto;
import com.example.sdlas.repositories.JournalStorageRepo;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author 041AlikinOS
 */
@Service
public class SignStorageService {
    
    @Autowired
    private JournalStorageRepo journalStorageRepo;
    
    
    public void signEmpoyeeForStorage(SignDto dto) {
        
        JournalStorage journalStorage = journalStorageRepo.findById(dto.Id).get();
        journalStorage.setSignEmployee(true);
        journalStorage.setDateSignEmployee(new Date());
        
        
        journalStorageRepo.save(journalStorage);
    }
    
    public void signSecurityWorker(SignDto dto) {
        JournalStorage journalStorage = journalStorageRepo.findById(dto.Id).get();
        journalStorage.setSignToBack(true);
        journalStorage.setGetBackToSecurityUser(new Date());
        if(!dto.registrationEndSign.isBlank() || !dto.registrationEndSign.isEmpty()) {
            journalStorage.setRegistrationEndSign(dto.registrationEndSign);
        } else {
            journalStorage.setRegistrationEndSign("");
        }
        
        
        journalStorageRepo.save(journalStorage);
    }
}
