package com.artikunazo.shorterurl.persistance.mapper;

import com.artikunazo.shorterurl.domain.UrlDomain;
import com.artikunazo.shorterurl.persistance.entity.UrlEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface UrlMapper {
    @Mappings({
        @Mapping(source = "id", target = "id"),
        @Mapping(source = "shortedUrl", target = "shortedUrl"),
        @Mapping(source = "originalUrl", target = "originalUrl"),
        @Mapping(source = "date", target = "date"),
        @Mapping(source = "user", target = "user")
    })
    UrlDomain toDomain(UrlEntity urlEntity);

    @InheritInverseConfiguration
    UrlEntity toEntity(UrlDomain urlDomain);
}
