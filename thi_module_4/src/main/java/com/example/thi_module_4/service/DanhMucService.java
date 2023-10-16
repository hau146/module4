package com.example.thi_module_4.service;

import com.example.thi_module_4.model.DanhMuc;
import com.example.thi_module_4.repository.IDanhMucRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DanhMucService implements IDanhMucService{
    @Autowired
    private IDanhMucRepository danhMucRepository;
    @Override
    public List<DanhMuc> findAll() {
        return danhMucRepository.findAll();
    }
}
