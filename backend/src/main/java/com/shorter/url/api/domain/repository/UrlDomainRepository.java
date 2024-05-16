package com.shorter.url.api.domain.repository;

import com.shorter.url.api.domain.UrlDomain;
import org.springframework.stereotype.Repository;

import java.util.Optional;

public interface UrlDomainRepository {
    Optional<UrlDomain> findById(int id);
    UrlDomain saveShortedUrl(UrlDomain urlDomain);
    Optional<UrlDomain> findByShortedUrl(String shortedUrl);
}
