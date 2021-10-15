package com.renanstephano.bookstoremanager.publishers.entity;

import com.renanstephano.bookstoremanager.books.entity.Book;
import com.renanstephano.bookstoremanager.entity.Auditable;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
public class Publisher extends Auditable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String name;

    @Column(nullable = false)
    private String city;

    @OneToMany(mappedBy = "publisher", fetch = FetchType.LAZY)
    private List<Book> books;
}
