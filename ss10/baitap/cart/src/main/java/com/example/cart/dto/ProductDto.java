package com.example.cart.dto;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;
import java.util.Objects;

public class ProductDto {
    private int id;
    private String name;
    private double price;

    public ProductDto() {
    }

    public ProductDto(int id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductDto that = (ProductDto) o;
        return id == that.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
    public String formatCurrency(double amount) {
        DecimalFormat decimalFormat = (DecimalFormat) NumberFormat.getNumberInstance(Locale.US);
        decimalFormat.applyPattern("###,###,###");
        return decimalFormat.format(amount);
    }

    public String formatPrice(){
        ProductDto productDto = new ProductDto();
        String formattedAmount = productDto.formatCurrency(price);
        System.out.println(formattedAmount);
        return formattedAmount;
    }
}
