package com.distributedsystems.task.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
public class Decoration {
    @Id
    @SequenceGenerator(
            name = "Decoration_Sequence",
            sequenceName = "decoration_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "decoration_sequence"
    )
    private int decoration_id;
    private String type;
    private String name;
    private float price;
    private int amount=1;
    private String colour;

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getDecoration_id() {
        return decoration_id;
    }

    public void setDecoration_id(int decoration_id) {
        this.decoration_id = decoration_id;
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
}
