package com.soft1851.spring.ioc.entity;

public class Phone {
    private String brand;
    private Double price;

    public Phone(String brand, Double price) {
        this.brand = brand;
        this.price = price;
    }
    public Phone(){}

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Phone{" +
                "brand='" + brand + '\'' +
                ", price=" + price +
                '}';
    }
}
