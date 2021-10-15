package com.renanstephano.bookstoremanager.author.exception;

import javax.persistence.EntityNotFoundException;

public class AuthorNotFoundException extends EntityNotFoundException {
    public AuthorNotFoundException(Long id) {
        super(String.format("Author with id %s do not exists!", id));
    }
}
