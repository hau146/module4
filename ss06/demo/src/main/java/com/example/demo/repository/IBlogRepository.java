package com.example.demo.repository;

import com.example.demo.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IBlogRepository extends JpaRepository<Blog, Integer> {
    //search
//    @Query(value = "select * from blog where titleBlog like :titleBlog",
//            nativeQuery = true)
//    List<Blog> searchBlogByTitleBlog(@Param("title") String searchTitle);

    List<Blog> findAllByTitleBlogContaining(String titleBlog);
    Page<Blog> findAllByTitleBlogContaining(Pageable pageable, String titleBlog);
}
