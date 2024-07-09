package io.honorius.api_my_store.persistence.controller;

import io.honorius.api_my_store.domain.caseuse.*;
import io.honorius.api_my_store.persistence.mappers.CategoryMapperPersistence;
import io.honorius.api_my_store.persistence.model.CategoryPersistence;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("category")
@AllArgsConstructor
public class CategoryController {
    private final GetAllCategoryCaseUse getAllCategoryCaseUse;
    private final GetCategoryByIdCaseUse getCategoryByIdCaseUse;
    private final CreateCategoryCaseUse createCategoryCaseUse;
    private final UpdateCategoryCaseUse updateCategoryCaseUse;
    private final DeleteCategoryCaseUse deleteCategoryCaseUse;

    private final CategoryMapperPersistence categoryMapperPersistence;



    @GetMapping("/all")
    public ResponseEntity<List<CategoryPersistence>> getAllCategories(){
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(getAllCategoryCaseUse.getAllCategories().stream().map(categoryMapperPersistence::fromDomainToPersistence).toList());
    }

    //Get category by ID
    @GetMapping("/get/{id}")
    public ResponseEntity<CategoryPersistence> getCategoryById(@PathVariable(required = false) Long id){
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(categoryMapperPersistence.fromDomainToPersistence(getCategoryByIdCaseUse.getCategoryById(id)));
    }


    //Create category
    @PostMapping("/create")
    public ResponseEntity<CategoryPersistence> createCategory(@RequestBody CategoryPersistence categoryPersistence){
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(categoryMapperPersistence.fromDomainToPersistence(createCategoryCaseUse.createCategory(categoryMapperPersistence.fromPersistenceToDomain(categoryPersistence))));
    }

    //Update category
    @PutMapping("/update/{id}")
    public ResponseEntity<CategoryPersistence> updateCategory(@PathVariable Long id, @RequestBody CategoryPersistence categoryPersistence){
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(categoryMapperPersistence.fromDomainToPersistence(updateCategoryCaseUse.updateCategory(id, categoryMapperPersistence.fromPersistenceToDomain(categoryPersistence))));
    }

    //Delete category
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteCategory(@PathVariable(required = false) Long id){
        return deleteCategoryCaseUse.deleteCategory(id);
    }
}
