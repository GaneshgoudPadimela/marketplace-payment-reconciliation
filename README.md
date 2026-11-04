# Marketplace Payment Reconciliation

A Spring Boot service that reconciles marketplace payment records against
settlement records - the kind of back-office check that catches missing,
duplicate, or amount-mismatched payments before payouts go out.

## What it does
- Loads payment records and settlement records for a batch
- Matches on `paymentId`, flags amount differences and missing settlements
- Exposes results via REST: `GET /api/reconciliation/{batchId}`
- Returns a summary count (matched / mismatched / missing) plus details

## Tech
Java 17, Spring Boot 3, Maven

## Run
```bash
mvn spring-boot:run
```

## Roadmap
- [ ] Read input from CSV / S3 instead of in-memory samples
- [ ] Persist results in Cassandra
- [ ] Scheduled daily reconciliation job
- [ ] Export mismatch report as CSV
