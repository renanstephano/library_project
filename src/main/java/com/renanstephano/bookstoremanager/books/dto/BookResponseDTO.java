package com.renanstephano.bookstoremanager.books.dto;

import com.renanstephano.bookstoremanager.publishers.dto.PublisherDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookResponseDTO {

    private Long id;

    private String name;

    private String author;

    private PublisherDTO publisher;
}
