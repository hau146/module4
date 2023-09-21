package com.example.demo.service;

import com.example.demo.model.Blog;

import java.util.List;

public interface IBlogService {
    List<Blog> findAll();
    void create(Blog blog);
    void update(Blog blog);
    Blog findById(int id);
    void delete(int id);
}
