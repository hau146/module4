package com.example.demo.service;

import com.example.demo.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IBlogService {
//    List<Blog> findAll();
    Page<Blog> finAll(Pageable pageable, String titleBlog);
    boolean create(Blog blog);
    boolean update(Blog blog);
    Blog findById(int id);
    boolean delete(int id);
}
