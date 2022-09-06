/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.sdlas.controllers;

import com.example.sdlas.entities.JournalStorage;
import com.example.sdlas.entities.User;
import com.example.sdlas.mappers.JournalStorageMapper;
import com.example.sdlas.model.SignDto;
import com.example.sdlas.model.JournalStorageDto;
import com.example.sdlas.model.StorageType;
import com.example.sdlas.repositories.JournalStorageRepo;
import com.example.sdlas.repositories.UserRepo;
import com.example.sdlas.services.RequestService;
import com.example.sdlas.services.SendMailService;
import com.example.sdlas.services.SignStorageService;
import com.example.sdlas.services.ZirService;
import java.text.ParseException;
import java.util.Map;
import org.opfr.springbootstarterauthsso.security.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
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
    private JournalStorageRepo journalStorageRepo;
    @Autowired
    private JournalStorageMapper storageMapper;
    @Autowired
    private ZirService zirService;
    @Autowired
    private SendMailService sendMailService;
    @Autowired
    private UserRepo userRepo;
    @Autowired
    private RequestService requestService;
    @Autowired
    private SignStorageService signStorageService;

   

    

    @GetMapping("/{storageName}")
    public String ngmd(@PathVariable String storageName, Model model) {
        if(storageName.equals("ngmd")) {              
        model.addAttribute("storageType", "HDD");        
        model.addAttribute("name", "НЖМД");        
        model.addAttribute("path", "ngmd");
        Iterable<JournalStorage> journalsStorage = journalStorageRepo.findByStorageStorageType(StorageType.HDD); 
        model.addAttribute("journalStorage", journalsStorage); 
        } else if(storageName.equals("card")){
        model.addAttribute("storageType", "CARD"); 
        model.addAttribute("name", "ключевой носитель");
        model.addAttribute("path", "card");
        Iterable<JournalStorage> journalsStorage = journalStorageRepo.findByStorageStorageType(StorageType.CARD);
        model.addAttribute("journalStorage", journalsStorage); 
        } else {
        model.addAttribute("storageType", "USB"); 
        model.addAttribute("name", "USB, CD, DVD");
        model.addAttribute("path", "usb");
        Iterable<JournalStorage> journalsStorage = journalStorageRepo.findByStorageStorageType(StorageType.USB);
        model.addAttribute("journalStorage", journalsStorage); 
        }
        Iterable<String> emp = zirService.findAllEmployees();
        
        model.addAttribute("employee", emp);
        return storageName;
    }

    @PostMapping(path = "/ngmd", consumes = { MediaType.ALL_VALUE})
    public String addHdd(JournalStorageDto dto, Map<String, Object> model) throws ParseException {
        
      // Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
      //  UserInfo userDetails = (UserInfo) authentication.getPrincipal();
      // строки выше для того, чтобы вытаскивать пользователя
        
        JournalStorage journalStorage = storageMapper.JournalStorageDtoToJournalStorage(dto);
        
        journalStorageRepo.save(journalStorage);
        sendMailService.sendMail(journalStorage);

        
        
        Iterable<JournalStorage> journalsStorage = journalStorageRepo.findByStorageStorageType(StorageType.HDD); 
        Iterable<String> emp = zirService.findAllEmployees();
        model.put("employee", emp);
        model.put("journalStorage", journalsStorage);  
        model.put("name", "НЖМД");        
        model.put("path", "ngmd");  
        model.put("storageType", "HDD");  
        return "/ngmd";
    }
    
    @PostMapping(path = "/usb", consumes = { MediaType.ALL_VALUE})
    public String addUsb(JournalStorageDto dto, Map<String, Object> model) throws ParseException {
        
      // Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
      //  UserInfo userDetails = (UserInfo) authentication.getPrincipal();
      // строки выше для того, чтобы вытаскивать пользователя
        
        JournalStorage journalStorage = storageMapper.JournalStorageDtoToJournalStorage(dto);
        journalStorageRepo.save(journalStorage);

        
        
        Iterable<JournalStorage> journalsStorage = journalStorageRepo.findByStorageStorageType(StorageType.USB);
        Iterable<String> emp = zirService.findAllEmployees();
        model.put("employee", emp);
        model.put("journalStorage", journalsStorage);
        model.put("name", "USB, CD, DVD");
        model.put("path", "usb");
        model.put("storageType", "USB");  
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
    public String addKey(JournalStorageDto dto, Map<String, Object> model) throws ParseException {
        
       // Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
      //  UserInfo userDetails = (UserInfo) authentication.getPrincipal();
      // строки выше для того, чтобы вытаскивать пользователя
        
        JournalStorage journalStorage = storageMapper.JournalStorageDtoToJournalStorage(dto);
        journalStorageRepo.save(journalStorage);
        

        Iterable<JournalStorage> journalsStorage = journalStorageRepo.findByStorageStorageType(StorageType.CARD);
        Iterable<String> emp = zirService.findAllEmployees();
        model.put("employee", emp);
        model.put("journalStorage", journalsStorage);
        model.put("name", "ключевой носитель");        
        model.put("path", "card");     
        model.put("storageType", "CARD");  
        return "/card";

}
    @GetMapping("/myaccount")
    public String getData(Model model) {
        
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserInfo userDetails = (UserInfo) authentication.getPrincipal();
        String notParseId = userDetails.getUserCode();
        int id = Integer.parseInt(notParseId);
        String emailUser = zirService.getEmailUserById(id);
        User user = userRepo.findByEmail(emailUser);
        Iterable <JournalStorage> journalsStorage = requestService.getAllDevices(user);
        model.addAttribute("journalStorage", journalsStorage);
        return "account";
    }
    
     @PostMapping("/myaccount")
     public String putSign(SignDto dto, Model model) {
        model.addAttribute("dto", dto);
        signStorageService.signEmpoyeeForStorage(dto);
        
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserInfo userDetails = (UserInfo) authentication.getPrincipal();
        String notParseId = userDetails.getUserCode();
        int id = Integer.parseInt(notParseId);
        String emailUser = zirService.getEmailUserById(id);
        User user = userRepo.findByEmail(emailUser);
        Iterable <JournalStorage> journalsStorage = requestService.getAllDevices(user);
        model.addAttribute("journalStorage", journalsStorage);
        
        return "account";
    }
//    
//      @GetMapping("/journalPassHandOut")
//    public String getJournalPassHandOut(Model model) {
//       Iterable<JournalPassHandOut> journals = journalPassHandOutRepo.findAll();
//        model.addAttribute("journal", journals);        
//        return "journalPassHandOut";
//    }
    

     @PostMapping("/sign")
     public String putSignSecurityWorker(SignDto signDto, Model model) {
        model.addAttribute("dto", signDto);
        signStorageService.signSecurityWorker(signDto);
        return "redirect:/ngmd";
     }
    
}

