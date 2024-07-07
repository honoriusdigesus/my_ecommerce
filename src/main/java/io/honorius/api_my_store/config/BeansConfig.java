package io.honorius.api_my_store.config;

import io.honorius.api_my_store.data.repository.CategoryRepository;
import io.honorius.api_my_store.domain.caseuse.CreateCategoryCaseUse;
import io.honorius.api_my_store.domain.caseuse.GetAllCategoryCaseUse;
import io.honorius.api_my_store.domain.caseuse.GetCategoryByIdCaseUse;
import io.honorius.api_my_store.domain.caseuse.UpdateCategoryCaseUse;
import io.honorius.api_my_store.domain.mappers.CategoryMapperDomain;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeansConfig {
    @Bean
    public GetAllCategoryCaseUse getAllCategoryCaseUse(CategoryRepository categoryRepository, CategoryMapperDomain categoryMapper) {
        return new GetAllCategoryCaseUse(categoryRepository, categoryMapper);
    }

    @Bean
    public GetCategoryByIdCaseUse getCategoryByIdCaseUse(CategoryRepository categoryRepository) {
        return new GetCategoryByIdCaseUse(categoryRepository);
    }

    @Bean
    public CreateCategoryCaseUse createCategoryCaseUse(CategoryRepository categoryRepository, CategoryMapperDomain categoryMapper) {
        return new CreateCategoryCaseUse(categoryRepository, categoryMapper);
    }

    @Bean
    public UpdateCategoryCaseUse updateCategoryCaseUse(CategoryRepository categoryRepository, CategoryMapperDomain categoryMapper) {
        return new UpdateCategoryCaseUse(categoryRepository, categoryMapper);
    }
}
