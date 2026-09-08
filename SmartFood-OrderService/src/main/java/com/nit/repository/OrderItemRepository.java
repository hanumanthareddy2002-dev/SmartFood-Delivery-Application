package com.nit.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nit.entity.OrderItem;

@Repository
public interface OrderItemRepository extends JpaRepository<OrderItem,Long>
{

}
