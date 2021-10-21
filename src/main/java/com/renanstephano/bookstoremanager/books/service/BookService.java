package com.renanstephano.bookstoremanager.books.service;

import com.renanstephano.bookstoremanager.books.dto.BookRequestDTO;
import com.renanstephano.bookstoremanager.books.dto.BookResponseDTO;
import com.renanstephano.bookstoremanager.books.entity.Book;
import com.renanstephano.bookstoremanager.books.exception.BookAlreadyExistsException;
import com.renanstephano.bookstoremanager.books.exception.BookNotFoundException;
import com.renanstephano.bookstoremanager.books.mapper.BookMapper;
import com.renanstephano.bookstoremanager.books.repository.BookRepository;
import com.renanstephano.bookstoremanager.publishers.entity.Publisher;
import com.renanstephano.bookstoremanager.publishers.service.PublisherService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class BookService {


    private final BookMapper bookMapper = BookMapper.INSTANCE;

    private PublisherService publisherService;

    public BookRepository bookRepository;


    public BookResponseDTO create(BookRequestDTO bookRequestDTO) {
        verifyIfExists(bookRequestDTO.getName());
        Publisher foundPublisher = publisherService.verifyAndGetPublisher((bookRequestDTO.getPublisherId()));
        verifyIfBookIsAlreadyRegistered(bookRequestDTO);

        System.out.println(foundPublisher.getName());
        Book bookToCreate = bookMapper.toModel(bookRequestDTO);
        bookToCreate.setPublisher(foundPublisher);
        Book createdBook = bookRepository.save(bookToCreate);
        return bookMapper.toDTO(createdBook);
    }

    private void verifyIfBookIsAlreadyRegistered(BookRequestDTO bookRequestDTO) {
        bookRepository.findByName(bookRequestDTO.getName())
                .ifPresent(duplicatedBook -> {
                    throw new BookAlreadyExistsException(bookRequestDTO.getName());
                });
    }

    private void verifyIfExists(String bookName) {
        bookRepository.findByName(bookName)
                .ifPresent(book -> {
                    throw new BookNotFoundException(bookName);
                });
    }
}
