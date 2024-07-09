package io.honorius.api_my_store.utils;

import org.springframework.stereotype.Component;

@Component
public class Validator {
    public boolean isNullOrEmpty(String value) {
        return value == null || value.trim().isEmpty();
    }

    public boolean isString(String value) {
        return value.matches("^[a-zA-Z]*$");
    }

    public boolean numberIsNullOrEmptyOrString(Long number) {
        if (number == null || number<=0) {
            return true;
        }
        return false;
    }
}
