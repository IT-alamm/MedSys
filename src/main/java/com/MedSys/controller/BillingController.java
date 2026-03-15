package com.MedSys.controller;

import com.MedSys.dto.BillingDto;
import com.MedSys.service.BillingService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/billing")
public class BillingController {

    private final BillingService billingService;

    public BillingController(BillingService billingService) {
        this.billingService = billingService;
    }

    @PostMapping("/create")
    public ResponseEntity<BillingDto> createBill(@RequestBody BillingDto billingDto) {

        BillingDto saved = billingService.createBill(billingDto);
        return ResponseEntity.ok(saved);
    }

    @GetMapping("/getBillById/{id}")
    public ResponseEntity<BillingDto> getBillById(@PathVariable Long id) {

        BillingDto bill = billingService.getBillById(id);
        return ResponseEntity.ok(bill);
    }

    @GetMapping("/getAllBills")
    public ResponseEntity<List<BillingDto>> getAllBills() {

        return ResponseEntity.ok(billingService.getAllBills());
    }

    @PutMapping("/{id}")
    public ResponseEntity<BillingDto> updateBill(
            @PathVariable Long id,
            @RequestBody BillingDto billingDto) {

        BillingDto updated = billingService.updateBill(id, billingDto);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/deleteBill/{id}")
    public ResponseEntity<String> deleteBill(@PathVariable Long id) {

        billingService.deleteBill(id);
        return ResponseEntity.ok("Bill deleted successfully");
    }
}
