/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.sdlas.services;

import com.example.sdlas.entities.JournalStorage;
import com.example.sdlas.repositories.JournalStorageRepo;
import java.util.ArrayList;
import java.util.List;
import org.opfr.springBootStarterDictionary.clientImpl.EmployeeClient;
import org.opfr.springBootStarterDictionary.models.DictionaryEmployee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author 041AlikinOS
 */
@Component
public class SearchService {
    @Autowired
    private EmployeeClient employeeClient;
    @Autowired
    private JournalStorageRepo journalStorageRepo;
    
    public List<JournalStorage> searchList(String request) {
        
      
        List<JournalStorage> journals = new ArrayList<>();
        
        for(DictionaryEmployee employee : employeeClient.getList()) {
            if(employee.getSurname().toLowerCase().contains(request.toLowerCase())) {
                if(journalStorageRepo.findByEmployee(employee.getCode()) != null) {
                    journals = journalStorageRepo.findByEmployee(employee.getCode());
                }
            
            }
        } if(journals.isEmpty()) {
        if(journalStorageRepo.findByStorageNumber(request) != null) {
            journals = journalStorageRepo.findByStorageNumber(request);
        }
        } if(journals.isEmpty()) {
            if(journalStorageRepo.findByStorageManufactureNumber(request) != null) {
            journals = journalStorageRepo.findByStorageManufactureNumber(request);
        } 
        } if(journals.isEmpty()) {
            if(journalStorageRepo.findByPcNumber(request) != null) {
            journals = journalStorageRepo.findByPcNumber(request);
            }
        }
        
      return journals;
    }
}
    

