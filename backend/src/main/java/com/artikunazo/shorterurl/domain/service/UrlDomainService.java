package com.artikunazo.shorterurl.domain.service;

import com.artikunazo.shorterurl.domain.ShortUrlConfig;
import com.artikunazo.shorterurl.domain.UrlDomain;
import com.artikunazo.shorterurl.domain.repository.UrlDomainRepository;
import com.artikunazo.shorterurl.common.UrlConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.view.RedirectView;

import java.util.Optional;

@Service
public class UrlDomainService {
  @Autowired
  private UrlDomainRepository urlDomainRepository;

  private ShortUrlConfig shortUrlConfig = new ShortUrlConfig();

  public Optional<UrlDomain> saveShortedUrl(UrlDomain urlDomain) {
    Optional<UrlDomain> urlDomainOriginal = this.findOriginalUrl(urlDomain.getOriginalUrl());

    if(urlDomainOriginal.isPresent()) {
      return urlDomainOriginal;
    }

    boolean isShortedUrlFound = false;
    String urlGenerated = "";

    while (!isShortedUrlFound) {
      urlGenerated = this.urlIdGenerator();
      isShortedUrlFound = !this.findShortedUrl(urlGenerated);
      // Until url is not founded it generate new code
    }

    urlDomain.setShortedUrl(UrlConstants.NEW_DOMAIN + urlGenerated);

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

  public String getOriginalUrl(Optional<UrlDomain> urlDomain) {
    String originalUrl = UrlConstants.URL_BASE + ":" +
        UrlConstants.PORT +
        UrlConstants.CONTEXT_PATH +
        "url/error";

    if(urlDomain.isPresent()) {
      originalUrl = urlDomain.get().getOriginalUrl();
    }

    return originalUrl;
  }

}
