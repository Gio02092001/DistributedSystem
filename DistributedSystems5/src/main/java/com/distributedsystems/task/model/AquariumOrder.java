package com.distributedsystems.task.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Date;

@Entity
public class AquariumOrder {
    @Id
    @SequenceGenerator(
            name = "AquariumOrder_Sequence",
            sequenceName = "aquariumOrder_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "aquariumOrder_sequence"
    )
    private int id;
    private Date orderTime;
    private Date shipmentDate;
    private float totalPrice;
    private String shipmentAddress;
    private int orderAquarium_id;


    public int getOrderAquarium_id() {
        return orderAquarium_id;
    }

    public void setOrderAquarium_id(int orderAquarium_id) {
        this.orderAquarium_id = orderAquarium_id;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(Date orderTime) {
        this.orderTime = orderTime;
    }

    public Date getShipmentDate() {
        return shipmentDate;
    }

    public void setShipmentDate(Date shipmentDate) {
        this.shipmentDate = shipmentDate;
    }

    public float getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(float totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getShipmentAddress() {
        return shipmentAddress;
    }

    public void setShipmentAddress(String shipmentAddress) {
        this.shipmentAddress = shipmentAddress;
    }
}
