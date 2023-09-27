package com.example.muon_sach.model;

import javax.persistence.*;

@Entity
public class BookCode {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(columnDefinition = "int not null")
    private int codeBook;
    @ManyToOne
    @JoinColumn(name = "book_id", referencedColumnName = "id")
    private Book book;

    public BookCode(int id, int codeBook, Book book) {
        this.id = id;
        this.codeBook = codeBook;
        this.book = book;
    }

    public BookCode() {
    }

    public BookCode(int codeBook, Book book) {
        this.codeBook = codeBook;
        this.book = book;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCodeBook() {
        return codeBook;
    }

    public void setCodeBook(int codeBook) {
        this.codeBook = codeBook;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }
}
