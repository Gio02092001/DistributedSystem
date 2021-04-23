package com.distributedsystems.task.repository;

import com.distributedsystems.task.model.Decoration;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface DecorationRepository extends CrudRepository<Decoration,Integer> {
    @Query(value= "Select * from decoration", nativeQuery = true)
    public Set<Decoration> getDecorations();
}
