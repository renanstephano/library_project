package com.renanstephano.bookstoremanager.user.service;

import com.renanstephano.bookstoremanager.user.dto.UserDTO;
import com.renanstephano.bookstoremanager.user.entity.User;
import com.renanstephano.bookstoremanager.user.exception.UserAlreadyExistsException;
import com.renanstephano.bookstoremanager.user.exception.UserNotFoundException;
import com.renanstephano.bookstoremanager.user.mapper.UserMapper;
import com.renanstephano.bookstoremanager.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {

    private final static UserMapper USER_MAPPER = UserMapper.INSTANCE;

    public UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserDTO create(UserDTO userDTO){
        verifyIfExists(userDTO.getName());
        User userToCreate = USER_MAPPER.toModel(userDTO);
        User createdUser = userRepository.save(userToCreate);
        return USER_MAPPER.toDTO(createdUser);
    }

    public UserDTO findById(Long id){
        User foundUser = verifyAndGetUser(id);
        return USER_MAPPER.toDTO(foundUser);
    }

    public List<UserDTO> findAll(){
        return userRepository.findAll()
                .stream()
                .map(USER_MAPPER::toDTO)
                .collect(Collectors.toList());
    }

    private void verifyIfExists(String authorName) {
        userRepository.findByName(authorName)
                .ifPresent(author -> {throw new UserAlreadyExistsException(authorName); });
    }

    public void delete(Long id){
        verifyAndGetUser(id);
        userRepository.deleteById(id);
    }

    public User verifyAndGetUser(Long id) {
        User foundUser = userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException(id));
        return foundUser;
    }

    public void update(Long id, UserDTO userToUpdateDTO){
        User foundUser = verifyAndGetUser(id);

        userToUpdateDTO.setId(foundUser.getId());
        User userToUpdate = USER_MAPPER.toModel(userToUpdateDTO);
        userToUpdate.setCreatedDate(foundUser.getCreatedDate());

        User userUpdated = userRepository.save(userToUpdate);
    }

}
