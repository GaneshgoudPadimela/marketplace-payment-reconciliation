package com.ganesh.recon.model; import java.math.BigDecimal;
public record PaymentRecord(String paymentId, String orderId, BigDecimal amount, String currency) {}
