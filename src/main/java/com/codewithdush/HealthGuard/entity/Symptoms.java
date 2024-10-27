package com.codewithdush.HealthGuard.entity;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "symptoms")
public class Symptoms {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ElementCollection
    @CollectionTable(name = "symptom_list", joinColumns = @JoinColumn(name = "symptoms_id"))
    @Column(name = "symptom")
    private List<String> symptoms = new ArrayList<>();

    private LocalDateTime submittedAt;

    @NotBlank(message = "description is mandatory")
    private String description;

    @Override
    public String toString() {
        return "Symptoms{" +
                "id=" + id +

                ", symptoms=" + symptoms +
                ", submittedAt=" + submittedAt +
                ", description='" + description + '\'' +
                '}';
    }
}
