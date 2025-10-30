package com.HMS_Apk.Hospital.Management.System.doclogin_Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.HMS_Apk.Hospital.Management.System.doclogin.entity.Report;

@Repository
public interface ReportRepository extends JpaRepository<Report, Long> {
    List<Report> findByStatus(String status);
}
