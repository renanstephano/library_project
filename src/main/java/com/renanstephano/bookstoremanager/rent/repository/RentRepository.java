package com.renanstephano.bookstoremanager.rent.repository;

import com.renanstephano.bookstoremanager.rent.entity.Rent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RentRepository  extends JpaRepository<Rent, Long> {
}
