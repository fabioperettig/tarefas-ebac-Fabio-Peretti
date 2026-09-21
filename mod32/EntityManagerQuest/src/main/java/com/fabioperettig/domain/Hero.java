package com.fabioperettig.domain;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "TB_HERO")
public class Hero {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "hero_seq_generator")
    @SequenceGenerator(
            name = "hero_seq_generator",
            sequenceName = "sq_hero",
            initialValue = 1,
            allocationSize = 1)
    private Long id;

    @Column(name = "NOME", nullable = false, length = 50)
    private String name;

    @Column(name = "CLASSE", nullable = false)
    private String heroClass;

    @Column(name = "NÍVEL", nullable = false)
    private Integer level;

    @OneToMany(mappedBy = "hero", cascade = CascadeType.ALL)
    private List<Item> inventory = new ArrayList<>();

    /// Construtor vazio exigido pelo JPA
    protected Hero() {
    }

    /// Construtor do usuário
    public Hero(String name, String heroClass) {
        this.name = name;
        this.heroClass = heroClass;
        level = 1;
    }

    /// Getters n Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHeroClass() {
        return heroClass;
    }

    public void setHeroClass(String heroClass) {
        this.heroClass = heroClass;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public List<Item> getInventory() {
        return inventory;
    }

    public void setInventory(List<Item> inventory) {
        this.inventory = inventory;
    }
}
