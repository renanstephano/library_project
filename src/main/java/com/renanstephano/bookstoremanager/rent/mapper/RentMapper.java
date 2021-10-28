package com.renanstephano.bookstoremanager.rent.mapper;

import com.renanstephano.bookstoremanager.books.mapper.BookMapper;
import com.renanstephano.bookstoremanager.rent.dto.RentRequestDTO;
import com.renanstephano.bookstoremanager.rent.dto.RentResponseDTO;
import com.renanstephano.bookstoremanager.rent.entity.Rent;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface RentMapper {

    Rent toModel(RentRequestDTO rentRequestDTO);
    Rent toModel(RentResponseDTO rentRequestDTO);

    RentResponseDTO toDTO(Rent rent);
}
