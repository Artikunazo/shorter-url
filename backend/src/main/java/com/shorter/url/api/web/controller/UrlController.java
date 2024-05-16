package com.shorter.url.api.web.controller;

import com.shorter.url.api.domain.UrlDomain;
import com.shorter.url.api.domain.service.UrlDomainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/url")
public class UrlController {

    @Autowired
    private UrlDomainService urlDomainService;

    @GetMapping("/{urlShortedId}")
    public ResponseEntity<UrlDomain> getShortedUrlById(@PathVariable("urlShortedId") int id){
        return urlDomainService.getShortedUrlById(id).map(urlDomain -> new ResponseEntity<>(urlDomain, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/save")
    public ResponseEntity<UrlDomain> saveShortedUrl(UrlDomain url) {
        return new ResponseEntity<>(urlDomainService.saveShortedUrl(url), HttpStatus.OK);
    }

    @GetMapping("/{shortedUrl}")
    public ResponseEntity<UrlDomain> findByShortedUrl(@PathVariable("shortedUrl") String shortedUrl){
        return urlDomainService.findByShortedUrl(shortedUrl)
                .map(urlDomain -> new ResponseEntity<>(urlDomain, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

}
