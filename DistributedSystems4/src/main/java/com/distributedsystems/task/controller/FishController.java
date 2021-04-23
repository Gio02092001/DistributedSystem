package com.distributedsystems.task.controller;

import com.distributedsystems.task.model.Fish;
import com.distributedsystems.task.model.Order;
import com.distributedsystems.task.repository.FishRepository;
import com.distributedsystems.task.repository.OrderRepository;
import com.distributedsystems.task.service.FishService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/fish")
public class FishController {
    private static final Logger log = LoggerFactory.getLogger(FishController.class);

    @Autowired
    private FishRepository fishRepository;

    @Autowired
    private FishService fishService;



    @PostMapping(value = "/order",consumes = "application/json")
    public Order addOrder(@RequestBody Order order)  {
        log.info("Order has successfully been received: ", order);
        return fishService.addOrder(order);
    }

    @PostMapping
    public Fish addFish(@RequestBody Fish fish){
        log.info("Request has been successfully received and new Fish is added to Inventary");
        return fishRepository.save(fish);
    }

    @GetMapping
    public Set<Fish> getFish(){
        log.info("Thank you for your request! These are all fish you can buy");
        return fishRepository.getFishs();
    }

}
