package com.distributedsystems.task.controller;

import com.distributedsystems.task.model.Decoration;
import com.distributedsystems.task.model.Order;
import com.distributedsystems.task.repository.DecorationRepository;
import com.distributedsystems.task.repository.OrderRepository;
import com.distributedsystems.task.service.DecorationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/decoration")
public class DecorationController {
    private static final Logger log = LoggerFactory.getLogger(DecorationController.class);

    @Autowired
    private DecorationRepository decorationRepository;

    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private DecorationService decorationService;


    @PostMapping(value = "/order",consumes = "application/json")
    public Order addOrder(@RequestBody Order order)  {
        log.info("Order has successfully been received: ", order);
        return decorationService.addOrder(order);
    }
    @PostMapping
    public Decoration addAquarium(@RequestBody Decoration decoration){

        log.info("Request has been successfully received and new Decoration is added to Inventary");
        return decorationRepository.save(decoration);
    }

    @GetMapping
    public Set<Decoration> getAquariums(){
        log.info("Thank you for your request! These are all fish you can buy");
        return decorationRepository.getDecorations();
    }


}
