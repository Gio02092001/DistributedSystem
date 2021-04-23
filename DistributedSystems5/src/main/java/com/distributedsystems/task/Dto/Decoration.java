package com.distributedsystems.task.Dto;

public class Decoration {
    private int decoration_id;
    private float price;
    private int amount=1;

    public Decoration(int decoration_id, float price) {
        this.decoration_id = decoration_id;
        this.price = price;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getDecoration_id() {
        return decoration_id;
    }

    public void setDecoration_id(int decoration_id) {
        this.decoration_id = decoration_id;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }
}
