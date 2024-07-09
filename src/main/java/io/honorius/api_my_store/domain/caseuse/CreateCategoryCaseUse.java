package io.honorius.api_my_store.domain.caseuse;

import io.honorius.api_my_store.data.repository.CategoryRepository;
import io.honorius.api_my_store.domain.exception.CategoryNameInvalid;
import io.honorius.api_my_store.domain.mappers.CategoryMapperDomain;
import io.honorius.api_my_store.domain.model.CategoryDomain;
import io.honorius.api_my_store.utils.Validator;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class CreateCategoryCaseUse {
    private final CategoryRepository categoryRepository;
    private final CategoryMapperDomain categoryMapper;
    private final Validator validator;

    public CategoryDomain createCategory(CategoryDomain categoryDomain){
        if (validator.isNullOrEmpty(categoryDomain.getCategoryName()) || !validator.isString(categoryDomain.getCategoryName()))
            throw new CategoryNameInvalid("The category name must not be null, blank or contain numbers.");
        return categoryMapper.fromDataToDomain(categoryRepository.save(categoryMapper.fromDomainToData(categoryDomain)));
    }
}
