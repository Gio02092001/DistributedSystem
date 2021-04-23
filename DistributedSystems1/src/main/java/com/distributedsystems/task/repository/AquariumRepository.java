package com.distributedsystems.task.repository;

import com.distributedsystems.task.model.Aquarium;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface AquariumRepository extends CrudRepository<Aquarium,Integer> {
    @Query(value= "Select * from aquarium", nativeQuery = true)
    public Set<Aquarium> getAquariums();
}
