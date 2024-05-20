package com.artikunazo.shorterurl.persistance.crud;

import com.artikunazo.shorterurl.persistance.entity.UrlEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UrlCrudRepository extends CrudRepository<UrlEntity, Integer> {
    Optional<UrlEntity> findByShortedUrl(String shortedUrl);
    // Optional<Url> findByUserId(int userId);
}
