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


    @NotBlank(message = "Content type is mandatory")
    private String contentType;

    @Override
    public String toString() {
        return "EducationalResource{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", contentType='" + contentType + '\'' +
                ", url='" + url + '\'' +
                ", description='" + description + '\'' +
                ", createdAt=" + createdAt +
                '}';
    }

    @NotBlank(message = "URL is mandatory")
    private String url;

    @NotBlank(message = "description is mandatory")
    private String description;

    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @PrePersist
    protected void onCreate() {
        createdAt = LocalDateTime.now();
    }


}

