package io.honorius.api_my_store.data.repository;

import io.honorius.api_my_store.data.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long>{
}
