package com.ganesh.recon;
import com.ganesh.recon.model.*; import com.ganesh.recon.service.ReconciliationService; import org.junit.jupiter.api.Test; import java.math.BigDecimal; import java.util.List; import static org.junit.jupiter.api.Assertions.*;
class ReconciliationServiceTest { @Test void flagsMissingSettlement(){ var r=new ReconciliationService().reconcile("b1",List.of(new PaymentRecord("p1","o1",BigDecimal.TEN,"USD")),List.of()); assertEquals(1,r.missing()); } }
