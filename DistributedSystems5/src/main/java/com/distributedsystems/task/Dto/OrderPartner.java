package com.distributedsystems.task.Dto;

import java.util.Date;


public class OrderPartner {

    private int order_id;
    private int extra_id;
    private Date orderTime;
    private Date shipmentDate;
    private String status;
    private int amount = 1;

    public OrderPartner(int order_id, int extra_id, Date orderTime, Date shipmentDate, String status, int amount) {
        this.extra_id = extra_id;
        this.orderTime = orderTime;
        this.shipmentDate = shipmentDate;
        this.order_id = order_id;
        this.status = status;
        this.amount = amount;

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

    public int getOrder_id() {
        return order_id;
    }

    public void setOrder_id(int order_id) {
        this.order_id = order_id;
    }

    public int getExtra_id() {
        return extra_id;
    }

    public void setExtra_id(int extra_id) {
        this.extra_id = extra_id;
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

    @Override
    public String toString() {
        return "{" +
                "\"order_id\":" + order_id +
                ", \"extra_id\":" + extra_id +
                ", \"orderTime\":" +"\""+ orderTime +"\""+
                ", \"shipmentDate\":" + "\""+shipmentDate +"\""+
                ", \"status\":" + "\""+status + "\"" +
                ", \"amount\":" + amount +
                "}";
    }
}
