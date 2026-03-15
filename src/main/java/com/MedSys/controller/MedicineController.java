package com.MedSys.controller;


import com.MedSys.entities.Medicine;
import com.MedSys.service.MedicineService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/medicines")
public class MedicineController {

    private final MedicineService medService;

    public MedicineController(MedicineService medService) {
        this.medService = medService;
    }

    @PostMapping("/add")
    public ResponseEntity<?> add(@RequestBody Medicine medicine){
        Medicine saved = medService.addMedicine(medicine);

        Map<String,Object> res = new HashMap<>();
        res.put("message","Medicine added");
        res.put("data", saved);

        return ResponseEntity.ok(res);
    }

    @GetMapping("/all")
    public ResponseEntity<?> getAll(){
        List<Medicine> list = medService.getAllMedicines();
        return ResponseEntity.ok(list);
    }

    @GetMapping("getById/{id}")
    public ResponseEntity<?> getById(@PathVariable Long id){
        return ResponseEntity.ok(medService.getMedicineById(id));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable Long id,
                                    @RequestBody Medicine medicine){
        return ResponseEntity.ok(medService.updateMedicine(id, medicine));
    }

    @DeleteMapping("/deleteById/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        medService.deleteMedicine(id);
        return ResponseEntity.ok("Medicine deleted");
    }

    @GetMapping("/searchByName")
    public ResponseEntity<?> search(@RequestParam String name){
        return ResponseEntity.ok(medService.searchMedicine(name));
    }

    @GetMapping("/low-stock")
    public ResponseEntity<?> lowStock(@RequestParam int quantity){
        return ResponseEntity.ok(medService.getLowStockMedicines(quantity));
    }
}
