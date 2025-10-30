package com.HMS_Apk.Hospital.Management.System.doclogin_Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.HMS_Apk.Hospital.Management.System.doclogin.entity.Report;
import com.HMS_Apk.Hospital.Management.System.doclogin_Service.ReportService;

@RestController
@RequestMapping("/api/reports")
public class ReportController {

    @Autowired
    private ReportService reportService;

    // Get all reports
    @GetMapping
    public List<Report> getReports() {
        return reportService.getAllReports();
    }

    // Get only urgent reports (alerts)
    @GetMapping("/urgent")
    public List<Report> getUrgentReports() {
        return reportService.getReportsByStatus("Urgent");
    }

    // Add new report
    @PostMapping
    public Report addReport(@RequestBody Report report) {
        return reportService.addReport(report);
    }

    // Delete a report
    @DeleteMapping("/{id}")
    public void deleteReport(@PathVariable Long id) {
        reportService.deleteReport(id);
    }
}

