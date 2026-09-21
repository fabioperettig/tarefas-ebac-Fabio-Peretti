package com.fabioperettig.domain;

import jakarta.persistence.*;
import org.hibernate.annotations.ColumnDefault;

@Entity
@Table(name = "TB_ITEM")
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "item_seq_generator")
    @SequenceGenerator(
            name = "item_seq_generator",
            sequenceName = "sq_item",
            initialValue = 1,
            allocationSize = 1)
    private long id;

    @Column(name = "NOME", nullable = false, length = 50)
    private String name;

    @Column(name = "TIPO", nullable = false)
    private String type;

    @Column(name = "RARIDADE", nullable = false)
    private Integer rarity;

    @ColumnDefault("1")
    @Column(name = "DANO")
    private Integer damage;

    @ManyToOne
    @JoinColumn(name = "HERO_ID")
    private Hero hero;



    /// Getters n Setters
    public Integer getDamage() {
        return damage;
    }

    public void setDamage(Integer damage) {
        this.damage = damage;
    }

    public Integer getRarity() {
        return rarity;
    }

    public void setRarity(Integer rarity) {
        this.rarity = rarity;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
