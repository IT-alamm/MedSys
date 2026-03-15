package com.MedSys.service;

import com.MedSys.dto.BillingDto;
import com.MedSys.entities.Billing;
import com.MedSys.repo.BillingRepo;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BillingServiceImpl implements BillingService {

    private final BillingRepo billingRepo;
    private final ModelMapper modelMapper;

    public BillingServiceImpl(BillingRepo billingRepo, ModelMapper modelMapper) {
        this.billingRepo = billingRepo;
        this.modelMapper = modelMapper;
    }


    @Override
    public BillingDto createBill(BillingDto billingDto) {
        Billing billing = modelMapper.map(billingDto, Billing.class);
        Billing saved = billingRepo.save(billing);
        return modelMapper.map(saved, BillingDto.class);
    }

    @Override
    public BillingDto getBillById(Long id) {

        Billing billing = billingRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Bill not found"));
        return modelMapper.map(billing, BillingDto.class);
    }

    @Override
    public List<BillingDto> getAllBills() {
        return billingRepo.findAll()
                .stream()
                .map(b -> modelMapper.map(b, BillingDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public BillingDto updateBill(Long id, BillingDto billingDto) {

        Billing billing = billingRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Bill not found"));

        billing.setPatientId(billingDto.getPatientId());
        billing.setAppointmentId(billingDto.getAppointmentId());
        billing.setAmount(billingDto.getAmount());
        billing.setPaymentStatus(billingDto.getPaymentStatus());
        billing.setBillDate(billingDto.getBillDate());

        Billing updated = billingRepo.save(billing);

        return modelMapper.map(updated, BillingDto.class);
    }

    @Override
    public void deleteBill(Long id) {
        Billing billing = billingRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Bill not found"));
        billingRepo.delete(billing);

    }
}
