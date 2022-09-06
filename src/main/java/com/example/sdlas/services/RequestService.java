/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.sdlas.services;

import com.example.sdlas.entities.JournalStorage;
import com.example.sdlas.entities.User;
import com.example.sdlas.repositories.JournalStorageRepo;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author 041AlikinOS
 */
@Service
public class RequestService {
    
   @Autowired
   private JournalStorageRepo journalStorageRepo;
   
   
    public List<JournalStorage> getAllDevices(User user) {
        long id = user.getId();
        
        
        return journalStorageRepo.findByEmployeeId(id);
    }
    
}
