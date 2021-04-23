package com.distributedsystems.task.repository;

import com.distributedsystems.task.Dto.Decoration;
import com.distributedsystems.task.model.OrderDecoration;
import org.springframework.core.DecoratingClassLoader;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderDecorationRepository extends CrudRepository<OrderDecoration,Integer> {
}
