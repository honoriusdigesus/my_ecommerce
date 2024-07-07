package io.honorius.api_my_store.persistence.model;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class CategoryPersistence {
    private Long categoryId;
    private String categoryName;
    private String categoryDescription;
}
