package com.artikunazo.shorterurl.domain;

public class UrlDomain {
    private String urlId;
    private String date;
    private String shortedUrl;
    private String originalUrl;

    public String getUrlId() {
        return urlId;
    }

    public void setUrlId(String urlId) {
        this.urlId = urlId;
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
}
