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
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class BookService {

    private final BookMapper bookMapper = BookMapper.INSTANCE;

    private final PublisherService publisherService;

    public final BookRepository bookRepository;

    public BookResponseDTO create(BookRequestDTO bookRequestDTO) {
        verifyIfExists(bookRequestDTO.getName());
        Publisher foundPublisher = publisherService.verifyAndGetPublisher((bookRequestDTO.getPublisherId()));

        Book bookToCreate = bookMapper.toModel(bookRequestDTO);
        bookToCreate.setPublisher(foundPublisher);
        Book createdBook = bookRepository.save(bookToCreate);
        return bookMapper.toDTO(createdBook);
    }

    public BookResponseDTO findById(Long bookId) {
        return bookRepository.findById(bookId)
                .map(bookMapper::toDTO)
                .orElseThrow(() -> new BookNotFoundException(bookId));
    }

    public List<BookResponseDTO> findAllBooks() {
        return bookRepository.findAll()
                .stream()
                .map(bookMapper::toDTO)
                .collect(Collectors.toList());
    }

    public BookResponseDTO update(BookRequestDTO bookRequestDTO) {
        Book foundBook = verifyAndGetBook(bookRequestDTO.getPublisherId());

        Book bookToUpdate = bookMapper.toModel(bookRequestDTO);
        bookToUpdate.setPublisher(foundBook.getPublisher());
        Book bookUpdated = bookRepository.save(bookToUpdate);

        return bookMapper.toDTO(bookUpdated);
    }

    @Transactional
    public void delete(Long bookId) {
        verifyAndGetBook(bookId);
        bookRepository.deleteById(bookId);
    }

//    exceptions
    public Book verifyAndGetBook(Long bookId) {
        return bookRepository.findById(bookId)
                .orElseThrow(() -> new BookNotFoundException(bookId));
    }

    private void verifyIfExists(String bookName) {
        bookRepository.findByName(bookName)
                .ifPresent(book -> {
                    throw new BookAlreadyExistsException(bookName);
                });
    }
}
