/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.sdlas.controllers;

import com.example.sdlas.services.ZirService;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 * @author 041AlikinOS
 */
@Controller
public class Employee {
    
    @Autowired
    private ZirService zirService;
         
    @GetMapping("/employees")
    public String getEmployee(Model model) {
       Iterable<String> emp = zirService.findAllEmployees();
       model.addAttribute("employee", emp);
        return "employees";
    }
    
}
