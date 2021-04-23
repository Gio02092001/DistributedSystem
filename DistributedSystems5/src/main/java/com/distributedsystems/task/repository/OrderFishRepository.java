package com.distributedsystems.task.repository;

import com.distributedsystems.task.model.OrderFish;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderFishRepository extends CrudRepository<OrderFish,Integer> {
}
