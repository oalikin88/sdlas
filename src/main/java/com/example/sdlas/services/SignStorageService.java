/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.sdlas.services;

import com.example.sdlas.entities.Hdd;
import com.example.sdlas.model.SignDto;
import com.example.sdlas.repositories.HddRepo;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author 041AlikinOS
 */
@Service
public class SignStorageService {
    
    @Autowired
    private HddRepo hddRepo;
    
    
    public void signEmpoyeeForStorage(SignDto dto) {
        
        Hdd hdd = hddRepo.findById(dto.Id).get();
        hdd.setSignEmployee(true);
        hdd.setDateSign(new Date());
        
        
        hddRepo.save(hdd);
    }
}
