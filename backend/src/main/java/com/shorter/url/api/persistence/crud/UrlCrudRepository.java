package com.shorter.url.api.persistence.crud;

import com.shorter.url.api.persistence.entity.Url;
import org.springframework.data.repository.CrudRepository;

import java.math.BigInteger;
import java.util.Optional;

public interface UrlCrudRepository extends CrudRepository<Url, Integer> {
    Optional<Url> findByShortedUrl(String shortedUrl);
    // Optional<Url> findByUserId(int userId);
}
