package com.codewithdush.HealthGuard.Dto;

import com.codewithdush.HealthGuard.entity.Outbreaks;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.time.LocalDateTime;



@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class OutBreaksDto {

    private Long id;

    private Outbreaks.Disease disease;

    private int casesReported;


    private String location;

//    @Column(columnDefinition = "geometry")
//    private Geometry mapData;

    private LocalDateTime reportedAt;
}
