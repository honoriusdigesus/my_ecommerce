package io.honorius.api_my_store.domain.mappers;

import io.honorius.api_my_store.data.model.Category;
import io.honorius.api_my_store.domain.model.CategoryDomain;
import org.springframework.stereotype.Component;

@Component
public class CategoryMapperDomain {
    public CategoryDomain fromDataToDomain(Category category){
        return new CategoryDomain(
                category.getCategoryId(),
                category.getCategoryName(),
                category.getCategoryDescription()
        );
    }

    public Category fromDomainToData(CategoryDomain categoryDomain){
        return new Category(
                categoryDomain.getCategoryId(),
                categoryDomain.getCategoryName(),
                categoryDomain.getCategoryDescription()
        );
    }
}
