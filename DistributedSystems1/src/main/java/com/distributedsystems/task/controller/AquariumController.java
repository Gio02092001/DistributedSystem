package com.distributedsystems.task.controller;

import com.distributedsystems.task.model.Aquarium;
import com.distributedsystems.task.model.Order;
import com.distributedsystems.task.repository.AquariumRepository;
import com.distributedsystems.task.repository.OrderRepository;
import com.distributedsystems.task.service.AquariumService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/aquarium")
public class AquariumController {

    private static final Logger log = LoggerFactory.getLogger(AquariumController.class);

    @Autowired
    private AquariumRepository aquariumRepository;

    @Autowired
    private AquariumService aquariumService;

    @PostMapping
    public Aquarium addAquarium(@RequestBody Aquarium aquarium){

        log.info("Request has been successfully received and new Aquarium is added to Inventary");
        return aquariumRepository.save(aquarium);
    }

    @GetMapping
    public Set<Aquarium> getAquariums(){
        log.info("Thank you for your request! These are all aquariums you can buy");
        return aquariumRepository.getAquariums();
    }
    @Autowired
    private OrderRepository orderRepository;
    @PostMapping(value = "/order",consumes = "application/json")
    public Order addOrder(@RequestBody Order order)  {
        log.info("Order has successfully been received: ", order);
        return aquariumService.addOrder(order);
    }
}
