package com.distributedsystems.task.Dto;

public class Aquarium {
    private int aquarium_id;
    private float price;
    private int amount=1;

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

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }
}
