/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.sdlas.entities;

import com.example.sdlas.model.Measure;
import com.example.sdlas.model.StorageType;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
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
    @Column(nullable = false)
    private String number;
    @Column(nullable = false)
    private Date dateRegistration;
    @Column(nullable = false)
    private String type;
    @Column(nullable = false)
    private String tag;
    @Column(nullable = false)
    private String manufactureNumber;
    @Column(nullable = false)
    private String capacity;
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Measure measure;
    @Column(nullable = false)
    private String fromPlace;
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private StorageType storageType;

    public Storage(String number, Date dateRegistration, String type, String tag, String manufactureNumber, String capacity, Measure measure, String fromPlace, StorageType storageType) {
        this.number = number;
        this.dateRegistration = dateRegistration;
        this.type = type;
        this.tag = tag;
        this.manufactureNumber = manufactureNumber;
        this.capacity = capacity;
        this.measure = measure;
        this.fromPlace = fromPlace;
        this.storageType = storageType;
    }

   

    


 
    
    
}
