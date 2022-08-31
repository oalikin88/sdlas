/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.sdlas.services;

import com.example.sdlas.entities.Hdd;
import com.example.sdlas.entities.User;
import com.example.sdlas.repositories.HddRepo;
import com.example.sdlas.repositories.UserRepo;
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
   private HddRepo hddRepo;
   
   
    public List<Hdd> getAllDevices(User user) {
        int id = user.getIdZir();
        
        
        return hddRepo.findHddByUserIdZir(id);
    }
    
}
