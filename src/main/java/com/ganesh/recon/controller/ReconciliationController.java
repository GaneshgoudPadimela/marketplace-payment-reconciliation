package com.ganesh.recon.controller;
import com.ganesh.recon.model.*; import com.ganesh.recon.service.ReconciliationService;
import org.springframework.web.bind.annotation.*; import java.math.BigDecimal; import java.util.List;
@RestController @RequestMapping("/api/reconciliation")
public class ReconciliationController {
  private final ReconciliationService service; public ReconciliationController(ReconciliationService s){this.service=s;}
  @GetMapping("/{batchId}") public ReconciliationResult sample(@PathVariable String batchId){
    var payments=List.of(new PaymentRecord("pay-1","ord-1",new BigDecimal("50.00"),"USD"), new PaymentRecord("pay-2","ord-2",new BigDecimal("25.00"),"USD"));
    var settlements=List.of(new SettlementRecord("pay-1",new BigDecimal("50.00"),"USD"));
    return service.reconcile(batchId,payments,settlements);
  }
}
