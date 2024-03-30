package org.example.project2.service;

import java.util.Optional;
import org.example.project2.exception.NotFoundException;
import org.example.project2.model.UserEntity;
import org.example.project2.repository.IUserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserEntityServiceImpl implements IUserEntityService {
    IUserRepository userRepository;

    public UserEntityServiceImpl(IUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserEntity findByUsername(String username) {
        return userRepository.findByUsername(username).orElseThrow(() -> new NotFoundException("The Username doesn't exists"));
    }

    @Override
    public Optional<UserEntity> findUserById(Integer id) {
        return userRepository.findById(Long.valueOf(id));
    }
}
