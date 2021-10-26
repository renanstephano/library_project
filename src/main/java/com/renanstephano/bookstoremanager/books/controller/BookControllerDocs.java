package com.renanstephano.bookstoremanager.books.controller;

import com.renanstephano.bookstoremanager.books.dto.BookRequestDTO;
import com.renanstephano.bookstoremanager.books.dto.BookResponseDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Api("Books management")
public interface BookControllerDocs {

    @ApiOperation(value = "Book creation operation")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Success book creation"),
            @ApiResponse(code = 400, message = "Missing required fields, wrong field range value or book already registered on system")
    })
    BookResponseDTO create(BookRequestDTO bookRequestDTO);

    @ApiOperation(value = "Book finding by Id operation")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success book found"),
            @ApiResponse(code = 404, message = "Book not found")
    })
    BookResponseDTO findById(Long bookId);

    @ApiOperation(value = "List all books operation")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success books found"),
    })
    List<BookResponseDTO> findAllBooks();

    @ApiOperation(value = "Book deleting operation")
    @ApiResponses(value = {
            @ApiResponse(code = 204, message = "Success book deleted"),
            @ApiResponse(code = 404, message = "Book not found")
    })
    void delete(@PathVariable Long bookId);

    @ApiOperation(value = "Book update operation")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success book updated"),
            @ApiResponse(code = 400, message = "Missing required fields, wrong field range value or book already registered on system")
    })
    BookResponseDTO update(BookRequestDTO bookRequestDTO);
}
