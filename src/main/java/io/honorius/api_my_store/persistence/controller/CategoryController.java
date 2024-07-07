package io.honorius.api_my_store.persistence.controller;

import io.honorius.api_my_store.domain.caseuse.GetAllCategoryCaseUse;
import io.honorius.api_my_store.domain.caseuse.GetCategoryByIdCaseUse;
import io.honorius.api_my_store.persistence.mappers.CategoryMapperPersistence;
import io.honorius.api_my_store.persistence.model.CategoryPersistence;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("category")
@AllArgsConstructor
public class CategoryController {
    private final GetAllCategoryCaseUse getAllCategoryCaseUse;
    private final GetCategoryByIdCaseUse getCategoryByIdCaseUse;
    private final CategoryMapperPersistence categoryMapperPersistence;

    @GetMapping("/all")
    public ResponseEntity<List<CategoryPersistence>> getAllCategories(){
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(getAllCategoryCaseUse.getAllCategories().stream().map(categoryMapperPersistence::fromDomainToPersistence).toList());
    }

    //Get category by ID
    @GetMapping("/get/{id}")
    public ResponseEntity<CategoryPersistence> getCategoryById(@PathVariable Long id){
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(categoryMapperPersistence.fromDomainToPersistence(getCategoryByIdCaseUse.getCategoryById(id)));
    }

}
