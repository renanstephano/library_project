package com.renanstephano.bookstoremanager.publishers.repository;

import com.renanstephano.bookstoremanager.publishers.entity.Publisher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PublisherRepository extends JpaRepository<Publisher, Long> {
}
