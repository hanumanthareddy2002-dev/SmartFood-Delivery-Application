package com.nit.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Food {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	@NotNull(message="Restaurant ID is required")
	private Long restaurantId;
	@NotBlank(message="Food name is required")
	private String name;
	@NotBlank(message="Category is required")
	private String category;
	@NotNull(message="Price is required")
	private Double price;
	@NotNull(message="Availability is required")
	private Boolean available;
	

}
