package com.codewithdush.HealthGuard.Dto;

import com.codewithdush.HealthGuard.entity.User;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;



@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SymptomsDto {


    private Long id;


    private User user;


    private List<String> symptoms;


    private LocalDateTime submittedAt;

}
