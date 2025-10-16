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
        @Mapping(source = "shortedUrl", target = "shortedUrl"),
        @Mapping(source = "originalUrl", target = "originalUrl"),
        @Mapping(source = "date", target = "date"),
        @Mapping(source = "user", target = "app_user"),

    })
    UrlDomain toUrlEntity(UrlEntity url);

    @InheritInverseConfiguration
    @Mappings({
        @Mapping(target = "id", ignore = true),
    })
    UrlEntity toUrlDomain(UrlDomain url);
}
