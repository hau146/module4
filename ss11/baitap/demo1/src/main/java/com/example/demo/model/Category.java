package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String typeBlog;
    @JsonBackReference
    @OneToMany(mappedBy = "category")
    private Set<Blog> blogSet;

    public Category() {
    }

    public Category(int id, String typeBlog, Set<Blog> blogSet) {
        this.id = id;
        this.typeBlog = typeBlog;
        this.blogSet = blogSet;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTypeBlog() {
        return typeBlog;
    }

    public void setTypeBlog(String typeBlog) {
        this.typeBlog = typeBlog;
    }

    public Set<Blog> getBlogSet() {
        return blogSet;
    }

    public void setBlogSet(Set<Blog> blogSet) {
        this.blogSet = blogSet;
    }
}
