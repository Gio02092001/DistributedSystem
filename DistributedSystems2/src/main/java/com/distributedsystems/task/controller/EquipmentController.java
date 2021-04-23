
package com.distributedsystems.task.controller;


import com.distributedsystems.task.model.Equipment;
import com.distributedsystems.task.model.Order;
import com.distributedsystems.task.repository.EquipmentRepository;
import com.distributedsystems.task.repository.OrderRepository;
import com.distributedsystems.task.service.EquipmentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/equipment")
public class EquipmentController {
    private static final Logger log = LoggerFactory.getLogger(EquipmentController.class);
    @Autowired
    private EquipmentRepository equipmentRepository;
    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    EquipmentService equipmentService;

    @PostMapping(value = "/order",consumes = "application/json")
    public Order addOrder(@RequestBody Order order)  {
        log.info("Order has successfully been received: ", order);
        return equipmentService.addOrder(order);
    }
    @PostMapping
    public Equipment addEquipment(@RequestBody Equipment equipment){
        log.info("Request has been successfully received and new Equipment is added to Inventary");
        return equipmentRepository.save(equipment);
    }

    @GetMapping
    public Set<Equipment> getEquipments(){
        log.info("Thank you for your request! These are all Equipments you can buy");
        return equipmentRepository.getEquiments();
    }

}
