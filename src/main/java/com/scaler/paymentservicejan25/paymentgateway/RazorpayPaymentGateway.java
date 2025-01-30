package com.scaler.paymentservicejan25.paymentgateway;
import com.razorpay.PaymentLink;
import org.json.JSONObject;
import com.razorpay.Payment;
import com.razorpay.RazorpayClient;
import com.razorpay.RazorpayException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service
@Primary
public class RazorpayPaymentGateway implements PaymentGateway {
    @Value("${razorpay.keyId}")
    private String keyId;
    @Value("${razorpay.keySecret}")
    private String keySecret;
    private RazorpayClient razorpay = null;

    @Override
    public String initiatePayment(long orderId, String phoneNumber) {
        try {
            razorpay = new RazorpayClient(keyId, keySecret);
            JSONObject paymentLinkRequest = new JSONObject();
            paymentLinkRequest.put("amount",1000);
            paymentLinkRequest.put("currency","INR");
//            paymentLinkRequest.put("accept_partial",true);
//            paymentLinkRequest.put("first_min_partial_amount",100);
//            paymentLinkRequest.put("expire_by",1691097057);
//            paymentLinkRequest.put("reference_id","TS1989");
//            paymentLinkRequest.put("description","Payment for policy no #23456");
            paymentLinkRequest.put("callback_url","https://example-callback-url.com/");
            paymentLinkRequest.put("callback_method","get");

            PaymentLink payment = razorpay.paymentLink.create(paymentLinkRequest);

            return payment.get("short_url").toString();
        } catch (RazorpayException e) {
            throw new RuntimeException(e);
        }

    }
}
