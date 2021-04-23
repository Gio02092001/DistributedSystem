package com.distributedsystems.task.controller;


import com.distributedsystems.task.Dto.AquariumOrderConfirmation;
import com.distributedsystems.task.Dto.AquariumOrderRequest;
import com.distributedsystems.task.model.AquariumOrder;
import com.distributedsystems.task.service.AquariumOrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/aquariumOrder")
@CrossOrigin(origins = "*")
public class AquariumOrderController {
    private static final Logger log = LoggerFactory.getLogger(AquariumOrderController.class);
    @Autowired
    private AquariumOrderService aquariumOrderService;

    @GetMapping("/price")
    public AquariumOrderRequest getPrice(@RequestBody AquariumOrderRequest aquariumOrderRequest){
        log.info("Thank you for your Request. Your Price will be soon available");
        return aquariumOrderService.getPrice(aquariumOrderRequest);
    }
    @PostMapping("/pay")
    public AquariumOrderConfirmation confirmOrder(@RequestBody AquariumOrderRequest aquariumOrderRequest) throws Exception {
        log.info("Thank you for Buying our aquarium. You'll get a confirmation soon");
        return aquariumOrderService.confirmOrder(aquariumOrderRequest);
    }
}
