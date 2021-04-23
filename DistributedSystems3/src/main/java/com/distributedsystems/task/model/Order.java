package com.distributedsystems.task.model;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Order {
    @Id
    @SequenceGenerator(
            name = "Order_Sequence",
            sequenceName = "order_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "order_sequence"
    )
    private int id;
    private int order_id;
    private int extra_id;
    private String orderTime;
    private String shipmentDate;
    private String status;
    private int amount;

    public Order(int order_id, int extra_id, String orderTime, String shipmentDate, String status, int amount) {
        this.extra_id = extra_id;
        this.orderTime = orderTime;
        this.shipmentDate = shipmentDate;
        this.status = status;
        this.amount = amount;
        this.order_id=order_id;
    }

    public Order() {

    }

    public int getOrder_id() {
        return order_id;
    }

    public void setOrder_id(int order_id) {
        this.order_id = order_id;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getExtra_id() {
        return extra_id;
    }

    public void setExtra_id(int extra_id) {
        this.extra_id = extra_id;
    }

    public String getShipmentDate() {
        return shipmentDate;
    }

    public void setShipmentDate(String shipmentDate) {
        this.shipmentDate = shipmentDate;
    }

    public String getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(String orderTime) {
        this.orderTime = orderTime;
    }
}
