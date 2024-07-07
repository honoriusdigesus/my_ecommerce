package io.honorius.api_my_store.data.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Entity
@Table(name = "categories")
public class Category {
    @Id
    @Generated
    private Long categoryId;
    @Column(nullable = false, unique = true, length = 50)
    private String categoryName;
    private String categoryDescription;
}
