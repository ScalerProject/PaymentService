package com.scaler.paymentservicejan25.services;

import com.scaler.paymentservicejan25.paymentgateway.PaymentGateway;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {
    private PaymentGateway paymentGateway;

    public PaymentService(PaymentGateway paymentGateway) {
        this.paymentGateway = paymentGateway;
    }


    public String initiatePayment(long orderId, String phoneNumber) {
        return paymentGateway.initiatePayment(orderId, phoneNumber);
    }
}
