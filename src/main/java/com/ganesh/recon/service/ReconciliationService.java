package com.ganesh.recon.service;
import com.ganesh.recon.model.*; import org.springframework.stereotype.Service; import java.util.*;
@Service public class ReconciliationService {
  public ReconciliationResult reconcile(String batchId, List<PaymentRecord> payments, List<SettlementRecord> settlements){
    Map<String,SettlementRecord> byId=new HashMap<>(); for(var s:settlements) byId.put(s.paymentId(),s);
    int matched=0; List<String> mismatched=new ArrayList<>(), missing=new ArrayList<>();
    for(var p: payments){ var s=byId.get(p.paymentId()); if(s==null) missing.add(p.paymentId());
      else if(s.settledAmount().compareTo(p.amount())!=0) mismatched.add(p.paymentId()); else matched++; }
    return new ReconciliationResult(batchId, matched, mismatched.size(), missing.size(), mismatched, missing);
  }
}
