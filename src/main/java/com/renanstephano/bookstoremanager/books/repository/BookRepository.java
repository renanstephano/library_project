package com.renanstephano.bookstoremanager.books.repository;

import com.renanstephano.bookstoremanager.books.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
}