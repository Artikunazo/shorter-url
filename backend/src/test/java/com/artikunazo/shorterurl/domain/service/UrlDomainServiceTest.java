package com.artikunazo.shorterurl.domain.service;

import com.artikunazo.shorterurl.domain.UrlDomain;
import com.artikunazo.shorterurl.domain.repository.UrlDomainRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.util.ReflectionTestUtils;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class UrlDomainServiceTest {

    @Mock
    private UrlDomainRepository urlDomainRepository;

    @InjectMocks
    private UrlDomainService urlDomainService;

    @BeforeEach
    void setUp() {
        ReflectionTestUtils.setField(urlDomainService, "baseUrl", "http://localhost:8080/shorter-url/api/url/");
    }

    @Test
    void saveShortedUrl_NewOriginalUrl_GeneratesSlugAndReturnsFullUrl() {
        UrlDomain input = UrlDomain.builder()
                .originalUrl("https://example.com/test-page")
                .user("testuser")
                .build();

        when(urlDomainRepository.findByOriginalUrl("https://example.com/test-page"))
                .thenReturn(Optional.empty());
        when(urlDomainRepository.findByShortedUrl(anyString()))
                .thenReturn(Optional.empty());
        when(urlDomainRepository.saveShortedUrl(any(UrlDomain.class)))
                .thenAnswer(invocation -> invocation.getArgument(0));

        UrlDomain result = urlDomainService.saveShortedUrl(input);

        assertNotNull(result);
        assertNotNull(result.getShortedUrl());
        assertTrue(result.getShortedUrl().startsWith("http://localhost:8080/shorter-url/api/url/"));
        verify(urlDomainRepository).saveShortedUrl(any(UrlDomain.class));
    }

    @Test
    void saveShortedUrl_ExistingOriginalUrl_ReturnsExistingWithoutRecreating() {
        UrlDomain existing = UrlDomain.builder()
                .originalUrl("https://example.com/test-page")
                .shortedUrl("existingSlug")
                .user("testuser")
                .build();

        when(urlDomainRepository.findByOriginalUrl("https://example.com/test-page"))
                .thenReturn(Optional.of(existing));

        UrlDomain input = UrlDomain.builder()
                .originalUrl("https://example.com/test-page")
                .build();

        UrlDomain result = urlDomainService.saveShortedUrl(input);

        assertEquals("http://localhost:8080/shorter-url/api/url/existingSlug", result.getShortedUrl());
        verify(urlDomainRepository, never()).saveShortedUrl(any());
    }

    @Test
    void findByShortedUrl_ExistingSlug_ReturnsFullUrl() {
        UrlDomain domain = UrlDomain.builder()
                .shortedUrl("abc1234")
                .originalUrl("https://example.com")
                .build();

        when(urlDomainRepository.findByShortedUrl("abc1234"))
                .thenReturn(Optional.of(domain));

        Optional<UrlDomain> result = urlDomainService.findByShortedUrl("abc1234");

        assertTrue(result.isPresent());
        assertEquals("http://localhost:8080/shorter-url/api/url/abc1234", result.get().getShortedUrl());
    }
}
