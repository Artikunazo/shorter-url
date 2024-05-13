package com.shorter.url.api.persistence.crud;

import com.shorter.url.api.persistence.entity.UrlEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UrlCrudRepository extends CrudRepository<UrlEntity, Integer> {
    Optional<UrlEntity> findByShortedUrl(String shortedUrl);
    // Optional<Url> findByUserId(int userId);
}
