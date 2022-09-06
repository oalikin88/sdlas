/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.sdlas.mappers;

import com.example.sdlas.entities.JournalStorage;
import com.example.sdlas.entities.Storage;
import com.example.sdlas.entities.User;
import com.example.sdlas.model.JournalStorageDto;
import com.example.sdlas.model.StorageType;
import com.example.sdlas.model.UserDto;
import java.text.ParseException;
import java.util.Date;
import org.springframework.stereotype.Component;
import com.example.sdlas.repositories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author 041AlikinOS
 */
@Component
public class JournalStorageMapper {
    
    @Autowired
    private UserRepo userRepo;

    
    public JournalStorage JournalStorageDtoToJournalStorage(JournalStorageDto dto) throws ParseException {
        
        
        User employee;
        User securityEmployee;
        UserDto employeeDto;
        UserDto employeeSecurityDto;
        Storage storage = new Storage();
        JournalStorage journalStorage = new JournalStorage();
       
      

       if(dto.storageType.equals("HDD")) {
           storage.setStorageType(StorageType.HDD);
       } else if(dto.storageType.equals("CARD")){
           storage.setStorageType(StorageType.CARD);
       } else {
           storage.setStorageType(StorageType.USB);
       }
       
       
        if(dto.number != null) {
            storage.setNumber(dto.number);
        } else {
            storage.setNumber("");
        }
        
        if(dto.dateRegistration != null) {
            storage.setDateRegistration(dto.getConvertedDate());
        } else {
            Date dateNow = new Date(System.currentTimeMillis()); 
            storage.setDateRegistration(dateNow);
        }
        
        if(dto.type != null) {
            storage.setType(dto.type);
        } else {
            storage.setType("");
        }
        
        if(dto.tag != null) {
            storage.setTag(dto.tag);
        } else {
            storage.setTag("");
        }
        
        if(dto.manufactureNumber != null) {
            storage.setManufactureNumber(dto.manufactureNumber);
        } else {
            storage.setManufactureNumber("");
        }
        
        if(dto.capacity != null) {
            storage.setCapacity(dto.capacity);
        } else {
            storage.setCapacity("");
        }
        
        if(dto.fromPlace != null) {
            storage.setFromPlace(dto.fromPlace);
        } else {
            storage.setFromPlace("");
        }
        
        if(dto.pcNumber != null) {
            storage.setPcNumber(dto.pcNumber);
        } else {
            storage.setPcNumber("");
        }
        
        
        
        if(dto.comment != null) {
            journalStorage.setComment(dto.comment);
        } else {
            journalStorage.setComment("");
        }
        
        if(dto.employeeFio != null) {
            employeeDto = UserMapper.getUserData(dto.employeeFio);
            if(userRepo.findByEmail(employeeDto.email) != null) {
                employee = userRepo.findByEmail(employeeDto.email);
               
            } else {
                employee = new User();
                employee.setEmail(employeeDto.email);
                employee.setFirstName(employeeDto.firstName);
                employee.setLastName(employeeDto.lastName);
                employee.setFathersName(employeeDto.fathersName);
                employee.setIdZir(employeeDto.id);
            }
            
        } else {
            employee = new User();
            
        }
        
        
            employeeSecurityDto = UserMapper.getEmployeeSecurity();
            if(userRepo.findByEmail(employeeSecurityDto.email) != null) {
                securityEmployee = userRepo.findByEmail(employeeSecurityDto.email);
            } else { // временно 
            securityEmployee = new User();
            securityEmployee.setEmail(employeeSecurityDto.email);
            securityEmployee.setFirstName(employeeSecurityDto.firstName);
            securityEmployee.setLastName(employeeSecurityDto.lastName);
            securityEmployee.setFathersName(employeeSecurityDto.fathersName);
            securityEmployee.setIdZir(employeeSecurityDto.id);
            
        }
            
            
        journalStorage.setStorage(storage);
        journalStorage.setEmployee(employee);
        journalStorage.setSecurityEmployee(securityEmployee);
        journalStorage.setSignEmployee(false);
        journalStorage.setSignToBack(false);
        
        
    return journalStorage;
    }
    
}
