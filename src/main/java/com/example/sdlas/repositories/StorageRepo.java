/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.example.sdlas.repositories;

import com.example.sdlas.entities.Storage;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author 041AlikinOS
 */
public interface StorageRepo extends JpaRepository<Storage, Long> {
   
}
