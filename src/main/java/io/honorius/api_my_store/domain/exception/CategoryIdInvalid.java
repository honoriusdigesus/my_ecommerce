package io.honorius.api_my_store.domain.exception;

public class CategoryIdInvalid extends RuntimeException{
    public CategoryIdInvalid(String message) {
        super(message);
    }
}
