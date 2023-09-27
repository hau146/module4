package com.example.muon_sach.model;

import javax.persistence.*;
import java.util.Set;

@Entity
public class People {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(columnDefinition = "varchar(50) not null")
    private String name;
    @Column(columnDefinition = "int not null")
    private int age;
    @ManyToMany
    @JoinTable(name = "people_book")
    @JoinColumn(columnDefinition = "people_id",
                referencedColumnName = "book_id")
    private Set<Book> bookSet;

    public People() {
    }

    public People(int id, String name, int age, Set<Book> bookSet) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.bookSet = bookSet;
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Set<Book> getBookSet() {
        return bookSet;
    }

    public void setBookSet(Set<Book> bookSet) {
        this.bookSet = bookSet;
    }
}
