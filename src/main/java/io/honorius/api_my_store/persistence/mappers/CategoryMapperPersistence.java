package io.honorius.api_my_store.persistence.mappers;

import io.honorius.api_my_store.data.model.Category;
import io.honorius.api_my_store.domain.model.CategoryDomain;
import io.honorius.api_my_store.persistence.model.CategoryPersistence;
import org.springframework.stereotype.Component;

@Component
public class CategoryMapperPersistence {
    public CategoryDomain fromPersistenceToDomain(CategoryPersistence category){
        return new CategoryDomain(
                category.getCategoryId(),
                category.getCategoryName(),
                category.getCategoryDescription()
        );
    }

    public CategoryPersistence fromDomainToPersistence(CategoryDomain categoryDomain){
        return new CategoryPersistence(
                categoryDomain.getCategoryId(),
                categoryDomain.getCategoryName(),
                categoryDomain.getCategoryDescription()
        );
    }
}
