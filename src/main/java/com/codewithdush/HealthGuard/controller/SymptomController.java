package com.codewithdush.HealthGuard.controller;


import com.codewithdush.HealthGuard.Dto.Response;
import com.codewithdush.HealthGuard.request.CampaignRequest;
import com.codewithdush.HealthGuard.request.SymptomRequest;
import com.codewithdush.HealthGuard.service.Intrefac.ISymptomService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/symptoms")
public class SymptomController {

    @Autowired
    private ISymptomService symptomService;


    @PostMapping("/add/{userId}")
    public ResponseEntity<Response> createSymptom(
            @PathVariable Long userId,
            @RequestBody @Valid SymptomRequest symptomRequest
            ){

        Response response = symptomService.createUserSymptoms(userId,symptomRequest.getSymptoms(),symptomRequest.getDescription(),symptomRequest.getSubmittedAt());
        return ResponseEntity.status(response.getStatusCode()).body(response);
    }

    @GetMapping("/all")
    public ResponseEntity<Response> getAllSymptom(){
        Response response = symptomService.getAllSymptoms();
        return ResponseEntity.status(response.getStatusCode()).body(response);

    }
    @GetMapping("/get_symptom_by_id/{symptomId}")
    public ResponseEntity<Response> getAllReportByReportId(
            @PathVariable Long symptomId

    ){
        Response response = symptomService.getSymptomsById(symptomId);
        return ResponseEntity.status(response.getStatusCode()).body(response);

    }
}
