/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.sdlas.mappers;

import com.example.sdlas.entities.JournalStorage;
import com.example.sdlas.entities.Storage;
import com.example.sdlas.model.JournalStorageDto;
import com.example.sdlas.model.StorageType;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.opfr.springBootStarterDictionary.clientImpl.EmployeeClient;
import org.opfr.springBootStarterDictionary.models.DictionaryEmployee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author 041AlikinOS
 */
@Component
public class JournalStorageMapper {
    
    @Autowired
    private EmployeeClient employeeClient;
    
    

    
    public JournalStorage JournalStorageDtoToJournalStorage(JournalStorageDto dto) throws ParseException {
        

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
           String s = dto.capacity.replace(',', ' ');
            storage.setCapacity(s);
        } else {
            storage.setCapacity("");
        }
        
        if(dto.fromPlace != null) {
            storage.setFromPlace(dto.fromPlace);
        } else {
            storage.setFromPlace("");
        }
        
        if(dto.pcNumber != null) {
            journalStorage.setPcNumber(dto.pcNumber);
        } else {
            journalStorage.setPcNumber("");
        }
        
        
        
        if(dto.comment != null) {
            journalStorage.setComment(dto.comment);
        } else {
            journalStorage.setComment("");
        }
        
        if(dto.employee != null) {
           journalStorage.setEmployee(dto.employee);
               
            } else {
                journalStorage.setEmployee("Пользователь не найден");
            }
            
        if(dto.employeeSecurity != null) {
            journalStorage.setSecurityEmployee(dto.employeeSecurity);
        } else {
            journalStorage.setSecurityEmployee("Пользователь не найден");
        }
              
            
        journalStorage.setStorage(storage);
        journalStorage.setSignEmployee(false);
        journalStorage.setSignToBack(false);
        
        
    return journalStorage;
    }
    
    public JournalStorageDto JournalStorageToJournalStorageDto(JournalStorage journalStorage) {
        JournalStorageDto dto = new JournalStorageDto();
        DictionaryEmployee employeeByCode = employeeClient.getEmployeeByCode(journalStorage.getEmployee());
        DictionaryEmployee employeeSecurityByCode = employeeClient.getEmployeeByCode(journalStorage.getSecurityEmployee());
        SimpleDateFormat date = new SimpleDateFormat("dd.MM.yyyy");
        dto.number = journalStorage.getStorage().getNumber();
        dto.capacity = journalStorage.getStorage().getCapacity();
        if(journalStorage.getStorage().getDateRegistration() != null) {
            Date dateRegistration = journalStorage.getStorage().getDateRegistration();
            dto.dateRegistration = date.format(dateRegistration);
        } else {
            dto.dateRegistration = "";
        }
        dto.id = journalStorage.getId();
        dto.employee = employeeByCode.getSurname() + " " + employeeByCode.getName().substring(0, 1) + ". " + employeeByCode.getMiddlename().substring(0, 1) + ".";
        dto.employeeSecurity = employeeSecurityByCode.getSurname() + " " + employeeSecurityByCode.getName().substring(0, 1) + ". " + employeeSecurityByCode.getMiddlename().substring(0, 1) + ".";
        dto.fromPlace = journalStorage.getStorage().getFromPlace();
        dto.manufactureNumber = journalStorage.getStorage().getManufactureNumber();
        dto.pcNumber = journalStorage.getPcNumber();
        dto.storageType = journalStorage.getStorage().getStorageType().toString();
        dto.tag = journalStorage.getStorage().getTag();
        dto.type = journalStorage.getStorage().getType();
        dto.signEmployee = journalStorage.isSignEmployee();
        dto.signToBack = journalStorage.isSignToBack();
        dto.comment = journalStorage.getComment();
        dto.RegistrationEndSign = journalStorage.getRegistrationEndSign();
        if(journalStorage.getGetBackToSecurityUser() != null) {
            
           Date dateGetBack = journalStorage.getGetBackToSecurityUser();
           
           dto.getBackToSecurityUser = date.format(dateGetBack);
        } else {
            dto.getBackToSecurityUser = "";
        }
        
        if(journalStorage.getDateSignEmployee() != null) {
            Date signEmployeeDate = journalStorage.getDateSignEmployee();
            dto.dateSignEmployee = date.format(signEmployeeDate);
        } else {
            dto.dateSignEmployee = "";
        }
        
        dto.storageType = journalStorage.getStorage().getStorageType().toString();
      
        
        
        return dto;
    }
    
}
