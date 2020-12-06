package org.autoservice.service.validators;

import org.autoservice.service.exception.ValidatorException;

public interface Validator<T> {
    void isValid(T entity) throws ValidatorException;
}
