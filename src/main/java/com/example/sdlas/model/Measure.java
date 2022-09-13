/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package com.example.sdlas.model;

/**
 *
 * @author 041AlikinOS
 */
public enum Measure {
    
    TERABYTE("Тб"),
    GIGABYTE("Гб"),
    MEGABYTE("Мб"),
    KILOBYTE("Кб");
    
    private final String title;
    
    Measure(String title) {
        this.title = title;
    }
    
    public String getTitle() {
        return title;
    }
    
    
}
