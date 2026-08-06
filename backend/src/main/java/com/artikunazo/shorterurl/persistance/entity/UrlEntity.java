package com.artikunazo.shorterurl.persistance.entity;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "urls")
public class UrlEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "shorted_url", nullable = false, unique = true, columnDefinition = "TEXT")
    private String shortedUrl;

    @Column(name = "original_url", nullable = false)
    private String originalUrl;

    @Column(name = "date", nullable = false)
    private LocalDateTime date;

    @Column(name = "app_user", nullable = false)
    private String user;
}
