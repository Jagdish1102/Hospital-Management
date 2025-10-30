package com.HMS_Apk.Hospital.Management.System.doclogin_Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.HMS_Apk.Hospital.Management.System.doclogin.entity.Report;
import com.HMS_Apk.Hospital.Management.System.doclogin_Repository.ReportRepository;

@Service
public class ReportService {
    @Autowired
    private ReportRepository reportRepository;

    public List<Report> getAllReports() {
        return reportRepository.findAll();
    }

    public Report addReport(Report report) {
        return reportRepository.save(report);
    }

    public List<Report> getReportsByStatus(String status) {
        return reportRepository.findByStatus(status);
    }

    public void deleteReport(Long id) {
        reportRepository.deleteById(id);
    }
}
