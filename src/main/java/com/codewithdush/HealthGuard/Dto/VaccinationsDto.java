package com.codewithdush.HealthGuard.Dto;

import com.codewithdush.HealthGuard.entity.User;
import com.codewithdush.HealthGuard.entity.Vaccinations;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
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


    private String status;

    private String recipientName;


    private String recipientPhone;


    private String recipientDistrict;


    private String recipientSector;


    private String recipientVillage;


    private String recipientCell;


    private LocalDateTime createdAt;


}
