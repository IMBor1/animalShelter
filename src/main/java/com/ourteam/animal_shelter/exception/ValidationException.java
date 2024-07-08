package com.ourteam.animal_shelter.exception;



public class ValidationException extends RuntimeException {
    public ValidationException() {
    }

    public ValidationException(String entity) {
        super("Ошибка валидации сущности: " + entity);
    }

    public ValidationException(String message, Throwable cause) {
        super(message, cause);
    }

    public ValidationException(Throwable cause) {
        super(cause);
    }

    public ValidationException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}