package io.honorius.api_my_store.domain.caseuse;

import io.honorius.api_my_store.data.repository.CategoryRepository;
import io.honorius.api_my_store.domain.exception.CategoryNotFoundException;
import io.honorius.api_my_store.domain.model.CategoryDomain;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class GetCategoryByIdCaseUse {
    private final CategoryRepository categoryRepository;

    public CategoryDomain getCategoryById(Long categoryId){
        return categoryRepository.findById(categoryId)
                .map(category -> new CategoryDomain(
                        category.getCategoryId(),
                        category.getCategoryName(),
                        category.getCategoryDescription()
                ))
                .orElseThrow(()-> new CategoryNotFoundException("The category could not be found by the ID provided."));
    }
}
