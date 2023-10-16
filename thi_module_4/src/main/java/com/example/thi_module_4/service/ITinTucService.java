package com.example.thi_module_4.service;

import com.example.thi_module_4.model.TinTuc;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ITinTucService {
    Page<TinTuc> findAll(Pageable pageable, String tieuDe);
    boolean save(TinTuc tinTuc);
    TinTuc findById(int id);
    boolean delete(TinTuc tinTuc);
}
