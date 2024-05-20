package com.artikunazo.shorterurl.domain.repository;

import com.artikunazo.shorterurl.domain.UrlDomain;

import java.util.Optional;

public interface UrlDomainRepository {
    Optional<UrlDomain> findById(int id);
    UrlDomain saveShortedUrl(UrlDomain urlDomain);
    Optional<UrlDomain> findByShortedUrl(String shortedUrl);
}
