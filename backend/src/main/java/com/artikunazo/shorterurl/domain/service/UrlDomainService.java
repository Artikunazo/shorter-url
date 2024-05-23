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

  public Optional<UrlDomain> saveShortedUrl(UrlDomain urlDomain) {
    Optional<UrlDomain> urlDomainOriginal = this.findOriginalUrl(urlDomain.getOriginalUrl());

    if(!urlDomainOriginal.isEmpty()) {
      return urlDomainOriginal;
    }

    String urlShorted = "https://new.domain/";

    Boolean isShortedUrlFound = false;
    String urlGenerated = "";

    while (!isShortedUrlFound) {
      urlGenerated = this.urlIdGenerator();
      isShortedUrlFound = !this.findShortedUrl(urlGenerated);
      // Until url is not founded it generate new code
    }

    urlDomain.setShortedUrl(urlShorted + urlGenerated);

    return Optional.ofNullable(urlDomainRepository.saveShortedUrl(urlDomain));
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

  private Boolean findShortedUrl(String shortedUrl) {
    return urlDomainRepository.findByShortedUrl(shortedUrl).isPresent();
  }

  private Optional<UrlDomain> findOriginalUrl(String originalUrl) {
    return urlDomainRepository.findByOriginalUrl(originalUrl);
  }

}
