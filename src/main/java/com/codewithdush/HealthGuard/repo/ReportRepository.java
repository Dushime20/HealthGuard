package com.codewithdush.HealthGuard.repo;

import com.codewithdush.HealthGuard.entity.Reports;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReportRepository extends JpaRepository<Reports,Long> {

   // @Query("SELECT DISTINCT r.reportType FROM Reports r")
    List<Reports> findReportByReportType(String reportType);



}
