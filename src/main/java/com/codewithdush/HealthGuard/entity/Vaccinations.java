package com.codewithdush.HealthGuard.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
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
    private User user;

    @NotBlank(message = "Vaccine name is mandatory")
    private String vaccineName;

    @Column(name = "doses_received")
    private int dosesReceived;

    private LocalDateTime nextDueDate;

    @Enumerated(EnumType.STRING)
    @NotBlank(message = "Status is mandatory")
    private Status status;

    public enum Status {
        SCHEDULED,
        COMPLETED
    }
}
