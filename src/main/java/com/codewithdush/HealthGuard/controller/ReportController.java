package com.codewithdush.HealthGuard.controller;


import com.codewithdush.HealthGuard.Dto.Response;
import com.codewithdush.HealthGuard.service.Intrefac.IReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/report")
public class ReportController {

    @Autowired
    private IReportService reportService;

    @PostMapping("/add/{userId}")
    public ResponseEntity<Response> createReport(
            @PathVariable Long userId,
            @RequestParam(value = "reportType") String reportType,
            @RequestParam(value = "description") String description,
            @RequestParam(value = "status") String status
    ) {
        Response response = reportService.createReport(reportType, description, userId, status, null, null);
        return ResponseEntity.status(response.getStatusCode()).body(response);
    }

    @GetMapping("/all")
    @PreAuthorize("hasAuthority('Health Professional')")
    public ResponseEntity<Response> getAllReport(){
        Response response = reportService.getAllReports();
        return ResponseEntity.status(response.getStatusCode()).body(response);

    }
    @GetMapping("/all_by_reportType")
    @PreAuthorize("hasAuthority('Health Professional')")
    public ResponseEntity<Response> getAllReportByReportType(
            @RequestParam(value = "reportType") String reportType

    ){
        Response response = reportService.findReportByReportType(reportType);
        return ResponseEntity.status(response.getStatusCode()).body(response);

    }

    @GetMapping("/get_by_reportType/{reportId}")
    @PreAuthorize("hasAuthority('Health Professional')")
    public ResponseEntity<Response> getAllReportByReportId(
            @PathVariable Long reportId

    ){
        Response response = reportService.getReportById(reportId);
        return ResponseEntity.status(response.getStatusCode()).body(response);

    }

    @DeleteMapping("/delete/{reportId}")
    @PreAuthorize("hasAuthority('Health Professional')")
    public ResponseEntity<Response>deleteReport(@PathVariable Long reportId){
        Response response = reportService.deleteReport(reportId);
        return ResponseEntity.status(response.getStatusCode()).body(response);
    }
}
