package com.artikunazo.shorterurl.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UrlDomain {
    private Integer id;
    private String shortedUrl;
    private String originalUrl;
    private LocalDateTime date;
    private String user;
}
