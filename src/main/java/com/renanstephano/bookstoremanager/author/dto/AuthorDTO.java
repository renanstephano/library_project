package com.renanstephano.bookstoremanager.author.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AuthorDTO {

    private Long id;

    @NotNull
    @NotEmpty
    @Size(max = 300)
    private String name;

    @NotNull
    @Size(max = 150)
    private String address;

    @NotNull
    @NotEmpty
    @Size(max = 100)
    private String city;

    @Email
    @NotNull
    @Size(max = 100)
    private String email;
}
