package com.codewithdush.HealthGuard.Dto;

import com.codewithdush.HealthGuard.entity.User;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;


import java.time.LocalDateTime;


@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CampaignsDto {

    private Long id;


    private String title;

    private String description;

    private LocalDateTime startDate;

    private LocalDateTime endDate;

    private String address;

    private User createdBy;


    private LocalDateTime updatedAt;

}
