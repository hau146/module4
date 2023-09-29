package com.example.demo.dto;

import com.example.demo.model.Category;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

public class BlogDto{
    private int id;
    private String titleBlog;
    private Category category;

    public BlogDto() {
    }

    public BlogDto(int id, String titleBlog, Category category) {
        this.id = id;
        this.titleBlog = titleBlog;
        this.category = category;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitleBlog() {
        return titleBlog;
    }

    public void setTitleBlog(String titleBlog) {
        this.titleBlog = titleBlog;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
