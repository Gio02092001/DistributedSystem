package com.distributedsystems.task.Dto;

public class Fish {
    private int fish_id;
    private float price;
    private int amount=1;

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getFish_id() {
        return fish_id;
    }

    public void setFish_id(int fish_id) {
        this.fish_id = fish_id;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }
}
