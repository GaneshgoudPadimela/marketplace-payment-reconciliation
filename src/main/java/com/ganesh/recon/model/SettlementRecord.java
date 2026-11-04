package com.ganesh.recon.model; import java.math.BigDecimal;
public record SettlementRecord(String paymentId, BigDecimal settledAmount, String currency) {}
