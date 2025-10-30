package com.HMS_Apk.Hospital.Management.System.doclogin_Service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.HMS_Apk.Hospital.Management.System.doclogin.entity.Medicine;
import com.HMS_Apk.Hospital.Management.System.doclogin_Repository.MedicineRepository;

@Service
public class MedicineService {

    private final MedicineRepository medicineRepository;

    public MedicineService(MedicineRepository medicineRepository) {
        this.medicineRepository = medicineRepository;
    }

    public List<Medicine> getAllMedicines() {
        return medicineRepository.findAll();
    }

    public Optional<Medicine> getMedicineById(Long id) {
        return medicineRepository.findById(id);
    }

    public Medicine saveMedicine(Medicine medicine) {
        return medicineRepository.save(medicine);
    }

    public void deleteMedicine(Long id) {
        medicineRepository.deleteById(id);
    }
}