package com.renanstephano.bookstoremanager.user.entity;

import com.renanstephano.bookstoremanager.entity.Auditable;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class User extends Auditable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String name;

    @Column(nullable = false)
    private String address;

    @Column(nullable = false)
    private String city;

    @Column(nullable = false, unique = true)
    private String email;
}
