package com.shorter.url.api.persistence.entity;

import jakarta.persistence.*;

import java.sql.Timestamp;

@Entity
@Table(name = "urls")
public class UrlEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String urlId;

    @Column(name = "shorted_url")
    private String shortedUrl;

    @Column(name = "original_url")
    private String originalUrl;

    private Timestamp date;
    private String user;

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

    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getUrlId() {
        return urlId;
    }

    public void setUrlId(String urlId) {
        this.urlId = urlId;
    }
}

