package com.example.demo.service;

import com.example.demo.model.Blog;

import java.util.List;

public interface IBlogService {
    List<Blog> findAll();
    boolean create(Blog blog);
    boolean update(Blog blog);
    Blog findById(int id);
    boolean delete(int id);
}
