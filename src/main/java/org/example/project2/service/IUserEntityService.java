package org.example.project2.service;


import java.util.Optional;
import org.example.project2.model.UserEntity;

public interface IUserEntityService {
    UserEntity findByUsername(String username);

    Optional<UserEntity> findUserById(Integer id);
}
