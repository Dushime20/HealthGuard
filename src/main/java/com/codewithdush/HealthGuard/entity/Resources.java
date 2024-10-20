package com.codewithdush.HealthGuard.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@Entity
@Table(name = "resources")
public class Resources {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @NotBlank(message = "Resource type is mandatory")
    private ResourceType resourceType;

    private int quantity;

    @NotBlank(message = "Location is mandatory")
    private String location;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "requested_by", nullable = false)
    private User requestedBy;

    @Enumerated(EnumType.STRING)
    @NotBlank(message = "Status is mandatory")
    private Status status;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @PreUpdate
    protected void onUpdate() {
        updatedAt = LocalDateTime.now();
    }

    public enum ResourceType {
        PPE,
        VACCINES,
        MEDICINES
    }

    public enum Status {
        AVAILABLE,
        REQUESTED,
        DISTRIBUTED
    }
}
