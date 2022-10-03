/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.sdlas.exceptions;

/**
 *
 * @author 041AlikinOS
 */

public class MyException extends RuntimeException {
    
    public MyException(String message) {
        super(message);
        
    } 

    @Override
    public String toString() {
        return "/error";
    }
    
}
// Остановился на разработке ExceptionHandler