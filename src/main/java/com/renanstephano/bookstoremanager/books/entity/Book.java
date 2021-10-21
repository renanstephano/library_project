package com.renanstephano.bookstoremanager.books.entity;

import com.renanstephano.bookstoremanager.entity.Auditable;
import com.renanstephano.bookstoremanager.publishers.entity.Publisher;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Book extends Auditable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String name;

    @Column(nullable = false)
    private String author;

    @ManyToOne(cascade = {CascadeType.MERGE})
    private Publisher publisher;
}