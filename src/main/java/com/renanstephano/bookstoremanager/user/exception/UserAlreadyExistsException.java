package com.renanstephano.bookstoremanager.user.exception;

import javax.persistence.EntityExistsException;

public class UserAlreadyExistsException extends EntityExistsException {

    public UserAlreadyExistsException(String name) {
        super(String.format("User with name %s already exists!", name));
    }
}
