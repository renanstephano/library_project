package com.renanstephano.bookstoremanager.books.repository;

import com.renanstephano.bookstoremanager.books.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BookRepository extends JpaRepository<Book, Long> {

    Optional<Book> findByName(String name);

    Optional<Book> findById(Long id);

}