package com.renanstephano.bookstoremanager.author.repository;

import com.renanstephano.bookstoremanager.author.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author, Long> {
}
