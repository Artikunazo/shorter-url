package com.artikunazo.shorterurl.web.controller;

import com.artikunazo.shorterurl.domain.UrlDomain;
import com.artikunazo.shorterurl.domain.service.UrlDomainService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.util.Optional;

@CrossOrigin(origins = {"http://localhost:4200", "https://shorter-url-fe-staging.up.railway.app/"}, maxAge = 3600)
@RestController
@RequestMapping("/url")
@RequiredArgsConstructor
public class UrlController {

    private final UrlDomainService urlDomainService;

    @GetMapping("/health-check")
    public ResponseEntity<String> getResponse() {
        return ResponseEntity.ok("Ok!");
    }

    @GetMapping("/{urlShortedId}")
    public Object findByShortedUrl(@PathVariable("urlShortedId") String shortedUrl) {
        String originalUrl = urlDomainService.getOriginalUrl(shortedUrl);

        if (originalUrl == null || originalUrl.isBlank()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("URL not found");
        }

        RedirectView redirectView = new RedirectView();
        redirectView.setUrl(originalUrl);
        return redirectView;
    }

    @PostMapping("/save")
    public ResponseEntity<UrlDomain> saveShortedUrl(@RequestBody UrlDomain url) {
        UrlDomain savedUrl = urlDomainService.saveShortedUrl(url);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedUrl);
    }
}
