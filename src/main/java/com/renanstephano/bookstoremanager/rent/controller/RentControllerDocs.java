package com.renanstephano.bookstoremanager.rent.controller;

import com.renanstephano.bookstoremanager.rent.dto.RentRequestDTO;
import com.renanstephano.bookstoremanager.rent.dto.RentResponseDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;
import java.util.List;

@Api("Rent management")
public interface RentControllerDocs {

    @ApiOperation(value = "Rent creation operation")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Success rent created"),
            @ApiResponse(code = 400, message = "Missing required fields or wrong field range value")
    })
    RentResponseDTO create(RentRequestDTO rentRequestDTO);

    @ApiOperation(value = "List all rents operation")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success rents found"),
    })
    List<RentResponseDTO> findAllRent();

    @ApiOperation(value = "Rent deleting operation")
    @ApiResponses(value = {
            @ApiResponse(code = 204, message = "Success rent deleted"),
            @ApiResponse(code = 404, message = "Rent not found")
    })
    void deleteById(@PathVariable Long id);

    @ApiOperation(value = "Rent update operation")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success rent updated"),
            @ApiResponse(code = 400, message = "Missing required fields, wrong field range value or rent already registered on system")
    })
    RentResponseDTO update(RentRequestDTO rentRequestDTO);
}
