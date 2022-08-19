/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.example.sdlas.repositories;

import com.example.sdlas.entities.Hdd;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author 041AlikinOS
 */
@Repository
public interface HddRepo extends CrudRepository<Hdd, Long> {
    
}
