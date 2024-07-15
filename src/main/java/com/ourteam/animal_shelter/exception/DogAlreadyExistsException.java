package com.ourteam.animal_shelter.exception;

public class DogAlreadyExistsException extends RuntimeException {
    public DogAlreadyExistsException(String message) {
        super(message);
    }
}
