package com.ganesh.recon.model; import java.util.List;
public record ReconciliationResult(String batchId, int matched, int mismatched, int missing, List<String> mismatchPaymentIds, List<String> missingPaymentIds) {}
