/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.sdlas.services;

import com.example.sdlas.entities.JournalStorage;
import com.example.sdlas.repositories.JournalStorageRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author 041AlikinOS
 */


@Component
public class EmployeeService {

@Autowired
private JournalStorageRepo journalStorageRepo;
    
    public String getEmployee(Long id) {
    JournalStorage journalStorage = journalStorageRepo.findById(id).get();
    return journalStorage.getEmployee();
    }


}
