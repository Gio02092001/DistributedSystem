package com.distributedsystems.task.repository;


import com.distributedsystems.task.model.AquariumOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AquariumOrderRepository extends JpaRepository<AquariumOrder, Integer> {
}
