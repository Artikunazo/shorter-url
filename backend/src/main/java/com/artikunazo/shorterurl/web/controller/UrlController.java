package com.artikunazo.shorterurl.web.controller;

import com.artikunazo.shorterurl.common.UrlConstants;
import com.artikunazo.shorterurl.domain.UrlDomain;
import com.artikunazo.shorterurl.domain.service.UrlDomainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.util.Optional;

@CrossOrigin(origins = "https://shorter-url-fe.onrender.com", maxAge = 3600)
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
    public RedirectView findByShortedUrl(@PathVariable("urlShortedId") String shortedUrl){
        String originalUrl = urlDomainService.getOriginalUrl(
            urlDomainService.findByShortedUrl(UrlConstants.NEW_DOMAIN + shortedUrl)
        );

        RedirectView redirectView = new RedirectView();
        redirectView.setUrl(originalUrl);
        return redirectView;
    }

    @PostMapping("/save")
    public ResponseEntity<Optional<UrlDomain>> saveShortedUrl(@RequestBody UrlDomain url) {
        return new ResponseEntity<Optional<UrlDomain>>(urlDomainService.saveShortedUrl(url), HttpStatus.OK);
    }

    @GetMapping("/error")
    public ResponseEntity<String> error() {
        return new ResponseEntity<String>("Error! " + HttpStatus.NOT_FOUND, HttpStatus.NOT_FOUND);
    }
}
