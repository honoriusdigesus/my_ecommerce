package io.honorius.api_my_store.domain.caseuse;

import io.honorius.api_my_store.data.repository.CategoryRepository;
import io.honorius.api_my_store.domain.mappers.CategoryMapperDomain;
import io.honorius.api_my_store.domain.model.CategoryDomain;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class CreateCategoryCaseUse {
    private final CategoryRepository categoryRepository;
    private final CategoryMapperDomain categoryMapper;

    public CategoryDomain createCategory(CategoryDomain categoryDomain){
        return categoryMapper.fromDataToDomain(categoryRepository.save(categoryMapper.fromDomainToData(categoryDomain)));
    }
}
