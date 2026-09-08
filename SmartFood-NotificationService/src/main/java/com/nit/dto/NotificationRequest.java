package com.nit.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NotificationRequest {
	private Long userId;
	private String recipient;
	private String subject;
	private String message;

}
