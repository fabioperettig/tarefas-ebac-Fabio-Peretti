package com.fabioperettig.reflectionCrud.domain;

public class Product implements Persistent{

    private String name;
    private Long code;
    private String brand;

    public Product(String name, Long code, String brand) {
        this.name = name;
        this.code = code;
        this.brand = brand;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCode(Long code) {
        this.code = code;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    @Override
    public Long getCode() {
        return this.code;
    }

}
