/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.example.sdlas.interfaces;

import com.example.sdlas.entities.Hdd;
import com.example.sdlas.model.StorageDto;

/**
 *
 * @author 041AlikinOS
 */
public interface HddInterface {
    Hdd dtoToHdd(StorageDto dto);
    
}
