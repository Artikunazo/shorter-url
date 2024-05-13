package com.shorter.url.api.persistence.mapper;

import com.shorter.url.api.domain.UrlDomain;
import com.shorter.url.api.persistence.entity.UrlEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface UrlMapper {
    @Mappings({
            @Mapping(source = "urlId", target = "urlId"),
            @Mapping(source = "shortedUrl", target = "shortedUrl"),
            @Mapping(source = "originalUrl", target = "originalUrl")
    })
    UrlDomain toUrlEntity(UrlEntity url);

    @InheritInverseConfiguration
    @Mappings({
            @Mapping(target = "id", ignore = true),
            @Mapping(target = "user", ignore = true),
            @Mapping(target = "date", ignore = true)
    })
    UrlEntity toUrlDomain(UrlDomain url);
}
