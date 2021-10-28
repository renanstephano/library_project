package com.renanstephano.bookstoremanager.rent.controller;

import com.renanstephano.bookstoremanager.rent.dto.RentRequestDTO;
import com.renanstephano.bookstoremanager.rent.dto.RentResponseDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;

@Api("Rent management")
public interface RentControllerDocs {

    @ApiOperation(value = "Rent creation operation")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Success rent created"),
            @ApiResponse(code = 400, message = "Missing required fields or wrong field range value")
    })
    RentResponseDTO create(RentRequestDTO rentRequestDTO);
}
