package com.example.muon_sach.service;

import com.example.muon_sach.model.Book;
import com.example.muon_sach.model.BookCode;

import java.util.List;

public interface IBookCodeService {

    void saveRandomNumber(int randomNumber, Book book);
    List<BookCode> findAll();
    boolean deleteCodeBook(int id);
    BookCode findByCode(int codeBook);

}
