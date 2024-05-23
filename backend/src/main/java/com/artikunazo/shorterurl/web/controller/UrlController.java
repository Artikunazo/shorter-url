package com.artikunazo.shorterurl.web.controller;

import com.artikunazo.shorterurl.domain.UrlDomain;
import com.artikunazo.shorterurl.domain.service.UrlDomainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping("/url")
public class UrlController {

    @Autowired
    private UrlDomainService urlDomainService;

    @GetMapping("/health-check")
    public ResponseEntity<String> getResponse() {
        return new ResponseEntity<String>("Ok!", HttpStatus.OK) ;
    }

    @GetMapping("/{urlShortedId}")
    public ResponseEntity<UrlDomain> findByShortedUrl(@PathVariable("urlShortedId") String shortedUrl){
        return urlDomainService.findByShortedUrl(shortedUrl)
            .map(urlDomain -> new ResponseEntity<>(urlDomain, HttpStatus.OK))
            .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/save")
    public ResponseEntity<Optional<UrlDomain>> saveShortedUrl(@RequestBody UrlDomain url) {
        return new ResponseEntity<Optional<UrlDomain>>(urlDomainService.saveShortedUrl(url), HttpStatus.OK);
    }
}
