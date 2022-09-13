/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.sdlas.services;

import com.example.sdlas.entities.JournalStorage;
import com.example.sdlas.mappers.JournalStorageMapper;
import com.example.sdlas.model.JournalStorageDto;
import com.example.sdlas.model.StorageType;
import com.example.sdlas.repositories.JournalStorageRepo;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author 041AlikinOS
 */
@Component
public class JournalStorageService {

    @Autowired
    private JournalStorageMapper journalStorageMapper;
    
    @Autowired
    private JournalStorageRepo journalStorageRepo;
    
    @Autowired
    private SendMailService sendMailService;

    public List<JournalStorageDto> listDto(List<JournalStorage> listJournalStorage) {

        List<JournalStorageDto> list = new ArrayList<>();
        for (JournalStorage journal : listJournalStorage) {
            JournalStorageDto dto = journalStorageMapper.JournalStorageToJournalStorageDto(journal);
            list.add(dto);
        }
        return list;
    }
    
       public void deleteJournal(Long id) {
        
               journalStorageRepo.deleteById(id);
           
    }
       
       public void editJournalStorage(JournalStorageDto dto) throws ParseException {
        JournalStorage journalStorage = journalStorageRepo.findById(dto.id).get();
        journalStorage.getStorage().setNumber(dto.number);
        journalStorage.getStorage().setDateRegistration(dto.getConvertedDate());
        journalStorage.getStorage().setType(dto.type);
        if(dto.storageType.equals("HDD")) {
            journalStorage.getStorage().setStorageType(StorageType.HDD);
        } else if(dto.storageType.equals("CARD")) {
            journalStorage.getStorage().setStorageType(StorageType.CARD);
        } else {
            journalStorage.getStorage().setStorageType(StorageType.USB);
        }
        journalStorage.getStorage().setTag(dto.tag);
        journalStorage.getStorage().setFromPlace(dto.fromPlace);
        journalStorage.getStorage().setManufactureNumber(dto.manufactureNumber);
        journalStorage.getStorage().setCapacity(dto.capacity);
        journalStorage.setPcNumber(dto.pcNumber);
        journalStorage.setComment(dto.comment);
        journalStorage.setEmployee(dto.employee);
        journalStorage.setSecurityEmployee(dto.employeeSecurity);
        sendMailService.sendMail(journalStorage);
        journalStorageRepo.save(journalStorage);
        
        
       }

}
