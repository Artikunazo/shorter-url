package com.shorter.url.api.persistence;

import com.shorter.url.api.persistence.crud.UrlCrudRepository;
import com.shorter.url.api.persistence.entity.Url;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

@Repository
public class UrlRepository {
    private UrlCrudRepository urlCrudRepository;

    /* public List<Url> getAll() {
        return (List<Url>) urlCrudRepository.findAll();
    } */

    public Optional<Url> getShortedUrlById(int id) {
        return urlCrudRepository.findById(id);
    }

    public Url saveShortedUrl(Url shortedUrl) {
        return urlCrudRepository.save(shortedUrl);
    }

    public Optional<Url> findByShortedUrl(String shortedUrl) {
        return urlCrudRepository.findByShortedUrl(shortedUrl);
    }
}
