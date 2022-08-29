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
public class JournalPassHandOut implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String fioEmployee;
    private String doc;
    private Date handOut;
    private Date getBack;
    private String fioSecure;
    private boolean employeeSign;
    private boolean secureSign;

    public JournalPassHandOut(String fioEmployee, String doc, Date handOut, Date getBack, String fioSecure, boolean employeeSign, boolean secureSign) {
        this.fioEmployee = fioEmployee;
        this.doc = doc;
        this.handOut = handOut;
        this.getBack = getBack;
        this.fioSecure = fioSecure;
        this.employeeSign = employeeSign;
        this.secureSign = secureSign;
    }
    
    
    
}
