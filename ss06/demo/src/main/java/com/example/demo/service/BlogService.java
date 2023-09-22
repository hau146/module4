package com.example.demo.service;

import com.example.demo.model.Blog;
import com.example.demo.repository.IBlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class BlogService implements IBlogService{
    @Autowired
    private IBlogRepository blogRepository;
//    @Override
//    public List<Blog> findAll() {
//        return blogRepository.findAll();
//    }

    @Override
    public Page<Blog> finAll(Pageable pageable, String titleBlog) {
        return blogRepository.findAllByTitleBlogContaining(pageable, titleBlog);
    }

    @Override
    public boolean create(Blog blog) {
        try {
            blogRepository.save(blog);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    @Override
    public boolean update(Blog blog) {
        try {
            blogRepository.save(blog);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    @Override
    public Blog findById(int id) {
        return blogRepository.findById(id).get();
    }

    @Override
    public boolean delete(int id) {
        try {
            Blog blog = findById(id);
            blogRepository.delete(blog);
        } catch (Exception e) {
            return false;
        }
        return true;
    }
}
