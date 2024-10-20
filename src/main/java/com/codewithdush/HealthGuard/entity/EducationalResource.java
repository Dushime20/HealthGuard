package com.codewithdush.HealthGuard.entity;



import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@Entity
@Table(name = "educational_resources")
public class EducationalResource {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Title is mandatory")
    private String title;

    @Enumerated(EnumType.STRING)
    @NotBlank(message = "Content type is mandatory")
    private ContentType contentType;

    @NotBlank(message = "URL is mandatory")
    private String url;

    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @PrePersist
    protected void onCreate() {
        createdAt = LocalDateTime.now();
    }

    public enum ContentType {
        ARTICLE,
        VIDEO,
        INFOGRAPHIC
    }
}

