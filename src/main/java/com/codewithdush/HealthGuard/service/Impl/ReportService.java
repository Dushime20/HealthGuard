package com.codewithdush.HealthGuard.service.Impl;

import com.codewithdush.HealthGuard.Dto.CampaignsDto;
import com.codewithdush.HealthGuard.Dto.ReportsDto;
import com.codewithdush.HealthGuard.Dto.Response;
import com.codewithdush.HealthGuard.Dto.UserDto;
import com.codewithdush.HealthGuard.entity.Campaigns;
import com.codewithdush.HealthGuard.entity.Reports;
import com.codewithdush.HealthGuard.entity.User;
import com.codewithdush.HealthGuard.exception.OurException;
import com.codewithdush.HealthGuard.repo.ReportRepository;
import com.codewithdush.HealthGuard.repo.UserRepository;
import com.codewithdush.HealthGuard.service.Intrefac.IReportService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class ReportService implements IReportService {

    @Autowired
    private ReportRepository reportRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public Response createReport(String reportType,String description, Long userId, String status, LocalDateTime createdAt, LocalDateTime updatedAt) {


        Response response = new Response();
        try{

            User user = userRepository.findById(userId).orElseThrow(()->new OurException("user not found"));
            Reports reports = new Reports();
            reports.setUser(user);
            reports.setReportType(reportType);
            reports.setStatus(status);
            reports.setDescription(description);
            reports.setCreatedAt(LocalDateTime.now());
            reports.setUpdatedAt(LocalDateTime.now());

            Reports savedReport = reportRepository.save(reports);
            ReportsDto reportsDto = modelMapper.map(savedReport,ReportsDto.class);


            response.setStatusCode(200);
            response.setMessage("success");
            response.setReports(reportsDto);


        } catch (OurException e) {
            response.setStatusCode(404);
            response.setMessage(e.getMessage());
        } catch (Exception e) {
            response.setStatusCode(500);
            response.setMessage("Error error creating reports: " + e.getMessage());
        }

        return response;
    }
   @Override
   public Response getAllReports() {
       Response response = new Response();
       try {
           // Retrieve the list of reports sorted by ID in descending order
           List<Reports> reportsList = reportRepository.findAll(Sort.by(Sort.Direction.DESC, "id"));

           // Map the list of Reports to a list of ReportsDto
           List<ReportsDto> reportsDtoList = reportsList.stream()
                   .map(report -> modelMapper.map(report, ReportsDto.class))
                   .collect(Collectors.toList());

           response.setStatusCode(200);
           response.setMessage("success");
           response.setReportDtoList(reportsDtoList);
       } catch (OurException e) {
           response.setStatusCode(404);
           response.setMessage(e.getMessage());
       } catch (Exception e) {
           response.setStatusCode(500);
           response.setMessage("Error getting all report: " + e.getMessage());
       }

       return response;
   }




    @Override
    public Response findReportByReportType(String reportType) {
        Response response = new Response();
        try {
            // Fetch reports based on the report type
            List<Reports> reportsList = reportRepository.findReportByReportType(reportType);
            System.out.println("Fetched Reports: " + reportsList);

            // Map the list of Reports to a list of ReportsDto
            List<ReportsDto> reportsDtoList = reportsList.stream()
                    .map(report -> modelMapper.map(report, ReportsDto.class))
                    .collect(Collectors.toList());

            response.setStatusCode(200);
            response.setMessage("success");
            response.setReportDtoList(reportsDtoList);
        } catch (Exception e) {
            response.setStatusCode(500);
            response.setMessage("Error getting all reports: " + e.getMessage());
        }
        return response;
    }


    @Override
    public Response deleteReport(Long reportId) {

        Response response = new Response();
        try{
            reportRepository.findById(reportId).orElseThrow(()-> new OurException("report not found"));
            reportRepository.deleteById(reportId);
        }
    catch (OurException e) {
            response.setStatusCode(404);
            response.setMessage(e.getMessage());
        } catch (Exception e) {
            response.setStatusCode(500);
            response.setMessage("Error getting all campaign: " + e.getMessage());
        }

        return response;
    }


    @Override
    public Response getReportById(Long reportId) {
        Response response = new Response();
        try{
         Reports reports =  reportRepository.findById(reportId).orElseThrow(()-> new OurException("report not found"));
         ReportsDto reportsDto = modelMapper.map(reports,ReportsDto.class);

            response.setStatusCode(200);
            response.setMessage("success");
            response.setReports(reportsDto);
        }
        catch (OurException e) {
            response.setStatusCode(404);
            response.setMessage(e.getMessage());
        } catch (Exception e) {
            response.setStatusCode(500);
            response.setMessage("Error getting all campaign: " + e.getMessage());
        }

        return response;
    }

}
