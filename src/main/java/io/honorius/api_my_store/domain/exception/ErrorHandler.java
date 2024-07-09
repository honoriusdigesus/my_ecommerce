package io.honorius.api_my_store.domain.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ErrorHandler {
    @ExceptionHandler(CategoryNotFoundException.class)
    public ResponseEntity<ErrorResponse> handlerCategoryNotFoundException(CategoryNotFoundException ex) {
        HttpStatus status = HttpStatus.NOT_FOUND;
        ErrorResponse error = new ErrorResponse(100, "CATEGORY_NOT_FOUND", ex.getMessage());
        return ResponseEntity.status(status).body(error);
    }

    @ExceptionHandler(CategoryNameInvalid.class)
    public ResponseEntity<ErrorResponse> handlerCategoryNameInvalid(CategoryNameInvalid ex) {
        HttpStatus status = HttpStatus.NOT_FOUND;
        ErrorResponse error = new ErrorResponse(101, "CATEGORY_NAME_INVALID", ex.getMessage());
        return ResponseEntity.status(status).body(error);
    }

    @ExceptionHandler(CategoryIdInvalid.class)
    public ResponseEntity<ErrorResponse> handlerCategoryIdInvalid(CategoryIdInvalid ex) {
        HttpStatus status = HttpStatus.NOT_FOUND;
        ErrorResponse error = new ErrorResponse(102, "CATEGORY_ID_INVALID", ex.getMessage());
        return ResponseEntity.status(status).body(error);
    }
}