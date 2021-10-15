package com.renanstephano.bookstoremanager.publishers.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PublisherDTO {

    private Long id;

    @NotNull
    @NotEmpty
    @Size(max = 200)
    private String name;

    @NotNull
    @NotEmpty
    @Size(max = 100)
    private String city;
}
