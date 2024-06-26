package com.artikunazo.shorterurl.persistance;

import com.artikunazo.shorterurl.domain.UrlDomain;
import com.artikunazo.shorterurl.domain.repository.UrlDomainRepository;
import com.artikunazo.shorterurl.persistance.crud.UrlCrudRepository;
import com.artikunazo.shorterurl.persistance.entity.UrlEntity;
import com.artikunazo.shorterurl.persistance.mapper.UrlMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class UrlRepository implements UrlDomainRepository {
    @Autowired
    private UrlCrudRepository urlCrudRepository;

    @Autowired
    private UrlMapper urlMapper;

    /* public List<Url> getAll() {
        return (List<Url>) urlCrudRepository.findAll();
    } */

    public Optional<UrlDomain> getShortedUrlById(int id) {
        return urlCrudRepository.findById(id)
            .map(urlEntity -> urlMapper.toUrlEntity(urlEntity));
    }

    public UrlDomain saveShortedUrl(UrlDomain urlDomain) {
        UrlEntity url = urlMapper.toUrlDomain(urlDomain);
        return urlMapper.toUrlEntity(urlCrudRepository.save(url));
    }

    public Optional<UrlDomain> findByShortedUrl(String shortedUrl) {
        return urlCrudRepository.findByShortedUrl(shortedUrl)
            .map(url -> urlMapper.toUrlEntity(url));
    }

    public Optional<UrlDomain> findByOriginalUrl(String originalUrl) {
      return urlCrudRepository.findByOriginalUrl(originalUrl)
          .map(url -> urlMapper.toUrlEntity(url));
    }
}
