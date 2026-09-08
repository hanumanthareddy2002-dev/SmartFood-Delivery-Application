package com.nit.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name="payments")
@AllArgsConstructor
@NoArgsConstructor
public class Payment {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	@NotNull(message="Order ID is required")
	private Long orderId;
	@NotNull(message="User ID is required")
	private Long userId;
	@NotNull(message="Amount ID is required")
	@DecimalMin(value="0.01",message="Amount must be greater than zero")
	private Double amount;
	@NotBlank(message="Payment Method is required")
	private String paymentMethod;
	private String transactionId;
	
	@Enumerated(EnumType.STRING)
	private PaymentStatus status;
	private LocalDateTime paymentDate;
	private LocalDateTime refundDate;

}
