package com.example.cart.dto;

import com.example.cart.model.Product;
import com.example.cart.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

public class CartDto {
    private Map<ProductDto, Integer> productMap = new HashMap<>();

    public CartDto() {
    }

    public Map<ProductDto, Integer> getProductMap() {
        return productMap;
    }

    public void setProductMap(Map<ProductDto, Integer> productMap) {
        this.productMap = productMap;
    }
    public void deleteProduct(ProductDto productDto){
        productMap.remove(productDto);
    }

    public void addProduct(ProductDto productDto) {
        if (productMap.containsKey(productDto)) {
            Integer integer = productMap.get(productDto);
            productMap.replace(productDto, integer + 1);
        } else {
            productMap.put(productDto, 1);
        }
    }

    public void minusProduct(ProductDto productDto) {
        if (productMap.containsKey(productDto)) {
            int currentValue = productMap.get(productDto);
            productMap.replace(productDto,currentValue-1);
        }

    }
    public Float countTotalPayment(){
        float payment = 0;
        for (Map.Entry<ProductDto, Integer> entry : productMap.entrySet()) {
            payment += entry.getKey().getPrice() * (float) entry.getValue();
        }
        return payment;
    }
    public String formatCurrency(double amount) {
        DecimalFormat decimalFormat = (DecimalFormat) NumberFormat.getNumberInstance(Locale.US);
        decimalFormat.applyPattern("###,###,###");
        return decimalFormat.format(amount);
    }




}
