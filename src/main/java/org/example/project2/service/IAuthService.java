package org.example.project2.service;


import org.example.project2.dto.AuthResponseDTO;
import org.example.project2.dto.LoginRequestDTO;
import org.example.project2.dto.RegisterRequestDTO;

public interface IAuthService {
    AuthResponseDTO login(LoginRequestDTO userDto);

    AuthResponseDTO register(RegisterRequestDTO userToRegisterDto);

}
