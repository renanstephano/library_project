package com.renanstephano.bookstoremanager.rent.controller;

import com.renanstephano.bookstoremanager.books.dto.BookResponseDTO;
import com.renanstephano.bookstoremanager.books.service.BookService;
import com.renanstephano.bookstoremanager.rent.dto.RentRequestDTO;
import com.renanstephano.bookstoremanager.rent.dto.RentResponseDTO;
import com.renanstephano.bookstoremanager.rent.service.RentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/rent")
public class RentController implements RentControllerDocs{

    private final RentService rentService;

    @Autowired
    public RentController(RentService rentService) {
        this.rentService = rentService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public RentResponseDTO create(@RequestBody @Valid RentRequestDTO rentRequestDTO) {
        return rentService.create(rentRequestDTO);
    }

    @GetMapping
    public List<RentResponseDTO> findAllRent() {
        return rentService.findAllRent();
    }

    @PutMapping
    public RentResponseDTO update(@RequestBody @Valid RentRequestDTO rentRequestDTO) {
        return rentService.update(rentRequestDTO);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(Long id) {
        rentService.deleteById(id);
    }
}
