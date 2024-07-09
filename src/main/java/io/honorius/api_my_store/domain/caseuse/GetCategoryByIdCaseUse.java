package io.honorius.api_my_store.domain.caseuse;

import io.honorius.api_my_store.data.repository.CategoryRepository;
import io.honorius.api_my_store.domain.exception.CategoryIdInvalid;
import io.honorius.api_my_store.domain.exception.CategoryNotFoundException;
import io.honorius.api_my_store.domain.model.CategoryDomain;
import io.honorius.api_my_store.utils.Validator;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class GetCategoryByIdCaseUse {
    private final CategoryRepository categoryRepository;
    private final Validator validator;

    public CategoryDomain getCategoryById(Long categoryId){
        if (validator.numberIsNullOrEmptyOrString(categoryId)){
            throw new CategoryIdInvalid("The category ID must not be null, blank, or less than zero.");
        }

        return categoryRepository.findById(categoryId)
                .map(category -> new CategoryDomain(
                        category.getCategoryId(),
                        category.getCategoryName(),
                        category.getCategoryDescription()
                ))
                .orElseThrow(()-> new CategoryNotFoundException("The category could not be found by the ID provided."));
    }
}
