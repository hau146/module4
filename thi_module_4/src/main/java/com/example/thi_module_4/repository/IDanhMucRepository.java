package com.example.thi_module_4.repository;

import com.example.thi_module_4.model.DanhMuc;
import com.example.thi_module_4.model.TinTuc;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IDanhMucRepository extends JpaRepository<DanhMuc, Integer> {
}
