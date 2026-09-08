package com.nit.exception;


public class UserNotFoundException
        extends RuntimeException {

    public UserNotFoundException(
            String message) {

        super(message);
    }
}