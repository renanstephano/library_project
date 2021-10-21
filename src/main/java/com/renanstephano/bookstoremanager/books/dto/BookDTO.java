package com.renanstephano.bookstoremanager.books.dto;


import com.renanstephano.bookstoremanager.publishers.entity.Publisher;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.ManyToOne;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookDTO {

    private Long id;


    @NotNull
    @NotEmpty
    @Size(max = 300)
    private String name;

    @NotNull
    @Size(max = 150)
    private String author;

    @NotNull
    @ManyToOne
    private Publisher publisher;
}
