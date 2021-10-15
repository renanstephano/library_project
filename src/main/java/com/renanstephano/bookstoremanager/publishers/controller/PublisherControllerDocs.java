package com.renanstephano.bookstoremanager.publishers.controller;

import com.renanstephano.bookstoremanager.publishers.dto.PublisherDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import java.util.List;

@Api("Publishers management")
public interface PublisherControllerDocs {

    @ApiOperation(value = "Publisher creation")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Success publisher creation"),
            @ApiResponse(code = 400, message = "Unsuccessful publisher creation")
    })
    PublisherDTO create(PublisherDTO publisherDTO);

    @ApiOperation(value = "Publisher searching operation")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Success publisher found"),
            @ApiResponse(code = 404, message = "Publisher not found")
    })
    PublisherDTO findById(Long id);

    @ApiOperation(value = "List all publishers  operation")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Success registered publishers found"),
    })
    List<PublisherDTO> findAll();

    @ApiOperation(value = "Publisher deleting operation")
    @ApiResponses(value = {
            @ApiResponse(code = 204, message = "Success publisher deleted"),
            @ApiResponse(code = 404, message = "Publisher not found")
    })
    void delete(Long id);
}
