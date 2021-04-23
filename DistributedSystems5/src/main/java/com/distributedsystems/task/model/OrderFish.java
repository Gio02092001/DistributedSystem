package com.distributedsystems.task.model;

import javax.persistence.*;

@Entity
public class OrderFish {
    @Id
    @SequenceGenerator(
            name = "FishOrder_Sequence",
            sequenceName = "fishOrder_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "fishOrder_sequence"
    )
    private int id;
    private int order_id;
    private int fish_id;
    private int amount;

    public OrderFish(int order_id, int fish_id, int amount) {
        this.order_id = order_id;
        this.fish_id = fish_id;
        this.amount = amount;
    }

    public OrderFish() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getOrder_id() {
        return order_id;
    }

    public void setOrder_id(int order_id) {
        this.order_id = order_id;
    }

    public int getFish_id() {
        return fish_id;
    }

    public void setFish_id(int fish_id) {
        this.fish_id = fish_id;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
