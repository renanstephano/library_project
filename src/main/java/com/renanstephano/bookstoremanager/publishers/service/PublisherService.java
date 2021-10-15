package com.renanstephano.bookstoremanager.publishers.service;


import com.renanstephano.bookstoremanager.publishers.dto.PublisherDTO;
import com.renanstephano.bookstoremanager.publishers.entity.Publisher;
import com.renanstephano.bookstoremanager.publishers.exception.PublisherNotFoundException;
import com.renanstephano.bookstoremanager.publishers.mapper.PublisherMapper;
import com.renanstephano.bookstoremanager.publishers.repository.PublisherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PublisherService {

    private final static PublisherMapper publisherMapper = PublisherMapper.INSTANCE;

    private PublisherRepository publisherRepository;

    @Autowired
    public PublisherService(PublisherRepository publisherRepository) {
        this.publisherRepository = publisherRepository;
    }

    public PublisherDTO create(PublisherDTO publisherDTO){
        Publisher publisherToCreate = publisherMapper.toModel(publisherDTO);
        Publisher createdPublisher = publisherRepository.save(publisherToCreate);
        return publisherMapper.toDTO(createdPublisher);
    }

    public PublisherDTO findById(Long id){
        return publisherRepository.findById(id)
                .map(publisherMapper::toDTO)
                .orElseThrow(() -> new PublisherNotFoundException(id));
    }

    public List<PublisherDTO> findAll(){
        return publisherRepository.findAll()
                .stream()
                .map(publisherMapper::toDTO)
                .collect(Collectors.toList());
    }

    public void delete(Long id){
        verifyIfExists(id);
        publisherRepository.deleteById(id);
    }

    public Publisher verifyIfExists(Long id) {
        return publisherRepository.findById(id)
                        .orElseThrow(() -> new PublisherNotFoundException(id));
    }

    private Publisher verifyAndGetPublisher(Long id) {
        return publisherRepository.findById(id)
                .orElseThrow(() -> new PublisherNotFoundException(id));
    }

    public void update(Long id, PublisherDTO publisherToUpdateDTO){
        Publisher foundPublisher = verifyAndGetPublisher(id);

        publisherToUpdateDTO.setId(foundPublisher.getId());
        Publisher publisherToUpdate = publisherMapper.toModel(publisherToUpdateDTO);
        publisherToUpdate.setCreatedDate(foundPublisher.getCreatedDate());

        Publisher publisherUpdated = publisherRepository.save(publisherToUpdate);
    }
}
