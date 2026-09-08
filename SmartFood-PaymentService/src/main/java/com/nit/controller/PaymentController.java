package com.nit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.nit.entity.Payment;
import com.nit.entity.PaymentStatus;
import com.nit.service.PaymentService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/payments")
public class PaymentController {
	@Autowired
	private PaymentService paymentservice;
	
	@PostMapping
	public ResponseEntity<Payment> createPayments(@Valid @RequestBody Payment payment)
	{
		Payment savedPayment=paymentservice.createPayment(payment);
		return new ResponseEntity<>(savedPayment,HttpStatus.CREATED);
	}
	@GetMapping
	public ResponseEntity<List<Payment>> getAllPayments(){
		return ResponseEntity.ok(paymentservice.getAllPayments());
	}
	@GetMapping("/{id}")
	public ResponseEntity<Payment> getPaymentById(@PathVariable Long id){
		return ResponseEntity.ok(paymentservice.getPaymentById(id));
	}
	
	@GetMapping("/user/{userId}")
	public ResponseEntity<List<Payment>> getPaymentByUserId(@PathVariable Long userId){
		return ResponseEntity.ok(paymentservice.getPaymentsByUserId(userId));
	}
	
	@GetMapping("/order/{orderId}")
	public ResponseEntity<List<Payment>> getPaymentByOrderId(@PathVariable Long orderId){
		return ResponseEntity.ok(paymentservice.getPaymentsByOrderId(orderId));
	}
	
	@GetMapping("/transaction/{transactionId}")
	public ResponseEntity<Payment> getPaymentByTransactionId(@PathVariable String transactionId){
		return ResponseEntity.ok(paymentservice.getPaymentByTransactionId(transactionId));
	}
	
	@PutMapping("/{id}/status")
	public ResponseEntity<Payment> updatePaymentStatus(@PathVariable Long id,@RequestParam PaymentStatus status)
	{
		return ResponseEntity.ok(paymentservice.updatePaymentStatus(id, status));
	}
	
	@PutMapping("/{id}/refund")
	public ResponseEntity<Payment> refundPayment(@PathVariable Long id)
	{
		return ResponseEntity.ok(paymentservice.refundPayment(id));
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deletePayment(@PathVariable Long id){
		paymentservice.deletePayment(id);
		return ResponseEntity.ok("Payment deleted successfully");
	}

}
