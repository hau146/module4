package com.example.product.controller;

import com.example.product.model.Product;
import com.example.product.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private IProductService productService;
    @ModelAttribute("listDescribeProduct")
    public String[] getListDescribeProduct(){
        return new String[]{"Còn hàng", "Hết hàng", "Mới nhập"};
    }
    @GetMapping("/list")
    public String showList(Model model){
        List<Product> productList = productService.showAll();
        model.addAttribute("productList",productList);
        return "list";
    }
    @GetMapping("/detail")
    public String detail(@RequestParam(name = "id",
                                       defaultValue = "0",
                                       required = false) int idDetail,
                                       Model model){
        Product product = productService.finById(idDetail);
        model.addAttribute("product",product);
        return "detail";
    }
    @GetMapping("/create")
    public String showCreate(Model model){
        model.addAttribute("product", new Product());
        return "create";
    }
    @PostMapping("/create")
    public String add(@ModelAttribute Product product,
                      RedirectAttributes redirectAttributes){
        productService.create(product);
        redirectAttributes.addFlashAttribute("mess", "Thêm thành công");
        return "redirect:/product/list";
    }
    @GetMapping("/edit")
    public String showEdit(@RequestParam int id, Model model){
        Product product = productService.finById(id);
        model.addAttribute("product",product);
        return "edit";
    }
    @PostMapping("/edit")
    public String edit(@ModelAttribute Product product,
                       RedirectAttributes redirectAttributes){
        productService.update(product);
        redirectAttributes.addFlashAttribute("mess", "sửa thành công");
        return "redirect:/product/list";
    }
    @GetMapping("delete")
    public String delete(@RequestParam int idDelete,
                         RedirectAttributes redirectAttributes){
        productService.delete(idDelete);
        redirectAttributes.addFlashAttribute("mess", "xóa thành công");
        return "redirect:/product/list";
    }
}
