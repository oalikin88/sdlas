/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.sdlas.services;

import com.example.sdlas.entities.JournalStorage;
import com.example.sdlas.exceptions.MyException;
import com.example.sdlas.mappers.JournalStorageMapper;
import com.example.sdlas.model.JournalStorageDto;
import com.example.sdlas.model.Measure;
import com.example.sdlas.model.StorageType;
import com.example.sdlas.repositories.JournalStorageRepo;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
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
    
     private final Date dateNow = JournalStorageService.removeTime(new Date(System.currentTimeMillis()));
     private final String pastDate = "2000-01-01";

    public List<JournalStorageDto> listDto(List<JournalStorage> listJournalStorage) {

        List<JournalStorageDto> list = new ArrayList<>();
        for (JournalStorage journal : listJournalStorage) {
            JournalStorageDto dto = journalStorageMapper.JournalStorageToJournalStorageDto(journal, "dd.MM.yyyy");
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
        Date inputDate = JournalStorageService.getDate(dto.dateRegistration);
        Date valueDate = JournalStorageService.removeTime(inputDate);
        
        if(valueDate.after(dateNow)) {
            throw new MyException("Невозможно установить дату позже сегодняшнего дня");
        }
        if(valueDate.before(JournalStorageService.getDate(pastDate))) {
            throw new MyException("Невозможно установить выбранную дату");
        }
        journalStorage.getStorage().setDateRegistration(valueDate);
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
        if(dto.measure != null) {
            if(dto.measure.equals("Тб")) {
                journalStorage.getStorage().setMeasure(Measure.TERABYTE);
            } else if(dto.measure.equals("Гб")) {
                journalStorage.getStorage().setMeasure(Measure.GIGABYTE);
            } else if(dto.measure.equals("Мб")) {
                journalStorage.getStorage().setMeasure(Measure.MEGABYTE);
            } else {
                journalStorage.getStorage().setMeasure(Measure.KILOBYTE);
            }
            
        } else {
            journalStorage.getStorage().setMeasure(Measure.MEGABYTE);
        }
        if(!dto.capacity.matches("\\d+")) {
                 throw new MyException("Недопустимое значение");            
            } 
        journalStorage.getStorage().setCapacity(dto.capacity);
        journalStorage.setPcNumber(dto.pcNumber);
        journalStorage.setComment(dto.comment);
        journalStorage.setEmployee(dto.employee);
        journalStorage.setSecurityEmployee(dto.employeeSecurity);
        sendMailService.sendMail(journalStorage);
        journalStorageRepo.save(journalStorage);
        
        
       }
       
       public static Date getDate(String date) throws ParseException {
           SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
           Date curentDate = dateFormat.parse(date);
           return curentDate;
       }

        public static Date removeTime(Date date) {    
            Calendar cal = Calendar.getInstance();  
            cal.setTime(date);  
            cal.set(Calendar.HOUR_OF_DAY, 0);  
            cal.set(Calendar.MINUTE, 0);  
            cal.set(Calendar.SECOND, 0);  
            cal.set(Calendar.MILLISECOND, 0);  
            return cal.getTime(); 

}
        
}