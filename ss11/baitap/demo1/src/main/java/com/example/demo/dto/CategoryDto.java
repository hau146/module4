package com.example.demo.dto;

import com.example.demo.model.Blog;

import java.util.Set;

public class CategoryDto {
    private int id;
    private String typeBlog;
    private Set<Blog> blogSet;

    public CategoryDto() {
    }

    public CategoryDto(int id, String typeBlog, Set<Blog> blogSet) {
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
