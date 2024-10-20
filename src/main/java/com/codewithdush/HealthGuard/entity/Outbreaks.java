package com.codewithdush.HealthGuard.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.NoArgsConstructor;
//import org.locationtech.jts.geom.Geometry;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@Entity
@Table(name = "outbreaks")
public class Outbreaks {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @NotBlank(message = "Disease is mandatory")
    private Disease disease;

    private int casesReported;

    @NotBlank(message = "Location is mandatory")
    private String location;

//    @Column(columnDefinition = "geometry")
//    private Geometry mapData;

    private LocalDateTime reportedAt;

    public enum Disease {
        MARBURG,
        MONKEYPOX
    }
}
