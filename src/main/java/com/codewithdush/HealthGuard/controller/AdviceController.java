package com.codewithdush.HealthGuard.controller;

import com.codewithdush.HealthGuard.Dto.Response;
import com.codewithdush.HealthGuard.service.Intrefac.IAdviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/advice")
public class AdviceController {

    @Autowired
    private IAdviceService adviceService;

    // Endpoint for doctor to create a response for a symptom
    @PostMapping("/add/{symptomId}/{doctorId}")
    @PreAuthorize("hasAuthority('Health Professional')")
    public ResponseEntity<Response> createAdvice(
            @PathVariable Long symptomId,
            @PathVariable Long doctorId,
            @RequestBody String message) {

        Response response = adviceService.createAdvice(symptomId, doctorId, message);
        return ResponseEntity.status(response.getStatusCode()).body(response);
    }

    // Endpoint for patient to retrieve response for a specific symptom
    @GetMapping("/patient-response")
    public ResponseEntity<Response> getPatientResponse(
            @RequestParam Long symptomId,
            @RequestParam Long patientId) {

        Response response = adviceService.getPatientResponse(symptomId, patientId);
        return ResponseEntity.status(response.getStatusCode()).body(response);
    }
}
