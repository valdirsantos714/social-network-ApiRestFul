package com.valdirsantos714.ApiRestFulRedeSocial.services;

import com.valdirsantos714.ApiRestFulRedeSocial.dtos.UserDto;
import com.valdirsantos714.ApiRestFulRedeSocial.entities.User;
import com.valdirsantos714.ApiRestFulRedeSocial.repositories.UserRepository;
import com.valdirsantos714.ApiRestFulRedeSocial.services.exceptions.DataBaseException;
import com.valdirsantos714.ApiRestFulRedeSocial.services.exceptions.ResourceNotFound;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Transactional
    public User save(UserDto userDto) {
        var user = new User(userDto);

        return userRepository.save(user);
    }

    @Transactional
    public void delete(Long id) {
        try {
            userRepository.deleteById(id);

        } catch (EmptyResultDataAccessException e) {
            throw new ResourceNotFound(id);

        } catch (DataBaseException e) {
            throw new DataBaseException(e.getMessage());
        }
    }

    public List<User> findAll() {
        List<User> list = userRepository.findAll();

        return list;
    }

    public User findById(Long id) {
        Optional<User> user = userRepository.findById(id);

        return user.orElseThrow(() -> new ResourceNotFound(id));
    }

    public User update(Long id, UserDto userDto) {
        try {
            User user = userRepository.getReferenceById(id);

            updateData(user, userDto);

            return userRepository.save(user);

        } catch (EntityNotFoundException e) {
            throw new ResourceNotFound(id);
        }
    }

    private void updateData(User outdatedUser, UserDto updatedUser) {
        outdatedUser.setName(updatedUser.name());
        outdatedUser.setEmail(updatedUser.email());
    }
}
