/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.sdlas.entities;

import java.io.Serializable;
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
public class Card extends Storage implements Serializable {
    
   

    public Card(Long number, Date dateRegistration, String type, String tag, String manufactureNumber, int capacity, String fromPlace, Long pcNumber, boolean signEmployee, boolean signToBack, String registrationEndSign, String comment) {
        super(number, dateRegistration, type, tag, manufactureNumber, capacity, fromPlace, pcNumber, signEmployee, signToBack, registrationEndSign, comment);
    }

  
  
    
    
}
