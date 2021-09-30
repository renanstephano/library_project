package com.renanstephano.bookstoremanager.users.repository;

import com.renanstephano.bookstoremanager.users.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
