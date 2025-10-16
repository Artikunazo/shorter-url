package com.artikunazo.shorterurl.persistance.entity;

import jakarta.persistence.*;
import lombok.*;
import java.sql.Timestamp;

@Data
@Entity
@Table(name = "urls")
public class UrlEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "shorted_url")
    private String shortedUrl;

    @Column(name = "original_url")
    private String originalUrl;

    private String date;

    @Column(name = "app_user")
    private String user;
}

