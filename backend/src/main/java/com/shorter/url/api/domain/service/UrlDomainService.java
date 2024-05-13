package com.shorter.url.api.domain.service;

import com.shorter.url.api.domain.UrlDomain;
import com.shorter.url.api.domain.repository.UrlDomainRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class UrlDomainService {

    @Autowired
    private UrlDomainRepository urlDomainRepository;

    public Optional<UrlDomain> getShortedUrlById(int id) {
        return urlDomainRepository.findById(id);
    }

    public UrlDomain saveShortedUrl(UrlDomain urlDomain) {
        return urlDomainRepository.saveShortedUrl(urlDomain);
    }

    public Optional<UrlDomain> findByShortedUrl(String shortedUrl) {
        return urlDomainRepository.findByShortedUrl(shortedUrl);
    }
}
