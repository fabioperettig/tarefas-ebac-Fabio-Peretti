package com.fabioperettig.domain;

import jakarta.persistence.*;

import javax.naming.Name;

@Entity
@Table(name = "TB_PRODUCT")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "prod_seq")
    @SequenceGenerator(
            name = "prod_seq",
            sequenceName = "sq_product",
            initialValue = 1,
            allocationSize = 1)
    private long id;

    @Column(name = "CODE", nullable = false)
    private String code;

    @Column(name = "NAME", nullable = false)
    private String name;

    @Column(name = "VALUE", nullable = false)
    private double value;
}
