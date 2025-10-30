package com.HMS_Apk.Hospital.Management.System.doclogin_Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.HMS_Apk.Hospital.Management.System.doclogin.entity.Medicine;
import com.HMS_Apk.Hospital.Management.System.doclogin_Repository.MedicineRepository;

@CrossOrigin(origins = "http://localhost:4200") // allow Angular
@RestController
@RequestMapping("/api/v3/medicines")
public class MedicineController {
	
	private final MedicineRepository medicineRepository;

	public MedicineController(MedicineRepository medicineRepository) {
		this.medicineRepository = medicineRepository;
	}

	// ✅ Create new medicine
	@PostMapping
	public Medicine createMedicine(@RequestBody Medicine medicine) {
		return medicineRepository.save(medicine);
	}

	// ✅ Get all medicines
	@GetMapping
	public List<Medicine> getAllMedicine() {
		return medicineRepository.findAll();
	}

	@GetMapping("/search")
	public ResponseEntity<List<Medicine>> searchMedicines(@RequestParam String keyword) {
	    List<Medicine> medicines = medicineRepository.findByNameContainingIgnoreCase(keyword);
	    if (medicines.isEmpty()) {
	        return ResponseEntity.noContent().build(); // No medicines found
	    }
	    return ResponseEntity.ok(medicines);
	}

	// ✅ Update medicine
	@PutMapping("/{id}")
	public ResponseEntity<Medicine> updateMedicine(@PathVariable Long id, @RequestBody Medicine updatedMedicine) {
		return medicineRepository.findById(id).map(medicine -> {
			medicine.setName(updatedMedicine.getName());
			medicine.setQuantity(updatedMedicine.getQuantity());
			medicine.setPrice(updatedMedicine.getPrice());
			medicine.setExpiryDate(updatedMedicine.getExpiryDate());
			return ResponseEntity.ok(medicineRepository.save(medicine));
		}).orElse(ResponseEntity.notFound().build());
	}

	// ✅ Delete medicine
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteMedicine(@PathVariable Long id) {
		if (!medicineRepository.existsById(id)) {
			return ResponseEntity.notFound().build();
		}
		medicineRepository.deleteById(id);
		return ResponseEntity.noContent().build();
	}
}
