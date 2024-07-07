package io.honorius.api_my_store.domain.caseuse;

import io.honorius.api_my_store.data.repository.CategoryRepository;
import io.honorius.api_my_store.domain.mappers.CategoryMapperDomain;
import io.honorius.api_my_store.domain.model.CategoryDomain;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@AllArgsConstructor
public class GetAllCategoryCaseUse {
    private CategoryRepository categoryRepository;
    private CategoryMapperDomain categoryMapper;

    public List<CategoryDomain> getAllCategories(){
        return categoryRepository
                .findAll()
                .stream()
                .map(categoryMapper::fromDataToDomain)
                .collect(Collectors.toList());
    }
}
