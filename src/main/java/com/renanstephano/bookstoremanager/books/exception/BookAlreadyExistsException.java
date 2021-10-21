package com.renanstephano.bookstoremanager.books.exception;

import javax.persistence.EntityExistsException;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class BookAlreadyExistsException extends EntityExistsException {
    public BookAlreadyExistsException(String name) {

        super(String.format("Book with name %s already exists", name));
    }
}