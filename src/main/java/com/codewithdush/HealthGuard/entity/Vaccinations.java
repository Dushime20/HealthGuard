package com.codewithdush.HealthGuard.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@Entity
@Table(name = "vaccinations")
public class Vaccinations {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    @JsonIgnore
    private User user;

    @NotBlank(message = "Vaccine name is mandatory")
    private String vaccineName;

    @Column(name = "doses_received")
    private int dosesReceived;

    private LocalDateTime nextDueDate;

    @NotNull(message = "recipient name is required")
    private String recipientName;

    @NotNull(message = "recipient phone is required")
    private String recipientPhone;

    @NotNull(message = "recipient district is required")
    private String recipientDistrict;

    @NotNull(message = "recipient sector is required")
    private String recipientSector;

    @NotNull(message = "recipient village is required")
    private String recipientVillage;

    @NotNull(message = "recipient cell is required")
    private String recipientCell;

    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;


    @NotBlank(message = "Status is mandatory")
    private String status;

//    public enum Status {
//        SCHEDULED,
//        COMPLETED
    //}
}
