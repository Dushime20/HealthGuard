package com.codewithdush.HealthGuard.Dto;

import com.codewithdush.HealthGuard.entity.User;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.time.LocalDateTime;



@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ReportsDto {


    private Long id;

    private Long userId;

    private String reportType;

    private String description;


    private String status;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

}
