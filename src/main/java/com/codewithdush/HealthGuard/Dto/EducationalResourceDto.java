package com.codewithdush.HealthGuard.Dto;

import com.codewithdush.HealthGuard.entity.EducationalResource;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.time.LocalDateTime;



@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class EducationalResourceDto {

    private Long id;


    private String title;

    private String contentType;

    private String description;


    private String url;

    private LocalDateTime createdAt;
}
