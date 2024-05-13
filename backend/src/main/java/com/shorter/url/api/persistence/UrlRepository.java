package com.shorter.url.api.persistence;

import com.shorter.url.api.domain.UrlDomain;
import com.shorter.url.api.persistence.crud.UrlCrudRepository;
import com.shorter.url.api.persistence.entity.UrlEntity;
import com.shorter.url.api.persistence.mapper.UrlMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class UrlRepository {
    @Autowired
    private UrlCrudRepository urlCrudRepository;

    @Autowired
    private UrlMapper urlMapper;

    /* public List<Url> getAll() {
        return (List<Url>) urlCrudRepository.findAll();
    } */

    public Optional<UrlDomain> getShortedUrlById(int id) {
        return urlCrudRepository.findById(id).map(urlEntity -> urlMapper.toUrlEntity(urlEntity));
    }

    public UrlDomain saveShortedUrl(UrlDomain urlDomain) {
        UrlEntity url = urlMapper.toUrlDomain(urlDomain);
        return urlMapper.toUrlEntity(urlCrudRepository.save(url));
    }

    public Optional<UrlDomain> findByShortedUrl(String shortedUrl) {
        return urlCrudRepository.findByShortedUrl(shortedUrl).map(url -> urlMapper.toUrlEntity(url));
    }
}
