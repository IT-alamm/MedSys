package com.MedSys.repo;

import com.MedSys.entities.Medicine;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MedicineRepository extends JpaRepository<Medicine, Long> {
    List<Medicine> findByNameContaining(String name);

    List<Medicine> findByStockQuantityLessThan(int quantity);
}
