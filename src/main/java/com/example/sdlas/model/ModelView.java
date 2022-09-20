/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.sdlas.model;

import java.util.HashMap;
import java.util.Map;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

/**
 *
 * @author 041AlikinOS
 */
@Component
@Getter
@Setter
@NoArgsConstructor
public class ModelView {

    private String title;
    private String name;
    private String path;
    private StorageType storageType;

    public ModelView(String title, String name, String path, StorageType storageType) {
        this.title = title;
        this.name = name;
        this.path = path;
        this.storageType = storageType;
   
    }
   
   public ModelView getView(String target) {
       Map<String, ModelView> map = new HashMap<>();
       map.put("ngmd", new ModelView("Журнал учёта НЖМД", "НЖМД", "ngmd", StorageType.HDD));
       map.put("card", new ModelView("Журнал учёта ключевых носителей", "ключевой носитель", "card", StorageType.CARD));
       map.put("usb", new ModelView("Журнал учёта USB, CD и DVD", "USB, CD, DVD", "usb", StorageType.USB));
       map.put("search", new ModelView("Поиск по записям", "Поиск", "search", StorageType.HDD));
       ModelView model = map.get(target);
       return model;
   }
    

    }
    