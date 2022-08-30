/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.sdlas.mappers;

import com.example.sdlas.entities.Card;
import com.example.sdlas.entities.Hdd;
import com.example.sdlas.entities.Storage;
import com.example.sdlas.entities.Usb;
import com.example.sdlas.entities.User;
import com.example.sdlas.model.StorageDto;
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
public class StorageMapper {
    
    @Autowired
    private UserRepo userRepo;
    
    public Storage StorageDtoToStorage(StorageDto dto) throws ParseException {
        
        Storage storage;
       // писать if
       
      

       if(dto.name.equals("ngmd")) {
           storage = new Hdd();
       } else if(dto.name.equals("card")){
           storage = new Card();
       } else {
           storage = new Usb();
       }
       
       
        if(dto.number != null) {
            storage.setNumber(dto.number);
        } else {
            storage.setNumber("отсутствует");
        }
        
        if(dto.dateRegistration != null) {
            storage.setDateRegistration(dto.getConvertedDate());
        } else {
            Date dateNow = new Date(System.currentTimeMillis()); 
            storage.setDateRegistration(dateNow);
        }
        
        if(dto.type != null) {
            storage.setType(dto.type);
        }
        
        if(dto.tag != null) {
            storage.setTag(dto.tag);
        }
        
        if(dto.manufactureNumber != null) {
            storage.setManufactureNumber(dto.manufactureNumber);
        }
        
        if(dto.capacity != null) {
            storage.setCapacity(dto.capacity);
        } else {
            storage.setCapacity("отсутствует");
        }
        
        if(dto.fromPlace != null) {
            storage.setFromPlace(dto.fromPlace);
        }
        
        if(dto.pcNumber != null) {
            storage.setPcNumber(dto.pcNumber);
        } else {
            storage.setPcNumber("отсутствует");
        }
        
        if(dto.registrationEndSign != null) {
            storage.setRegistrationEndSign(dto.registrationEndSign);
        }
        if(dto.comment != null) {
            storage.setComment(dto.comment);
        } else {
            storage.setComment("отсутствует");
        }
        
        if(dto.user != null) {
            UserDto userDto = UserMapper.getUserData(dto.user);
            if(userRepo.findByEmail(userDto.email) != null) {
                User user = userRepo.findByEmail(userDto.email);
                storage.setUser(user);
            } else {
                User newUser = new User();
                newUser.setEmail(userDto.email);
                newUser.setLastName(userDto.lastName);
                newUser.setFathersName(userDto.fathersName);
                newUser.setEmail(userDto.email);
                storage.setUser(newUser);
            }
            
        } else {
            User newUser = new User();
            storage.setUser(newUser);
        }
        
        storage.setSignEmployee(false);
        storage.setSignToBack(false);
        
        
    return storage;
    }
    
}
