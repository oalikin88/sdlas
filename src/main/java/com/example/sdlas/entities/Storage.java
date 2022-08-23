/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.sdlas.entities;

import java.util.Date;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author 041AlikinOS
 */
@Getter
@Setter
@NoArgsConstructor
@MappedSuperclass
public abstract class Storage {

    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String number;
    private Date dateRegistration;
    private String type;
    private String tag;
    private String manufactureNumber;
    private String capacity;
    private String fromPlace;
    private String pcNumber;
    private boolean signEmployee;
    private boolean signToBack;
    private String registrationEndSign;
    private String comment;

    public Storage(String number, Date dateRegistration, String type, String tag, String manufactureNumber, String capacity, String fromPlace, String pcNumber, boolean signEmployee, boolean signToBack, String registrationEndSign, String comment) {
        this.number = number;
        this.dateRegistration = dateRegistration;
        this.type = type;
        this.tag = tag;
        this.manufactureNumber = manufactureNumber;
        this.capacity = capacity;
        this.fromPlace = fromPlace;
        this.pcNumber = pcNumber;
        this.signEmployee = signEmployee;
        this.signToBack = signToBack;
        this.registrationEndSign = registrationEndSign;
        this.comment = comment;
    }
        
    
}
