/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.sdlas.controllers;

import com.example.sdlas.entities.Card;
import com.example.sdlas.entities.Hdd;
import com.example.sdlas.entities.JournalPassHandOut;
import com.example.sdlas.entities.Storage;
import com.example.sdlas.entities.Usb;
import com.example.sdlas.mappers.StorageMapper;
import com.example.sdlas.model.StorageDto;
import com.example.sdlas.repositories.CardRepo;
import com.example.sdlas.repositories.HddRepo;
import com.example.sdlas.repositories.JournalPassHandOutRepo;
import com.example.sdlas.repositories.UsbRepo;
import com.example.sdlas.services.StorageService;
import com.example.sdlas.services.ZirService;
import java.text.ParseException;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
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
    private UsbRepo usbRepo;
    @Autowired
    private StorageMapper storageMapper;
    @Autowired
    private ZirService zirService;

    

    @GetMapping("/{storageName}")
    public String ngmd(@PathVariable String storageName, Model model) {
        if(storageName.equals("ngmd")) {
        Iterable<Hdd> hddies = hddRepo.findAll();
        Iterable<String> emp = zirService.findAllEmployees();
       model.addAttribute("employee", emp);
        model.addAttribute("hdd", hddies);        
        model.addAttribute("name", "НЖМД");        
        model.addAttribute("path", "ngmd");        
        } else if(storageName.equals("card")){
         Iterable<Card> cards = cardRepo.findAll();
        Iterable<String> emp = zirService.findAllEmployees();
        model.addAttribute("employee", emp);
        model.addAttribute("card", cards);
        model.addAttribute("name", "ключевой носитель");
        model.addAttribute("path", "card");
        } else {
           Iterable<Usb> usbies = usbRepo.findAll();
        Iterable<String> emp = zirService.findAllEmployees();
        model.addAttribute("employee", emp);
        model.addAttribute("usb", usbies);
        model.addAttribute("name", "USB, CD, DVD");
        model.addAttribute("path", "usb");
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
        Iterable<String> emp = zirService.findAllEmployees();
        model.put("employee", emp);
        model.put("hdd", hddies);  
        model.put("name", "НЖМД");        
        model.put("path", "ngmd");  
        return "/ngmd";
    }
    
    @PostMapping(path = "/usb", consumes = { MediaType.ALL_VALUE})
    public String addUsb(StorageDto dto, Map<String, Object> model) throws ParseException {
        
      // Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
      //  UserInfo userDetails = (UserInfo) authentication.getPrincipal();
      // строки выше для того, чтобы вытаскивать пользователя
        
        Storage storage = storageMapper.StorageDtoToStorage(dto);
        storageService.saveInDb(storage);

        
        
        Iterable<Usb> usbies = usbRepo.findAll();
        Iterable<String> emp = zirService.findAllEmployees();
        model.put("employee", emp);
        model.put("usb", usbies);
        model.put("name", "USB, CD, DVD");
        model.put("path", "usb");
        return "/usb";
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
        Iterable<String> emp = zirService.findAllEmployees();
        model.put("employee", emp);
        model.put("card", cards);
        model.put("name", "ключевой носитель");        
        model.put("path", "card");     
        return "/card";

}
//    
//      @GetMapping("/journalPassHandOut")
//    public String getJournalPassHandOut(Model model) {
//       Iterable<JournalPassHandOut> journals = journalPassHandOutRepo.findAll();
//        model.addAttribute("journal", journals);        
//        return "journalPassHandOut";
//    }
    

    
}

