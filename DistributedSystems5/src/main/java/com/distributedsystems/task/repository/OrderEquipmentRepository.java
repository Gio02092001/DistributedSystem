package com.distributedsystems.task.repository;

import com.distributedsystems.task.Dto.Decoration;
import com.distributedsystems.task.Dto.Equipment;
import com.distributedsystems.task.model.OrderEquipment;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderEquipmentRepository extends CrudRepository<OrderEquipment,Integer> {
}
