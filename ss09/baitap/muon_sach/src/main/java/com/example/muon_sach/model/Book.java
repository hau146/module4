package com.example.muon_sach.model;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(columnDefinition = "varchar(50) not null")
    private String name;
    @Column(columnDefinition = "int not null")
    private int quantity;
    @OneToMany(mappedBy = "book")
    private Set<BookCode> bookCodeSet;
    @ManyToMany(mappedBy = "bookSet")
    private Set<People> peopleSet;


    public Book(int id, String name, int quantity, Set<BookCode> bookCodeSet, Set<People> peopleSet) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.bookCodeSet = bookCodeSet;
        this.peopleSet = peopleSet;
    }

    public Book() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Set<BookCode> getBookCodeSet() {
        return bookCodeSet;
    }

    public void setBookCodeSet(Set<BookCode> bookCodeSet) {
        this.bookCodeSet = bookCodeSet;
    }

    public Set<People> getPeopleSet() {
        return peopleSet;
    }

    public void setPeopleSet(Set<People> peopleSet) {
        this.peopleSet = peopleSet;
    }
    public int randomCodeBook(){
        int randomNumber = (int) (Math.random() * 90000) + 10000;
        System.out.println("số random dc: " + randomNumber);
        return randomNumber;
    }
}
