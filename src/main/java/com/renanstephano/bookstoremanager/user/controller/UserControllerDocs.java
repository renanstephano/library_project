package com.renanstephano.bookstoremanager.user.controller;

import com.renanstephano.bookstoremanager.user.dto.UserDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Api("Users management")
public interface UserControllerDocs {

    @ApiOperation(value = "User creation operation")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Success user creation"),
            @ApiResponse(code = 400, message = "Missing required fields, wrong field range value or user already registered on system")
    })
    UserDTO create(UserDTO userDTO);

    @ApiOperation(value = "Find user by Id operation")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success user found"),
            @ApiResponse(code = 404, message = "User not found error code")
    })
    UserDTO findById(@PathVariable Long id);

    @ApiOperation(value = "List all registered users")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Return all registered users"),
    })
    List<UserDTO> findAll();

    @ApiOperation(value = "Delete user by id operation")
    @ApiResponses(value = {
            @ApiResponse(code = 204, message = "Success user deleted"),
            @ApiResponse(code = 404, message = "User not found error code")
    })
    void delete(Long id);

    @ApiOperation(value = "User update operation")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success user updated"),
            @ApiResponse(code = 400, message = "Missing required fields, wrong field range" +
                    "value or user already registered on system")
    })
    void update(Long id, UserDTO userToUpdateDTO);
}
