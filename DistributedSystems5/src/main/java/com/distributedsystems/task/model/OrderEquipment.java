package com.distributedsystems.task.model;

import javax.persistence.*;
@Entity
public class OrderEquipment {
    @Id
    @SequenceGenerator(
            name = "EquipmentOrder_Sequence",
            sequenceName = "equipmentOrder_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "equipmentOrder_sequence"
    )
    private int id;
    private int order_id;
    private int equipment_id;
    private int amount;

    public OrderEquipment(int order_id, int equipment_id, int amount) {
        this.order_id = order_id;
        this.equipment_id = equipment_id;
        this.amount = amount;
    }

    public OrderEquipment() {

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

    public int getEquipment_id() {
        return equipment_id;
    }

    public void setEquipment_id(int equipment_id) {
        this.equipment_id = equipment_id;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
