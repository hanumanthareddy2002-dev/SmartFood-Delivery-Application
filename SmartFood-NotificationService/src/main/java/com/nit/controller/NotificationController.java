package com.nit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nit.dto.NotificationRequest;
import com.nit.service.NotificationService;

@RestController
@RequestMapping("/notifications")
public class NotificationController {
	@Autowired
	private NotificationService notificationservice;
	

    @PostMapping("/email")
    public ResponseEntity<String> sendEmail(@RequestBody NotificationRequest request) {

        return ResponseEntity.ok(notificationservice.sendEmail(request));
     }
    @PostMapping("/sms")
    public ResponseEntity<String> sendSms(@RequestBody NotificationRequest request) {

        return ResponseEntity.ok(notificationservice.sendSms(request));

    }
    
    @PostMapping("/order-confirmation")
    public ResponseEntity<String>sendOrderConfirmation( @RequestBody NotificationRequest request) {

        return ResponseEntity.ok( notificationservice.sendOrderConfirmation(request));

    }
    
    @PostMapping("/payment")
    public ResponseEntity<String>sendPaymentNotification(@RequestBody NotificationRequest request) {

        return ResponseEntity.ok(notificationservice.sendPaymentNotification(request));

    }
    
    @PostMapping("/delivery")
    public ResponseEntity<String>sendDeliveryNotification(@RequestBody NotificationRequest request) {

        return ResponseEntity.ok(notificationservice.sendDeliveryNotification(request));

    }


}
