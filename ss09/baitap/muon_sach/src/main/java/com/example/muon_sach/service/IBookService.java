package com.example.muon_sach.service;

import com.example.muon_sach.model.Book;

import java.util.List;

public interface IBookService {
    List<Book> showList();
    Book findById(int id);

    boolean save(Book book);
}
