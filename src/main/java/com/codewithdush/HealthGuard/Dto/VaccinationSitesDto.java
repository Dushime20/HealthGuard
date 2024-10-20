package com.codewithdush.HealthGuard.Dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.time.LocalDateTime;


@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class VaccinationSitesDto {



    private Long id;


    private String name;


    private String location;

    private int availability;

    private String contactInfo;

    private LocalDateTime updatedAt;

}
