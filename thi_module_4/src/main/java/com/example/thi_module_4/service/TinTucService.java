package com.example.thi_module_4.service;

import com.example.thi_module_4.model.TinTuc;
import com.example.thi_module_4.repository.ITinTucRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TinTucService implements ITinTucService{
    @Autowired
    private ITinTucRepository tinTucRepository;
    @Override
    public Page<TinTuc> findAll(Pageable pageable, String tieuDe) {
        return tinTucRepository.findAllByTieuDeContaining(pageable, tieuDe);
    }

    @Override
    public boolean save(TinTuc tinTuc) {
        try {
            tinTucRepository.save(tinTuc);
        } catch (Exception e){
            return false;
        }
        return true;
    }

    @Override
    public TinTuc findById(int id) {
        return tinTucRepository.findById(id).get();
    }

    @Override
    public boolean delete(TinTuc tinTuc) {
        try {
            tinTucRepository.delete(tinTuc);
        } catch (Exception e){
            return false;
        }
        return true;
    }
}
