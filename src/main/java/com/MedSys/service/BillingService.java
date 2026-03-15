package com.MedSys.service;

import com.MedSys.dto.BillingDto;

import java.util.List;

public interface BillingService {

    BillingDto createBill(BillingDto billingDTO);

    BillingDto getBillById(Long id);

    List<BillingDto> getAllBills();

    BillingDto updateBill(Long id, BillingDto billingDTO);

    void deleteBill(Long id);
}
