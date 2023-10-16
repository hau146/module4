package com.example.demo.service;

import com.example.demo.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IBlogService {
    List<Blog> showAll();
    Page<Blog> findAll(Pageable pageable);
    List<Blog> searchBlog(String titleBlog);
    Blog findById(int id);
}
