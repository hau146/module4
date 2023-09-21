package com.example.demo.controller;

import com.example.demo.model.Blog;
import com.example.demo.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class BlogController {
    @Autowired
    private IBlogService blogService;
    @ModelAttribute("listTypeBlog")
    public String[] getListTypeBlog(){
        return new String[]{"kinh doanh", "âm nhạc", "game"};
    }
    @GetMapping("/")
    public String findAll(Model model){
        List<Blog> blogList = blogService.findAll();
        model.addAttribute("blogList",blogList);
        return "list";
    }
    @GetMapping("/create")
    public String create(Model model){
        model.addAttribute("blog", new Blog());
        return "create";
    }
    @PostMapping("/create")
    public String create(@ModelAttribute Blog blog,
                         RedirectAttributes redirectAttributes) {
        blogService.create(blog);
        redirectAttributes.addFlashAttribute("mess", "Thêm thành công");
        return "redirect:/create";
    }
    @GetMapping("/delete")
    public String delete (@RequestParam int idBlog,
                          RedirectAttributes redirectAttributes){
        blogService.delete(idBlog);
        redirectAttributes.addFlashAttribute("mess", "Xóa thành công !");
        return "redirect:/";
    }
    @GetMapping("/update")
    public String update(@RequestParam int idBlog, Model model){
        Blog blog = blogService.findById(idBlog);
        model.addAttribute("blog", blog);
        return "update";
    }
    @PostMapping("/update")
    public String update(@ModelAttribute Blog blog,
                         RedirectAttributes redirectAttributes){
        blogService.update(blog);
        redirectAttributes.addFlashAttribute("mess", "Sửa thành công !");
        return "redirect:/";
    }
    @GetMapping("/detail")
    public String detail(@RequestParam(name = "idBlog",
                                       defaultValue = "0",
                                       required = false)
                                       int idBlog, Model model){
        Blog blog = blogService.findById(idBlog);
        model.addAttribute("blog",blog);
        return "detail";
    }
}
