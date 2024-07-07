package io.honorius.api_my_store.domain.model;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class CategoryDomain {
    private Long categoryId;
    private String categoryName;
    private String categoryDescription;
}
