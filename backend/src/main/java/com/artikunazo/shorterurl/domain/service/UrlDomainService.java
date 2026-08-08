package com.artikunazo.shorterurl.domain.service;

import com.artikunazo.shorterurl.domain.ShortUrlConfig;
import com.artikunazo.shorterurl.domain.UrlDomain;
import com.artikunazo.shorterurl.domain.repository.UrlDomainRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UrlDomainService {

  private final UrlDomainRepository urlDomainRepository;

  @Value("${app.shortener.base-url:http://localhost:8080/shorter-url/api/url/}")
  private String baseUrl;

  private final ShortUrlConfig shortUrlConfig = new ShortUrlConfig();

  public UrlDomain saveShortedUrl(UrlDomain urlDomain) {
    if (urlDomain.getOriginalUrl() != null) {
      Optional<UrlDomain> existing = urlDomainRepository.findByOriginalUrl(urlDomain.getOriginalUrl());
      if (existing.isPresent()) {
        UrlDomain domain = existing.get();
        domain.setShortedUrl(buildFullUrl(domain.getShortedUrl()));
        return domain;
      }
    }

    String slug = "";
    boolean collision = true;
    int maxAttempts = 10;
    int attempts = 0;

    while (collision && attempts < maxAttempts) {
      slug = shortUrlConfig.shortUrlGenerator();
      collision = urlDomainRepository.findByShortedUrl(slug).isPresent();
      attempts++;
    }

    if (collision) {
      throw new IllegalStateException("Failed to generate a unique short URL key. Please try again.");
    }

    urlDomain.setShortedUrl(slug);
    if (urlDomain.getDate() == null) {
      urlDomain.setDate(LocalDateTime.now());
    }
    if (urlDomain.getUser() == null || urlDomain.getUser().isBlank()) {
      urlDomain.setUser("anonymous");
    }

    UrlDomain savedDomain = urlDomainRepository.saveShortedUrl(urlDomain);
    savedDomain.setShortedUrl(buildFullUrl(savedDomain.getShortedUrl()));
    return savedDomain;
  }

  public Optional<UrlDomain> findByShortedUrl(String shortedUrlOrSlug) {
    String slug = extractSlug(shortedUrlOrSlug);
    return urlDomainRepository.findByShortedUrl(slug)
        .map(domain -> {
          domain.setShortedUrl(buildFullUrl(domain.getShortedUrl()));
          return domain;
        });
  }

  @Cacheable(value = "urls", key = "#shortedUrlOrSlug", unless = "#result == null")
  public String getOriginalUrl(String shortedUrlOrSlug) {
    return findByShortedUrl(shortedUrlOrSlug)
        .map(UrlDomain::getOriginalUrl)
        .orElse(null);
  }

  private String extractSlug(String input) {
    if (input == null) return "";
    int lastSlash = input.lastIndexOf('/');
    return lastSlash >= 0 ? input.substring(lastSlash + 1) : input;
  }

  private String buildFullUrl(String slug) {
    if (slug == null) return baseUrl;
    if (slug.startsWith("http://") || slug.startsWith("https://")) {
      return slug;
    }
    String prefix = baseUrl.endsWith("/") ? baseUrl : baseUrl + "/";
    return prefix + slug;
  }
}
