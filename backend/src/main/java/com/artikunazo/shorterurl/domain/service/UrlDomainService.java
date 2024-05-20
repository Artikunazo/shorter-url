package com.artikunazo.shorterurl.domain.service;

import com.artikunazo.shorterurl.domain.UrlDomain;
import com.artikunazo.shorterurl.domain.repository.UrlDomainRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UrlDomainService {
    @Autowired
    private UrlDomainRepository urlDomainRepository;

    public Optional<UrlDomain> getShortedUrlById(int id) {
        return urlDomainRepository.findById(id);
    }

    public UrlDomain saveShortedUrl(UrlDomain urlDomain) {
        // Create short url
        return urlDomainRepository.saveShortedUrl(urlDomain);
    }

    public Optional<UrlDomain> findByShortedUrl(String shortedUrl) {
        return urlDomainRepository.findByShortedUrl(shortedUrl);
    }
}
