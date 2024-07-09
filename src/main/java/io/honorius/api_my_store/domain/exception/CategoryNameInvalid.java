package io.honorius.api_my_store.domain.exception;

public class CategoryNameInvalid extends RuntimeException{
    public CategoryNameInvalid(String message) {
        super(message);
    }
}
