/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.sdlas.services;

import com.example.sdlas.entities.JournalStorage;
import com.example.sdlas.model.CommentDto;
import com.example.sdlas.repositories.JournalStorageRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author 041AlikinOS
 */
@Component
public class EditCommentService {
    
    @Autowired
    private JournalStorageRepo journalStorageRepo;
    
    public void editComment(CommentDto dto) {
        
        JournalStorage journalStorage = journalStorageRepo.getById(dto.id);
        journalStorage.setComment(dto.comment);
        journalStorageRepo.save(journalStorage);
        
    }
    
}
