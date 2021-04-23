package com.distributedsystems.task.Dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Set;

public class AquariumOrderRequest {

    private Aquarium aquarium;
    private Set<Equipment> equipmentSet;
    private Set<Decoration> decorationSet;
    private Set<Fish> fishSet;
    private float totalPrice;
    private String shipmentAddress;



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

    public Aquarium getAquarium() {
        return aquarium;
    }

    public void setAquarium(Aquarium aquarium) {
        this.aquarium = aquarium;
    }

    public Set<Equipment> getEquipmentSet() {
        return equipmentSet;
    }

    public void setEquipmentSet(Set<Equipment> equipmentSet) {
        this.equipmentSet = equipmentSet;
    }

    public Set<Decoration> getDecorationSet() {
        return decorationSet;
    }

    public void setDecorationSet(Set<Decoration> decorationSet) {
        this.decorationSet = decorationSet;
    }

    public Set<Fish> getFishSet() {
        return fishSet;
    }

    public void setFishSet(Set<Fish> fishSet) {
        this.fishSet = fishSet;
    }


}
