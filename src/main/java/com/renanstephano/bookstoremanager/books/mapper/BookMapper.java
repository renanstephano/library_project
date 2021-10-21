package com.renanstephano.bookstoremanager.books.mapper;

import com.renanstephano.bookstoremanager.books.dto.BookRequestDTO;
import com.renanstephano.bookstoremanager.books.dto.BookResponseDTO;
import com.renanstephano.bookstoremanager.books.entity.Book;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface BookMapper {

    BookMapper INSTANCE = Mappers.getMapper(BookMapper.class);

        Book toModel(BookResponseDTO bookResponseDTO);

            Book toModel(BookRequestDTO bookRequestDTO);

            BookResponseDTO toDTO(Book book);
}
