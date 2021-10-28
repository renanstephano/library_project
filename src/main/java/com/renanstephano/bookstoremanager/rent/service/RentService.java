package com.renanstephano.bookstoremanager.rent.service;

import com.renanstephano.bookstoremanager.books.entity.Book;
import com.renanstephano.bookstoremanager.books.service.BookService;
import com.renanstephano.bookstoremanager.rent.dto.RentRequestDTO;
import com.renanstephano.bookstoremanager.rent.dto.RentResponseDTO;
import com.renanstephano.bookstoremanager.rent.entity.Rent;
import com.renanstephano.bookstoremanager.rent.mapper.RentMapper;
import com.renanstephano.bookstoremanager.rent.repository.RentRepository;
import com.renanstephano.bookstoremanager.user.entity.User;
import com.renanstephano.bookstoremanager.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RentService {

    private final RentMapper rentMapper;

    private final RentRepository rentRepository;

    private final BookService bookService;

    private final UserService userService;

    @Autowired
    public RentService(RentMapper rentMapper, RentRepository rentRepository, BookService bookService, UserService userService) {
        this.rentRepository = rentRepository;
        this.rentMapper = rentMapper;
        this.bookService = bookService;
        this.userService = userService;
    }

    public RentResponseDTO create(RentRequestDTO rentRequestDTO) {
        Book foundBook = bookService.verifyAndGetBook(rentRequestDTO.getBookId());
        User foundUser = userService.verifyAndGetUser(rentRequestDTO.getUserId());

        Rent rentToCreate = rentMapper.toModel(rentRequestDTO);
        rentToCreate.setBook(foundBook);
        rentToCreate.setUser(foundUser);
        Rent rentCreated = rentRepository.save(rentToCreate);

        return rentMapper.toDTO(rentCreated);
    }

}
