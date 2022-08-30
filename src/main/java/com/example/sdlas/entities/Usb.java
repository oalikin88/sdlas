/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.sdlas.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
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
public class Usb extends Storage implements Serializable {

    public Usb(String number, Date dateRegistration, String type, String tag, String manufactureNumber, String capacity, String fromPlace, String pcNumber, boolean signEmployee, User user, Date dateSign, boolean signToBack, String registrationEndSign, String comment) {
        super(number, dateRegistration, type, tag, manufactureNumber, capacity, fromPlace, pcNumber, signEmployee, user, dateSign, signToBack, registrationEndSign, comment);
    }


    
    
    
}
