package com.example.muon_sach.service;

import com.example.muon_sach.model.Book;
import com.example.muon_sach.model.BookCode;
import com.example.muon_sach.repository.IBookCodeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookCodeService implements IBookCodeService {
    @Autowired
    private IBookCodeRepository bookCodeRepository;

    @Override
    public void saveRandomNumber(int randomNumber, Book book) {
        BookCode bookCode = new BookCode();
        bookCode.setCodeBook(randomNumber);
        bookCode.setBook(book);
        bookCodeRepository.save(bookCode);
    }

    @Override
    public List<BookCode> findAll() {
        return bookCodeRepository.findAll();
    }

    @Override
    public boolean deleteCodeBook(int id) {
        BookCode bookCode = findByCode(id);
        if (bookCode != null) {
            bookCodeRepository.delete(bookCode);
            return true;
        }
        return false;
    }

    @Override
    public BookCode findByCode(int codeBook) {
        return bookCodeRepository.findById(codeBook).get();
    }


}
