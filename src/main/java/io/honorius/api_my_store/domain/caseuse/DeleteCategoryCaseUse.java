package io.honorius.api_my_store.domain.caseuse;

import io.honorius.api_my_store.data.repository.CategoryRepository;
import io.honorius.api_my_store.domain.exception.CategoryIdInvalid;
import io.honorius.api_my_store.utils.Validator;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class DeleteCategoryCaseUse {
    private final CategoryRepository categoryRepository;
    private final Validator validator;

    public ResponseEntity<String> deleteCategory(Long categoryId){
        if (validator.numberIsNullOrEmptyOrString(categoryId)){
            throw new CategoryIdInvalid("The category ID must not be null, blank, or less than zero.");
        }
        categoryRepository.deleteById(categoryId);
        return ResponseEntity.status(HttpStatus.OK).body("The category was deleted successfully.");
    }
}
