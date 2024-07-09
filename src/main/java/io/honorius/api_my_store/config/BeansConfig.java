package io.honorius.api_my_store.config;

import io.honorius.api_my_store.data.repository.CategoryRepository;
import io.honorius.api_my_store.domain.caseuse.*;
import io.honorius.api_my_store.domain.mappers.CategoryMapperDomain;
import io.honorius.api_my_store.utils.Validator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeansConfig {
    @Bean
    public GetAllCategoryCaseUse getAllCategoryCaseUse(CategoryRepository categoryRepository, CategoryMapperDomain categoryMapper) {
        return new GetAllCategoryCaseUse(categoryRepository, categoryMapper);
    }

    @Bean
    public GetCategoryByIdCaseUse getCategoryByIdCaseUse(CategoryRepository categoryRepository, Validator validator) {
        return new GetCategoryByIdCaseUse(categoryRepository, validator);
    }

    @Bean
    public CreateCategoryCaseUse createCategoryCaseUse(CategoryRepository categoryRepository, CategoryMapperDomain categoryMapper, Validator validator) {
        return new CreateCategoryCaseUse(categoryRepository, categoryMapper, validator);
    }

    @Bean
    public UpdateCategoryCaseUse updateCategoryCaseUse(CategoryRepository categoryRepository, CategoryMapperDomain categoryMapper) {
        return new UpdateCategoryCaseUse(categoryRepository, categoryMapper);
    }

    @Bean
    public DeleteCategoryCaseUse deleteCategoryCaseUse(CategoryRepository categoryRepository, Validator validator) {
        return new DeleteCategoryCaseUse(categoryRepository, validator);
    }
}
