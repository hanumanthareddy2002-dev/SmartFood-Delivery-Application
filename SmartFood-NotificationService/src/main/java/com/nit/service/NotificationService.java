package com.nit.service;

import com.nit.dto.NotificationRequest;

public interface NotificationService {
	String sendEmail(NotificationRequest request);

    String sendSms(NotificationRequest request);

    String sendOrderConfirmation(NotificationRequest request);

    String sendPaymentNotification(NotificationRequest request);

    String sendDeliveryNotification(NotificationRequest request);
	

}
