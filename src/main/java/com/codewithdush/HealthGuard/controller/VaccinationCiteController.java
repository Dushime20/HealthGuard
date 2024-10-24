package com.codewithdush.HealthGuard.controller;

import com.codewithdush.HealthGuard.Dto.Response;
import com.codewithdush.HealthGuard.request.VaccinationCiteRequest;
import com.codewithdush.HealthGuard.service.Intrefac.IVaccinationCitesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/vaccinationCite")
public class VaccinationCiteController {

    @Autowired
    private IVaccinationCitesService vaccinationCitesService;

    @PostMapping("/add/{userId}")
    @PreAuthorize("hasAuthority('Community Leaders')")
    public ResponseEntity<Response> createVaccinationCite(
            @PathVariable Long userId,
            @RequestBody VaccinationCiteRequest vaccinationCiteRequest
            ){
        Response response = vaccinationCitesService.addVaccinationCites(userId,vaccinationCiteRequest.getName(), vaccinationCiteRequest.getCiteDistrict(), vaccinationCiteRequest.getCiteSector(), vaccinationCiteRequest.getCiteCell(), vaccinationCiteRequest.getAvailability(), vaccinationCiteRequest.getContactInfo(), vaccinationCiteRequest.getUpdatedAt());
        return ResponseEntity.status(response.getStatusCode()).body(response);
    }

    @GetMapping("/all")
    public ResponseEntity<Response> getAllVaccinationCit(){
        Response response = vaccinationCitesService.getAllVaccinationCite();
        return ResponseEntity.status(response.getStatusCode()).body(response);

    }

    @GetMapping("/get_cite_by_name")
    public ResponseEntity<Response> getVaccinationCitByName(
            @RequestParam String district,
            @RequestParam String sector,
            @RequestParam String cell
    ){
        Response response = vaccinationCitesService.getVaccinationCiteByCiteName(district,sector,cell);
        return ResponseEntity.status(response.getStatusCode()).body(response);

    }


}
