package com.renanstephano.bookstoremanager.rent.entity;

import com.renanstephano.bookstoremanager.books.entity.Book;
import com.renanstephano.bookstoremanager.entity.Auditable;
import com.renanstephano.bookstoremanager.user.entity.User;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "rent")
public class Rent extends Auditable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "book", nullable = false)
    private Book book;

    @ManyToOne
    @JoinColumn(name = "username", nullable = false)
    private User user;

    @Column(nullable = false)
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE, pattern = "dd-MM-yyyy")
    private LocalDate rentDate;

    @Column(nullable = false)
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE, pattern = "dd-MM-yyyy")
    private LocalDate forecastDate;

    @Column
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE, pattern = "dd-MM-yyyy")
    private LocalDate devolutionDate;
}