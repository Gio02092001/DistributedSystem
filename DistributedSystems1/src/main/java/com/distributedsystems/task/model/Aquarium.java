package com.distributedsystems.task.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
public class Aquarium {
    @Id
    @SequenceGenerator(
            name = "Aquarium_Sequence",
            sequenceName = "aquarium_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "aquarium_sequence"
    )

    private int aquarium_id;
    private String material;
    private int dimensionLength;
    private int dimensionWidthness;
    private int dimensionHeight;
    private int waterCapacity;
    private float price;
    private int amount = 1;

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public int getDimensionHeight() {
        return dimensionHeight;
    }

    public void setDimensionHeight(int dimensionHeight) {
        this.dimensionHeight = dimensionHeight;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getAquarium_id() {
        return aquarium_id;
    }

    public void setAquarium_id(int aquarium_id) {
        this.aquarium_id = aquarium_id;
    }

    public int getDimensionLength() {
        return dimensionLength;
    }

    public void setDimensionLength(int dimensionLength) {
        this.dimensionLength = dimensionLength;
    }

    public int getDimensionWidthness() {
        return dimensionWidthness;
    }

    public void setDimensionWidthness(int dimensionWidthness) {
        this.dimensionWidthness = dimensionWidthness;
    }

    public int getWaterCapacity() {
        return waterCapacity;
    }

    public void setWaterCapacity(int waterCapacity) {
        this.waterCapacity = waterCapacity;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }
}
