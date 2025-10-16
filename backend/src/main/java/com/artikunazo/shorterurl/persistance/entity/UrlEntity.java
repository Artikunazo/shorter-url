package com.artikunazo.shorterurl.persistance.entity;

import jakarta.persistence.*;

import java.sql.Timestamp;

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
    private String appUser;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getShortedUrl() {
        return shortedUrl;
    }

    public void setShortedUrl(String shortedUrl) {
        this.shortedUrl = shortedUrl;
    }

    public String getOriginalUrl() {
        return originalUrl;
    }

    public void setOriginalUrl(String originalUrl) {
        this.originalUrl = originalUrl;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getUser() {
        return this.appUser;
    }

    public void setUser(String user) {
        this.appUser = user;
    }
}

