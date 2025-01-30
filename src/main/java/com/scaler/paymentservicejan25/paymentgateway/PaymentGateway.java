package com.scaler.paymentservicejan25.paymentgateway;

public interface PaymentGateway {
    String initiatePayment(long orderId, String phoneNumber);
}
