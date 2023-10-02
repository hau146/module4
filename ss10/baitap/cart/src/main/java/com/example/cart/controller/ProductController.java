package com.example.cart.controller;

import com.example.cart.dto.CartDto;
import com.example.cart.dto.ProductDto;
import com.example.cart.model.Product;
import com.example.cart.service.IProductService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@SessionAttributes("cart")
public class ProductController {
    @Autowired
    private IProductService productService;
    @GetMapping("")
    public String showAll(Model model){
        List<Product> productList = productService.showAll();
        model.addAttribute("productList",productList);
        return "list-product";
    }
    @ModelAttribute("cart")
    public CartDto initCartDto(){
        return new CartDto();
    }
    @GetMapping("/add")
    public String addToCart(@RequestParam int id,
                            @SessionAttribute(value = "cart", required = false) CartDto cartDto,
                            RedirectAttributes redirectAttributes){
        Product product = productService.findById(id);
        if (product != null){
            ProductDto productDto = new ProductDto();
            BeanUtils.copyProperties(product, productDto);
            cartDto.addProduct(productDto);
        } else {
            redirectAttributes.addFlashAttribute("mess", "Không có sản phẩm này !");
            return "redirect:/";
        }
        return "redirect:/cart";
    }
    @GetMapping("/delete")
    public String deleteToCart(@RequestParam int id,
                            @SessionAttribute(value = "cart", required = false) CartDto cartDto){
        Product product = productService.findById(id);
        if (product != null){
            ProductDto productDto = new ProductDto();
            BeanUtils.copyProperties(product, productDto);
            cartDto.deleteProduct(productDto);
        }
        return "redirect:/cart";
    }
    @GetMapping("/minus")
    public String minusToCart(@RequestParam int id,
                        @SessionAttribute(value = "cart",required = false) CartDto cartDto){
        Product product = productService.findById(id);
        if(product != null){
            ProductDto productDto = new ProductDto();
            BeanUtils.copyProperties(product,productDto);
            cartDto.minusProduct(productDto);
        }
        return "redirect:/cart";
    }
}
