/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.sdlas.model;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


/**
 *
 * @author 041AlikinOS
 */
@Entity
public class JournalHdd {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Long number;
    private Date date;
    private String type;
    private String tag;
    private String manufactureNumber;
    private int capacity;
    private String fromPlace;
    private Long pcNumber;
    private int n2;
    private boolean signEmployee;
    private boolean signToBack;
    private String registrationEndSign;
    private String comment;
    
    public JournalHdd() {
    
    }

    public JournalHdd(Long number, Date date, String type, String tag, String manufactureNumber, int capacity, String fromPlace, Long pcNumber, int n2, boolean signEmployee, boolean signToBack, String registrationEndSign, String comment) {
        this.number = number;
        this.date = date;
        this.type = type;
        this.tag = tag;
        this.manufactureNumber = manufactureNumber;
        this.capacity = capacity;
        this.fromPlace = fromPlace;
        this.pcNumber = pcNumber;
        this.n2 = n2;
        this.signEmployee = signEmployee;
        this.signToBack = signToBack;
        this.registrationEndSign = registrationEndSign;
        this.comment = comment;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getNumber() {
        return number;
    }

    public void setNumber(Long number) {
        this.number = number;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getManufactureNumber() {
        return manufactureNumber;
    }

    public void setManufactureNumber(String manufactureNumber) {
        this.manufactureNumber = manufactureNumber;
    }

    public String getFromPlace() {
        return fromPlace;
    }

    public void setFromPlace(String fromPlace) {
        this.fromPlace = fromPlace;
    }

    public Long getPcNumber() {
        return pcNumber;
    }

    public void setPcNumber(Long pcNumber) {
        this.pcNumber = pcNumber;
    }

    public int getN2() {
        return n2;
    }

    public void setN2(int n2) {
        this.n2 = n2;
    }

    public boolean isSignEmployee() {
        return signEmployee;
    }

    public void setSignEmployee(boolean signEmployee) {
        this.signEmployee = signEmployee;
    }

    public boolean isSignToBack() {
        return signToBack;
    }

    public void setSignToBack(boolean signToBack) {
        this.signToBack = signToBack;
    }

    public String getRegistrationEndSign() {
        return registrationEndSign;
    }

    public void setRegistrationEndSign(String registrationEndSign) {
        this.registrationEndSign = registrationEndSign;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
    
    
    
    
    
    
    
}
