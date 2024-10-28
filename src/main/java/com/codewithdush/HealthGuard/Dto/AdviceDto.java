package com.codewithdush.HealthGuard.Dto;

import com.codewithdush.HealthGuard.entity.Symptoms;
import com.codewithdush.HealthGuard.entity.User;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.Column;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AdviceDto {

    private Long id;

    private Symptoms symptom;

    private User doctor;

    private String responseText;

    private LocalDateTime responseDate;
}
