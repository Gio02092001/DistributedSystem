package com.distributedsystems.task.model;

import javax.persistence.*;

@Entity
public class OrderDecoration {
    @Id
    @SequenceGenerator(
            name = "DecorationOrder_Sequence",
            sequenceName = "decorationOrder_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "decorationOrder_sequence"
    )
    private int id;
    private int order_id;
    private int decoration_id;
    private int amount;

    public OrderDecoration(int order_id, int decoration_id, int amount) {
        this.order_id = order_id;
        this.decoration_id = decoration_id;
        this.amount = amount;
    }

    public OrderDecoration() {

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

    public int getDecoration_id() {
        return decoration_id;
    }

    public void setDecoration_id(int decoration_id) {
        this.decoration_id = decoration_id;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
