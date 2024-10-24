package com.codewithdush.HealthGuard.Dto;

import com.codewithdush.HealthGuard.entity.User;
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


    private String citeDistrict;

    private String citeSector;
    private String citeCell;

    private int availability;

    private User user;

    private String contactInfo;

    private LocalDateTime updatedAt;

}
