package com.distributedsystems.task.repository;

import com.distributedsystems.task.model.Fish;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface FishRepository extends CrudRepository<Fish,Integer> {
    @Query(value= "Select * from fish", nativeQuery = true)
    public Set<Fish> getFishs();
}
