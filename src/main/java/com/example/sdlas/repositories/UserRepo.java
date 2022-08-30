/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.example.sdlas.repositories;

import com.example.sdlas.entities.User;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author 041AlikinOS
 */
public interface UserRepo extends CrudRepository<User, Long> {
    public User findByEmail(String email);
}
