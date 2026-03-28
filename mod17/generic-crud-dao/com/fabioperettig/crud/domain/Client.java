package com.fabioperettig.crud.domain;

import java.util.Objects;

public class Client implements Persistent{

    private String name;
    private Long code;
    private String country;

    /// ctor
    public Client(String name, Long code, String country) {
        this.name = name;
        this.code = code;
        this.country = country;
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

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Client client = (Client) o;
        return Objects.equals(name, client.name) && Objects.equals(code, client.code) && Objects.equals(country, client.country);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, code, country);
    }

    @Override
    public String toString() {
        return "Client{" +
                "name='" + name + '\'' +
                ", code=" + code +
                ", country='" + country + '\'' +
                '}';
    }

    @Override
    public Long getCode() {
        return this.code;
    }
}
