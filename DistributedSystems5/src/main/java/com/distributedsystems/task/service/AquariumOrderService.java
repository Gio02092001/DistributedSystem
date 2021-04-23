package com.distributedsystems.task.service;

import com.distributedsystems.task.Dto.*;
import com.distributedsystems.task.controller.AquariumOrderController;
import com.distributedsystems.task.model.AquariumOrder;
import com.distributedsystems.task.model.OrderDecoration;
import com.distributedsystems.task.model.OrderEquipment;
import com.distributedsystems.task.model.OrderFish;
import com.distributedsystems.task.repository.AquariumOrderRepository;
import com.distributedsystems.task.repository.OrderDecorationRepository;
import com.distributedsystems.task.repository.OrderEquipmentRepository;
import com.distributedsystems.task.repository.OrderFishRepository;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.methods.RequestBuilder;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Service;

import java.net.http.HttpRequest;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.Set;

@Service
public class AquariumOrderService {
    private static final Logger log = LoggerFactory.getLogger(AquariumOrderService.class);

    @Autowired
    AquariumOrderRepository aquariumOrderRepository;

    @Autowired
    OrderDecorationRepository orderDecorationRepository;

    @Autowired
    OrderEquipmentRepository orderEquipmentRepository;

    @Autowired
    OrderFishRepository orderFishRepository;

    public AquariumOrderRequest getPrice(AquariumOrderRequest aquariumOrderRequest){
        float totalPrice = aquariumOrderRequest.getAquarium().getPrice()*aquariumOrderRequest.getAquarium().getAmount();
        Set<Equipment> equipmentSet = aquariumOrderRequest.getEquipmentSet();
        log.info("Your total price of the aquarium is " + totalPrice);
        Iterator<Equipment> equipmentIterator = aquariumOrderRequest.getEquipmentSet().iterator();
        while(equipmentIterator.hasNext()){
            Equipment equipment = equipmentIterator.next();
            totalPrice = totalPrice + equipment.getPrice() * equipment.getAmount() ;
        }
        log.info("Your total price after Equipments is " + totalPrice);
        Iterator<Decoration> decorationIterator = aquariumOrderRequest.getDecorationSet().iterator();
        while(decorationIterator.hasNext()){
            Decoration decoration = decorationIterator.next();
            totalPrice = totalPrice + decoration.getPrice()* decoration.getAmount();
        }
        log.info("Your total price after Decorations is " + totalPrice);
        Iterator<Fish> fishIterator = aquariumOrderRequest.getFishSet().iterator();
        while(fishIterator.hasNext()){
            Fish fish = fishIterator.next();
            totalPrice = totalPrice + fish.getPrice()* fish.getAmount();
        }
        log.info("Your total price is " + totalPrice);
        aquariumOrderRequest.setTotalPrice(totalPrice);

        return aquariumOrderRequest;
    }
    public AquariumOrderConfirmation confirmOrder(AquariumOrderRequest aquariumOrderRequest) throws Exception{


        AquariumOrder order = new AquariumOrder();
        Date now = new Date(System.currentTimeMillis());
        Calendar cal = Calendar.getInstance();
        cal.setTime(now);
        cal.add(Calendar.DATE,4);
        order.setOrderTime(now);
        order.setTotalPrice(aquariumOrderRequest.getTotalPrice());
        order.setShipmentAddress(aquariumOrderRequest.getShipmentAddress());
        order.setShipmentDate(cal.getTime());
        order.setOrderAquarium_id(aquariumOrderRequest.getAquarium().getAquarium_id());
        order = aquariumOrderRepository.save(order);
        log.info("Your order has been successfully saved and is now forwarded to our partners");

        OrderPartner orderPartner = new OrderPartner(order.getId(),aquariumOrderRequest.getAquarium().getAquarium_id(),order.getOrderTime(),order.getShipmentDate(),"in progress",aquariumOrderRequest.getAquarium().getAmount());
        System.out.println(orderPartner.getOrder_id());
        HttpUriRequest request = null;
        StringEntity stringE = new StringEntity(orderPartner.toString());
        System.out.println(stringE);
        stringE.setContentType("application/json;charset=utf-8");
        request = RequestBuilder.create("POST")
                .setUri("http://localhost:8091/aquarium/order")
                .setEntity(stringE)
                .build();
        HttpResponse response = null;
        response = HttpClientBuilder.create().build().execute(request);
        log.info("AquariumPartner has successfully received your order ", response);
        Set<Equipment> equipmentSet = aquariumOrderRequest.getEquipmentSet();

        Iterator<Equipment> equipmentIterator = aquariumOrderRequest.getEquipmentSet().iterator();
        while(equipmentIterator.hasNext()){
            Equipment equipment = equipmentIterator.next();
            OrderEquipment orderEquipment = orderEquipmentRepository.save(new OrderEquipment(order.getId(),equipment.getEquipment_id(),equipment.getAmount()));

            orderPartner = new OrderPartner(order.getId(),orderEquipment.getEquipment_id(),order.getOrderTime(),order.getShipmentDate(),"in progress",orderEquipment.getAmount());
            request = null;
            stringE = new StringEntity(orderPartner.toString());

            stringE.setContentType("application/json;charset=utf-8");
            request = RequestBuilder.create("POST")
                    .setUri("http://localhost:8092/equipment/order")
                    .setEntity(stringE)
                    .build();
            response = null;
            response = HttpClientBuilder.create().build().execute(request);
            log.info("EquipmentPartner has successfully received your order ", response);
        }
        Iterator<Decoration> decorationIterator = aquariumOrderRequest.getDecorationSet().iterator();
        while(decorationIterator.hasNext()){
            Decoration decoration = decorationIterator.next();
            OrderDecoration orderEquipment = orderDecorationRepository.save(new OrderDecoration(order.getId(),decoration.getDecoration_id(),decoration.getAmount()));

            orderPartner = new OrderPartner(order.getId(),orderEquipment.getDecoration_id(),order.getOrderTime(),order.getShipmentDate(),"in progress",orderEquipment.getAmount());
            request = null;
            stringE = new StringEntity(orderPartner.toString());

            stringE.setContentType("application/json;charset=utf-8");
            request = RequestBuilder.create("POST")
                    .setUri("http://localhost:8093/decoration/order")
                    .setEntity(stringE)
                    .build();
            response = null;
            response = HttpClientBuilder.create().build().execute(request);
            log.info("DecorationPartner has successfully received your order ", response);
        }
        Iterator<Fish> fishIterator = aquariumOrderRequest.getFishSet().iterator();
        while(fishIterator.hasNext()){
            Fish fish = fishIterator.next();
            OrderFish orderEquipment= orderFishRepository.save(new OrderFish(order.getId(),fish.getFish_id(), fish.getAmount()));

            orderPartner = new OrderPartner(order.getId(),orderEquipment.getFish_id(),order.getOrderTime(),order.getShipmentDate(),"in progress",orderEquipment.getAmount());
            request = null;
            stringE = new StringEntity(orderPartner.toString());

            stringE.setContentType("application/json;charset=utf-8");
            request = RequestBuilder.create("POST")
                    .setUri("http://localhost:8094/fish/order")
                    .setEntity(stringE)
                    .build();
            response = null;
            response = HttpClientBuilder.create().build().execute(request);
            log.info("FishPartner has successfully received your order ", response);
        }
        return new AquariumOrderConfirmation(order,aquariumOrderRequest);
    }

}
