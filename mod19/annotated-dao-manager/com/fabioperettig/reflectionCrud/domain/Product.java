package com.fabioperettig.reflectionCrud.domain;

import com.fabioperettig.reflectionCrud.annotation.TypeKey;

public class Product implements Persistent{

    @TypeKey("getCode")
    private Long code;
    private String name;
    private String brand;

    public Product(String name, Long code, String country) {
    }

    public String getName() {
        return name;
    }
    public Long getCode() {
        return this.code;
    }
    public String getBrand() {
        return brand;
    }

    public void setName(String name) {
        this.name = name;
    }
    public void setCode(Long code) {
        this.code = code;
    }
    public void setBrand(String brand) {
        this.brand = brand;
    }

    @Override
    public String toString() {
        return "Product{" +
                "code=" + code +
                ", name='" + name + '\'' +
                ", brand='" + brand + '\'' +
                '}';
    }
}
