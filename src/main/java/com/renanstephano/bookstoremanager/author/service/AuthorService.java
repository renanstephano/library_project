package com.renanstephano.bookstoremanager.author.service;

import com.renanstephano.bookstoremanager.author.dto.AuthorDTO;
import com.renanstephano.bookstoremanager.author.entity.Author;
import com.renanstephano.bookstoremanager.author.exception.AuthorAlreadyExistsException;
import com.renanstephano.bookstoremanager.author.exception.AuthorNotFoundException;
import com.renanstephano.bookstoremanager.author.mapper.AuthorMapper;
import com.renanstephano.bookstoremanager.author.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AuthorService {

    private final static AuthorMapper authorMapper = AuthorMapper.INSTANCE;

    public AuthorRepository authorRepository;

    @Autowired
    public AuthorService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    public AuthorDTO create(AuthorDTO authorDTO){
        verifyIfExists(authorDTO.getName());
        Author authorToCreate = authorMapper.toModel(authorDTO);
        Author createdAuthor = authorRepository.save(authorToCreate);
        return authorMapper.toDTO(createdAuthor);
    }

    public AuthorDTO findById(Long id){
        Author foundAuthor = verifyAndGetAuthor(id);
        return authorMapper.toDTO(foundAuthor);
    }

    public List<AuthorDTO> findAll(){
        return authorRepository.findAll()
                .stream()
                .map(authorMapper::toDTO)
                .collect(Collectors.toList());
    }

    private void verifyIfExists(String authorName) {
        authorRepository.findByName(authorName)
                .ifPresent(author -> {throw new AuthorAlreadyExistsException(authorName); });
    }

    public void delete(Long id){
        verifyAndGetAuthor(id);
        authorRepository.deleteById(id);
    }

    public Author verifyAndGetAuthor(Long id) {
        Author foundAuthor = authorRepository.findById(id)
                .orElseThrow(() -> new AuthorNotFoundException(id));
        return foundAuthor;
    }

    public void update(Long id, AuthorDTO authorToUpdateDTO){
        Author foundAuthor = verifyAndGetAuthor(id);

        authorToUpdateDTO.setId(foundAuthor.getId());
        Author authorToUpdate = authorMapper.toModel(authorToUpdateDTO);
        authorToUpdate.setCreatedDate(foundAuthor.getCreatedDate());

        Author authorUpdated = authorRepository.save(authorToUpdate);
    }

}
