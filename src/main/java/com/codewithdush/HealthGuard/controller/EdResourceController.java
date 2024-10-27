package com.codewithdush.HealthGuard.controller;

import com.codewithdush.HealthGuard.Dto.Response;
import com.codewithdush.HealthGuard.request.EdResourceRequest;

import com.codewithdush.HealthGuard.service.Intrefac.IEdResourceService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/educationalResource")
public class EdResourceController {

    @Autowired
    private IEdResourceService edResourceService;

    @PostMapping("/add")
    public ResponseEntity<Response> addEdResource(

            @RequestBody @Valid EdResourceRequest edResourceRequest
            ){

        Response response = edResourceService.createEdResource(edResourceRequest.getTitle(),edResourceRequest.getUrl(),edResourceRequest.getContentType(), edResourceRequest.getDescription(), edResourceRequest.getCreatedAt());
        return ResponseEntity.status(response.getStatusCode()).body(response);
    }

    @GetMapping("/all")
    public ResponseEntity<Response> getAllEdResource(){
        Response response = edResourceService.getAllEdResource();
        return ResponseEntity.status(response.getStatusCode()).body(response);

    }
    @GetMapping("/get_by_id/{resourceId}")
    public ResponseEntity<Response> getAllReportByReportId(
            @PathVariable Long resourceId

    ){
        Response response = edResourceService.getEdResourceById(resourceId);
        return ResponseEntity.status(response.getStatusCode()).body(response);

    }
}
