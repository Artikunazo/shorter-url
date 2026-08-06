package com.artikunazo.shorterurl.persistance;

import com.artikunazo.shorterurl.domain.UrlDomain;
import com.artikunazo.shorterurl.domain.repository.UrlDomainRepository;
import com.artikunazo.shorterurl.persistance.crud.UrlCrudRepository;
import com.artikunazo.shorterurl.persistance.entity.UrlEntity;
import com.artikunazo.shorterurl.persistance.mapper.UrlMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class UrlRepository implements UrlDomainRepository {
    private final UrlCrudRepository urlCrudRepository;
    private final UrlMapper urlMapper;

    public Optional<UrlDomain> getShortedUrlById(int id) {
        return urlCrudRepository.findById(id)
            .map(urlMapper::toDomain);
    }

    @Override
    public UrlDomain saveShortedUrl(UrlDomain urlDomain) {
        UrlEntity url = urlMapper.toEntity(urlDomain);
        return urlMapper.toDomain(urlCrudRepository.save(url));
    }

    @Override
    public Optional<UrlDomain> findByShortedUrl(String shortedUrl) {
        return urlCrudRepository.findByShortedUrl(shortedUrl)
            .map(urlMapper::toDomain);
    }

    @Override
    public Optional<UrlDomain> findByOriginalUrl(String originalUrl) {
        return urlCrudRepository.findByOriginalUrl(originalUrl)
            .map(urlMapper::toDomain);
    }
}
