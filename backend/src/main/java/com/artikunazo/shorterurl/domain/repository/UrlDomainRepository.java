package com.artikunazo.shorterurl.domain.repository;

import com.artikunazo.shorterurl.domain.UrlDomain;

import java.util.Optional;

public interface UrlDomainRepository {
    UrlDomain saveShortedUrl(UrlDomain urlDomain);
    Optional<UrlDomain> findByShortedUrl(String shortedUrl);
    Optional<UrlDomain> findByOriginalUrl(String originalUrl);
}
