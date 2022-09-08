/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.sdlas.services;

import com.example.sdlas.entities.JournalStorage;
import com.example.sdlas.mappers.JournalStorageMapper;
import com.example.sdlas.model.JournalStorageDto;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author 041AlikinOS
 */
@Component
public class JournalStorageService {

    @Autowired
    private JournalStorageMapper journalStorageMapper;

    public List<JournalStorageDto> listDto(List<JournalStorage> listJournalStorage) {

        List<JournalStorageDto> list = new ArrayList<>();
        for (JournalStorage journal : listJournalStorage) {
            JournalStorageDto dto = journalStorageMapper.JournalStorageToJournalStorageDto(journal);
            list.add(dto);
        }
        return list;
    }

}
