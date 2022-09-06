/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.sdlas.entities;

import com.example.sdlas.model.StorageType;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author 041AlikinOS
 */
@Entity
@Getter
@Setter
@NoArgsConstructor
public class Storage {

    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String number;
    private Date dateRegistration;
    private String type;
    private String tag;
    private String manufactureNumber;
    private String capacity;
    private String fromPlace;
    private String pcNumber;
    private StorageType storageType;

    public Storage(String number, Date dateRegistration, String type, String tag, String manufactureNumber, String capacity, String fromPlace, String pcNumber, StorageType storageType) {
        this.number = number;
        this.dateRegistration = dateRegistration;
        this.type = type;
        this.tag = tag;
        this.manufactureNumber = manufactureNumber;
        this.capacity = capacity;
        this.fromPlace = fromPlace;
        this.pcNumber = pcNumber;
        this.storageType = storageType;
    }
 
    
    
}
