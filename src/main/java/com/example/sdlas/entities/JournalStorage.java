/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.sdlas.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
public class JournalStorage implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Id;
    private Date dateSignEmployee;
    private Date getBackToSecurityUser;
    private String employee;
    private String securityEmployee;
    @ManyToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "storage_id")
    private Storage storage;
    private boolean signEmployee;
    private boolean signToBack;
    private String RegistrationEndSign;
    private String comment;
    private String pcNumber;

    public JournalStorage(Date dateSignEmployee, Date getBackToSecurityUser, String employee, String securityEmployee, Storage storage, boolean signEmployee, boolean signToBack, String RegistrationEndSign, String comment, String pcNumber) {
        this.dateSignEmployee = dateSignEmployee;
        this.getBackToSecurityUser = getBackToSecurityUser;
        this.employee = employee;
        this.securityEmployee = securityEmployee;
        this.storage = storage;
        this.signEmployee = signEmployee;
        this.signToBack = signToBack;
        this.RegistrationEndSign = RegistrationEndSign;
        this.comment = comment;
        this.pcNumber = pcNumber;
    }




    
    
    
}
