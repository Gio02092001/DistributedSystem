package com.distributedsystems.task.Dto;

import com.distributedsystems.task.model.AquariumOrder;

import java.util.Set;

public class AquariumOrderConfirmation {
    private AquariumOrder aquariumOrder;
    private AquariumOrderRequest aquariumOrderRequest;

    public AquariumOrderConfirmation(AquariumOrder aquariumOrder, AquariumOrderRequest aquariumOrderRequest) {
        this.aquariumOrder = aquariumOrder;
        this.aquariumOrderRequest = aquariumOrderRequest;
    }

    public AquariumOrder getAquariumOrder() {
        return aquariumOrder;
    }

    public void setAquariumOrder(AquariumOrder aquariumOrder) {
        this.aquariumOrder = aquariumOrder;
    }

    public AquariumOrderRequest getAquariumOrderRequest() {
        return aquariumOrderRequest;
    }

    public void setAquariumOrderRequest(AquariumOrderRequest aquariumOrderRequest) {
        this.aquariumOrderRequest = aquariumOrderRequest;
    }
}
