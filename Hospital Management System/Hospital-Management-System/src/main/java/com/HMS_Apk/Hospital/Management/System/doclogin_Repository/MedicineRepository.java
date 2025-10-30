package com.HMS_Apk.Hospital.Management.System.doclogin_Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.HMS_Apk.Hospital.Management.System.doclogin.entity.Medicine;

@Repository
public interface MedicineRepository extends JpaRepository<Medicine, Long> {

	List<Medicine> findByNameContainingIgnoreCase(String keyword);


}
