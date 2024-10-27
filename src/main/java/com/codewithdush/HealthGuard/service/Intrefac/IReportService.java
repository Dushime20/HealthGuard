package com.codewithdush.HealthGuard.service.Intrefac;

import com.codewithdush.HealthGuard.Dto.Response;
import com.codewithdush.HealthGuard.entity.User;

import java.time.LocalDateTime;

public interface IReportService {

    Response createReport(String reportType,String description, Long userId, String status,String address, LocalDateTime createdAt,LocalDateTime updatedAt);
    Response getAllReports();
    Response findReportByReportType(String reportType);
    Response deleteReport(Long reportId);
    Response getReportById(Long reportId);

}
