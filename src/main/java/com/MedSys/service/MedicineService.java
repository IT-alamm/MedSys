package com.MedSys.service;

import com.MedSys.entities.Medicine;

import java.util.List;

public interface MedicineService {

    Medicine addMedicine(Medicine medicine);

    List<Medicine> getAllMedicines();

    Medicine getMedicineById(Long id);

    Medicine updateMedicine(Long id, Medicine medicine);

    void deleteMedicine(Long id);

    List<Medicine> searchMedicine(String name);

    List<Medicine> getLowStockMedicines(int quantity);
}
