package com.artikunazo.shorterurl.domain.service;

import com.artikunazo.shorterurl.domain.ShortUrlConfig;
import com.artikunazo.shorterurl.domain.UrlDomain;
import com.artikunazo.shorterurl.domain.repository.UrlDomainRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UrlDomainService {
    @Autowired
    private UrlDomainRepository urlDomainRepository;

    private ShortUrlConfig shortUrlConfig = new ShortUrlConfig();

    public UrlDomain saveShortedUrl(UrlDomain urlDomain) {
        System.out.println(urlDomain.toString());
        urlDomain.setShortedUrl(this.urlIdGenerator());

        return urlDomainRepository.saveShortedUrl(urlDomain);
    }

    public Optional<UrlDomain> findByShortedUrl(String shortedUrl) {
        return urlDomainRepository.findByShortedUrl(shortedUrl);
    }

    private String urlIdGenerator() {
        shortUrlConfig.setHasMayus(true);
        shortUrlConfig.setHasMinus(true);
        shortUrlConfig.setHasNumbers(true);

        return shortUrlConfig.shortUrlGenerator();
    }
}
