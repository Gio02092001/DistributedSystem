package com.distributedsystems.task.repository;


import com.distributedsystems.task.model.Equipment;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface EquipmentRepository extends CrudRepository<Equipment,Integer> {
    @Query(value= "Select * from equipment", nativeQuery = true)
    public Set<Equipment> getEquiments();
}
