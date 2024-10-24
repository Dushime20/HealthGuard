package com.codewithdush.HealthGuard.controller;

import com.codewithdush.HealthGuard.Dto.Response;
import com.codewithdush.HealthGuard.request.CampaignRequest;
import com.codewithdush.HealthGuard.request.VaccineRequest;
import com.codewithdush.HealthGuard.service.Intrefac.IVaccineService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/vaccination")
public class VaccinationController {

    @Autowired
    private IVaccineService vaccineService;

    @PostMapping("/add/{userId}")
    @PreAuthorize("hasAuthority('Health Professional')")
    public ResponseEntity<Response> createVaccine(
            @PathVariable Long userId,
            @RequestBody @Valid VaccineRequest vaccineRequest
            ){

        Response response = vaccineService.createVaccine(userId,vaccineRequest.getVaccineName(),vaccineRequest.getDoseReceived(),vaccineRequest.getStatus(),vaccineRequest.getNextDueDate(),
                vaccineRequest.getRecipientName(),vaccineRequest.getRecipientPhone(),
                vaccineRequest.getRecipientDistrict(),vaccineRequest.getRecipientSector(),
                vaccineRequest.getRecipientVillage(), vaccineRequest.getRecipientCell(),
                vaccineRequest.getCreatedAt());
        return ResponseEntity.status(response.getStatusCode()).body(response);


    }
    @GetMapping("/all")
    public ResponseEntity<Response> getAllVaccine(){
        Response response = vaccineService.getAllPeopleVaccine();
        return ResponseEntity.status(response.getStatusCode()).body(response);

    }
    @GetMapping("/all/district")
    public ResponseEntity<Response> getByDistrict(
            @RequestParam String District
    ){
        Response response = vaccineService.getAllVaccinedPeopleByDistrict(District);
        return ResponseEntity.status(response.getStatusCode()).body(response);

    }
    @GetMapping("/all/sector")
    public ResponseEntity<Response> getBySector(
            @RequestParam String District,
            @RequestParam String sector
    ){
        Response response = vaccineService.getAllVaccinedPeopleBySector(sector,District);
        return ResponseEntity.status(response.getStatusCode()).body(response);

    }
    @GetMapping("/all/cell")
    public ResponseEntity<Response> getByCell(
            @RequestParam String District,
            @RequestParam String cell,
            @RequestParam String sector
    ){
        Response response = vaccineService.getAllVaccinedPeopleByCell(cell,District,sector);
        return ResponseEntity.status(response.getStatusCode()).body(response);

    }
    @GetMapping("/all/village")
    public ResponseEntity<Response> getByVillage(
            @RequestParam String District,
            @RequestParam String cell,
            @RequestParam String sector,
            @RequestParam String village
    ){
        Response response = vaccineService.getAllVaccinedPeopleByVillage(village,District,sector,cell);
        return ResponseEntity.status(response.getStatusCode()).body(response);

    }
    @GetMapping("/get-by-id/{vaccineId}")
    public ResponseEntity<Response> getByVaccineId(
            @PathVariable Long vaccineId
    ){
        Response response = vaccineService.getVaccinatedById(vaccineId);
        return ResponseEntity.status(response.getStatusCode()).body(response);

    }

}
