package com.example.baitap2.service;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class DictionaryService {
    public String vocabularyConversion(String english){
        Map<String,String> stringMap = new HashMap<>();
        stringMap.put("dog","chó");
        stringMap.put("cat","mèo");
        stringMap.put("pig","heo");
        for (Map.Entry<String,String> entry : stringMap.entrySet()){
            if (entry.getKey().toLowerCase().equals(english.toLowerCase())){
                return entry.getValue();
            }
        }
        return null;
    }
}
