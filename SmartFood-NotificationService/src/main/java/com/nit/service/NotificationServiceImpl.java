package com.nit.service;

import org.springframework.stereotype.Service;

import com.nit.dto.NotificationRequest;

@Service
public class NotificationServiceImpl implements NotificationService
{

	@Override
	public String sendEmail(NotificationRequest request) {
		
		IO.println("--------------------------------");
        IO.println("EMAIL NOTIFICATION");
        IO.println("--------------------------------");

        IO.println("Recipient : " + request.getRecipient());

        IO.println("Subject   : " + request.getSubject());

        IO.println( "Message   : " + request.getMessage());

         IO.println("--------------------------------");


        return "Email notification sent successfully";
	}

	@Override
	public String sendSms(NotificationRequest request) {
		IO.println("--------------------------------");
        IO.println("SMS NOTIFICATION");
        IO.println("--------------------------------");

        IO.println("Mobile : " + request.getRecipient());
        IO.println( "Message   : " + request.getMessage());

         IO.println("--------------------------------");


        return "SMS notification sent successfully";
	}

	@Override
	public String sendOrderConfirmation(NotificationRequest request) {
		IO.println("--------------------------------");
        IO.println("ORDER CONFIRMATION");
        IO.println("--------------------------------");
        
        IO.println("User ID  : "+request.getUserId());
        IO.println("Recipient : " + request.getRecipient());
        IO.println( "Message   : " + request.getMessage());

         IO.println("--------------------------------");


        return "Order confirmation notification sent successfully";
	}

	@Override
	public String sendPaymentNotification(NotificationRequest request) {
		IO.println("--------------------------------");
        IO.println("PAYMENT NOTIFICATION");
        IO.println("--------------------------------");
        
        IO.println("User ID  : "+request.getUserId());
        IO.println("Recipient : " + request.getRecipient());
        IO.println( "Message   : " + request.getMessage());

         IO.println("--------------------------------");


        return "Payment notification sent successfully";
	}

	@Override
	public String sendDeliveryNotification(NotificationRequest request) {
		IO.println("--------------------------------");
        IO.println("DELIVERY NOTIFICATION");
        IO.println("--------------------------------");
        
        IO.println("User ID  : "+request.getUserId());
        IO.println("Recipient : " + request.getRecipient());
        IO.println( "Message   : " + request.getMessage());

         IO.println("--------------------------------");


        return "Delivery notification sent successfully";
	}

}
