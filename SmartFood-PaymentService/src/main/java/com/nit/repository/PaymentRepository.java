package com.nit.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nit.entity.Payment;

@Repository
public interface PaymentRepository extends JpaRepository<Payment,Long>
{
	List<Payment> findByUserId(Long userId);
	List<Payment> findByOrderId(Long orderId);
	Optional<Payment> findByTransactionId(String transactionId);

}
