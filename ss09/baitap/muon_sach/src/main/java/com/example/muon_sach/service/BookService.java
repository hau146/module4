package com.example.muon_sach.service;

import com.example.muon_sach.model.Book;
import com.example.muon_sach.repository.IBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService implements IBookService{
    @Autowired
    private IBookRepository bookRepository;

    @Override
    public List<Book> showList() {
        return bookRepository.findAll();
    }

    @Override
    public Book findById(int id) {
        return bookRepository.findById(id).get();
    }


    @Override
    public boolean save(Book book) {
        try {
            bookRepository.save(book);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

}
