package com.renanstephano.bookstoremanager.books.exception;

import javax.persistence.EntityNotFoundException;

public class BookNotFoundException extends EntityNotFoundException {

    public BookNotFoundException(String name) {
        super(String.format("Publisher with name %s does not exists", name));
    }
}
