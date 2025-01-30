package com.scaler.paymentservicejan25.controllers;

import com.scaler.paymentservicejan25.services.PaymentService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/payments")
public class PaymentController {
    PaymentService paymentService;

    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @PostMapping("/initiate/{orderId}")
    public String initiatePayment(@PathVariable("orderId") Long orderId, String phoneNumber) {
        return paymentService.initiatePayment(orderId, phoneNumber);
    }
}
