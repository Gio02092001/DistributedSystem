package com.distributedsystems.task.service;

import com.distributedsystems.task.model.Order;
import com.distributedsystems.task.repository.OrderRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.StringTokenizer;

@Service
public class EquipmentService {

    @Autowired
    private OrderRepository orderRepository;
    private static final Logger log = LoggerFactory.getLogger(EquipmentService.class);
    public Order addOrder(Order order)  {
        order = orderRepository.save(order);
        log.info("Order " + order.getOrder_id() + " has been successfully saved");
        return order;}
}
