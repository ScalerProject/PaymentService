package com.scaler.paymentservicejan25.paymentgateway;

public class StripePaymentGateway implements PaymentGateway {
    @Override
    public String initiatePayment(long orderId, String phoneNumber) {
        return "Payment initiated using Stripe";
    }
}
