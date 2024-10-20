package com.codewithdush.HealthGuard.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.NoArgsConstructor;
//import org.locationtech.jts.geom.Point;

import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
@Table(name = "contact_traces")
public class ContactTraces {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

//    @ElementCollection
//    @CollectionTable(name = "location_data", joinColumns = @JoinColumn(name = "contact_trace_id"))
//    @Column(name = "location")
   // private List<Point> locationData;

    private LocalDateTime traceStart;

    private LocalDateTime traceEnd;
}
