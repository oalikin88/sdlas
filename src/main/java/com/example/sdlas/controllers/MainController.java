/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.sdlas.controllers;

import com.example.sdlas.entities.Card;
import com.example.sdlas.entities.Hdd;
import com.example.sdlas.entities.Storage;
import com.example.sdlas.mappers.StorageMapper;
import com.example.sdlas.model.StorageDto;
import com.example.sdlas.repositories.CardRepo;
import com.example.sdlas.repositories.HddRepo;
import com.example.sdlas.services.StorageService;
import java.text.ParseException;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

/**
 *
 * @author 041AlikinOS
 */
@Controller
public class MainController {

    @Autowired
    private HddRepo hddRepo;
    @Autowired
    private CardRepo cardRepo;
    @Autowired
    private StorageService storageService;
    
    @Autowired
    private StorageMapper storageMapper;
    
    

    @GetMapping("/{storageName}")
    public String ngmd(@PathVariable String storageName, Model model) {
        if(storageName.equals("ngmd")) {
        Iterable<Hdd> hddies = hddRepo.findAll();
        model.addAttribute("hdd", hddies);
        } else {
         Iterable<Card> cards = cardRepo.findAll();
        model.addAttribute("card", cards);
        }
        return storageName;
    }

    @PostMapping(path = "/ngmd", consumes = { MediaType.ALL_VALUE})
    public String addHdd(StorageDto dto, Map<String, Object> model) throws ParseException {
        
       // Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
      //  UserInfo userDetails = (UserInfo) authentication.getPrincipal();
      // строки выше для того, чтобы вытаскивать пользователя
        
        Storage storage = storageMapper.StorageDtoToStorage(dto);

        

        storageService.saveInDb(storage);

        Iterable<Hdd> hddies = hddRepo.findAll();
        model.put("hdd", hddies);
        return "ngmd";
    }
    
    @GetMapping("/main")
    public String main() {
        return "main";
    }
    
//    @GetMapping("/card")
//    public String key(Model model) {
//        Iterable<Card> cards = cardRepo.findAll();
//        model.addAttribute("card", cards);
//        return "card";
//    }
    
    @PostMapping(path = "/card", consumes = { MediaType.ALL_VALUE})
    public String addKey(StorageDto dto, Map<String, Object> model) throws ParseException {
        
       // Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
      //  UserInfo userDetails = (UserInfo) authentication.getPrincipal();
      // строки выше для того, чтобы вытаскивать пользователя
        
        Storage storage = storageMapper.StorageDtoToStorage(dto);

        

        storageService.saveInDb(storage);

        Iterable<Card> cards = cardRepo.findAll();
        model.put("card", cards);
        return "card";

}
}
