package io.honorius.api_my_store.config;

import io.honorius.api_my_store.domain.mappers.CategoryMapperDomain;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class MapperConfig {
    @Bean
    public CategoryMapperDomain categoryMapper() {
        return new CategoryMapperDomain();
    }
}
