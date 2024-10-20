package com.codewithdush.HealthGuard.controller;

import com.codewithdush.HealthGuard.Dto.Response;
import com.codewithdush.HealthGuard.request.CampaignRequest;
import com.codewithdush.HealthGuard.service.Intrefac.ICampaignService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/campaign")
public class CampaignController {

    @Autowired
    private ICampaignService campaignService;

    @PostMapping("/add/{userId}")
    @PreAuthorize("hasAuthority('Community Leaders')")
    public ResponseEntity<Response> createCampaign(
            @PathVariable Long userId,
            @RequestBody @Valid CampaignRequest campaignRequest
            ){
        // Extract individual fields from campaignRequest
        String title = campaignRequest.getTitle();
        String address = campaignRequest.getAddress();
        String description = campaignRequest.getDescription();
        LocalDateTime startDate = campaignRequest.getStartDate();
        LocalDateTime endDate = campaignRequest.getEndDate();
        LocalDateTime updatedAt = campaignRequest.getUpdatedAt();

        // Call the service method with individual parameters
        Response response = campaignService.createCampaign(title, address, description, startDate, endDate, userId, updatedAt);
        return ResponseEntity.status(response.getStatusCode()).body(response);
    }

    @GetMapping("/all")
    public ResponseEntity<Response> getAllCampaign(){
        Response response = campaignService.getAllCampaign();
        return ResponseEntity.status(response.getStatusCode()).body(response);

    }
    @GetMapping("/get_campaign_by_id/{campaignId}")
    public ResponseEntity<Response> getAllReportByReportId(
            @PathVariable Long campaignId

    ){
        Response response = campaignService.getCampaignBYId(campaignId);
        return ResponseEntity.status(response.getStatusCode()).body(response);

    }

    @GetMapping("get_campaign_by_date_and_location")
    public ResponseEntity<Response>getCampaignByDateAndLocation(
            @RequestParam(value = "startDate",required = false) LocalDateTime startDate,
            @RequestParam(value = "address",required = false) String address

    ){
        Response response = campaignService.getCampaignByStartingDateAndAddress(startDate,address);
        return ResponseEntity.status(response.getStatusCode()).body(response);
    }

    @DeleteMapping("/delete/{campaignId}")
    @PreAuthorize("hasAuthority('Community Leaders')")
    public ResponseEntity<Response>deleteCampaign(@PathVariable Long campaignId){
        Response response = campaignService.deleteCampaign(campaignId);
        return ResponseEntity.status(response.getStatusCode()).body(response);
    }
}
