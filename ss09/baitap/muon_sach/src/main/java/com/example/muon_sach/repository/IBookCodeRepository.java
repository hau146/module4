package com.example.muon_sach.repository;

import com.example.muon_sach.model.BookCode;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IBookCodeRepository extends JpaRepository<BookCode, Integer> {
}
