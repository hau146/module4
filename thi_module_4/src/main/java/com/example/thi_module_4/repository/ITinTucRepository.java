package com.example.thi_module_4.repository;

import com.example.thi_module_4.model.TinTuc;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ITinTucRepository extends JpaRepository<TinTuc, Integer> {
    Page<TinTuc> findAllByTieuDeContaining(Pageable pageable, String tieuDe);
}
