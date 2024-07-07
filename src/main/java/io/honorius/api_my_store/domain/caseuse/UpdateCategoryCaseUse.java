package io.honorius.api_my_store.domain.caseuse;

import io.honorius.api_my_store.data.model.Category;
import io.honorius.api_my_store.data.repository.CategoryRepository;
import io.honorius.api_my_store.domain.exception.CategoryNotFoundException;
import io.honorius.api_my_store.domain.mappers.CategoryMapperDomain;
import io.honorius.api_my_store.domain.model.CategoryDomain;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class UpdateCategoryCaseUse {
    private final CategoryRepository categoryRepository;
    private final CategoryMapperDomain categoryMapper;

    public CategoryDomain updateCategory(Long categoryId, CategoryDomain categoryDomain){
        Category category = categoryRepository.findById(categoryId).orElseThrow(()-> new CategoryNotFoundException("The category could not be found by the ID provided."));
        category.setCategoryName(categoryDomain.getCategoryName());
        category.setCategoryDescription(categoryDomain.getCategoryDescription());
        return categoryMapper.fromDataToDomain(categoryRepository.save(category));
    }
}
