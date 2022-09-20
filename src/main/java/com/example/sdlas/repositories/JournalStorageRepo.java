/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.example.sdlas.repositories;

import com.example.sdlas.entities.JournalStorage;
import com.example.sdlas.model.StorageType;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author 041AlikinOS
 */
@Repository
public interface JournalStorageRepo extends JpaRepository<JournalStorage, Long> {
    List<JournalStorage> findByEmployee(String employee);
    List<JournalStorage> findBySecurityEmployee(String securityEmployee);
    List<JournalStorage> findByStorageStorageType(StorageType type);
    List<JournalStorage> findByStorageNumber(String number);
    List<JournalStorage> findByStorageManufactureNumber(String ManufactureNumber);
    List<JournalStorage> findByPcNumber(String pcNumber);
    
}
