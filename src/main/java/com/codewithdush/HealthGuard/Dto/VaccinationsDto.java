package com.codewithdush.HealthGuard.Dto;

import com.codewithdush.HealthGuard.entity.User;
import com.codewithdush.HealthGuard.entity.Vaccinations;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.time.LocalDateTime;



@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class VaccinationsDto {

    private Long id;


    private User user;


    private String vaccineName;

    private int dosesReceived;

    private LocalDateTime nextDueDate;


    private Vaccinations.Status status;


}
