/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.sdlas.services;

import com.example.sdlas.entities.Card;
import com.example.sdlas.entities.Hdd;
import com.example.sdlas.entities.Storage;
import com.example.sdlas.repositories.CardRepo;
import com.example.sdlas.repositories.HddRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author 041AlikinOS
 */
@Component
public class StorageService {
    
    @Autowired
    private HddRepo hddRepo;
    @Autowired
    private CardRepo cardRepo;
  
    public void saveInDb(Storage storage) {
    
        if(storage instanceof Hdd) {
            
            hddRepo.save((Hdd)storage);
            
        } else if(storage instanceof Card) {
            cardRepo.save((Card)storage);
        }
        
    }
    
}
