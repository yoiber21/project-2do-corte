package org.example.project2.service;

import java.util.Date;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.example.project2.dto.AuthResponseDTO;
import org.example.project2.dto.LoginRequestDTO;
import org.example.project2.dto.RegisterRequestDTO;
import org.example.project2.exception.AlreadyExistsException;
import org.example.project2.jwt.JwtService;
import org.example.project2.model.UserEntity;
import org.example.project2.repository.IUserRepository;
import org.example.project2.util.Rol;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements IAuthService {

    private final IUserRepository userRepository;
    private final JwtService jwtService;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;

    @Override
    public AuthResponseDTO login(LoginRequestDTO userDto) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(userDto.getUsername(),userDto.getPassword()));
        UserEntity user = userRepository.findByUsername(userDto.getUsername()).orElseThrow(() -> new
                UsernameNotFoundException("USER_NOT_FOUND"));
        String token = jwtService.getToken(user);
        return AuthResponseDTO.builder()
                .token(token)
                .username(user.getUsername())
                .email(user.getEmail())
                .build();
    }


    @Override
    public AuthResponseDTO register(RegisterRequestDTO userToRegisterDto) {
        Optional<UserEntity> existingUser = userRepository.findByUsername(userToRegisterDto.getUsername());
        Optional<UserEntity> existingEmail = userRepository.findByEmail(userToRegisterDto.getEmail());
        Optional<UserEntity> existingPhone = userRepository.findByPhone(userToRegisterDto.getPhone());
        if (existingUser.isPresent()) {
            throw new AlreadyExistsException("El nombre de usuario ya está en uso");
        }
        if (existingEmail.isPresent()) {
            throw new AlreadyExistsException("El correo electronico ya está en uso");
        }
        if (existingPhone.isPresent()) {
            throw new AlreadyExistsException("El número de teléfono ya está en uso");
        }

        UserEntity user = UserEntity.builder()
                .username(userToRegisterDto.getUsername())
                .password(passwordEncoder.encode(userToRegisterDto.getPassword()))
                .firstName(userToRegisterDto.getFirstName())
                .lastName(userToRegisterDto.getLastName())
                .rol(Rol.ADMINISTRATOR)
                .email(userToRegisterDto.getEmail())
                .phone(userToRegisterDto.getPhone())
                .address(userToRegisterDto.getAddress())
                .createdAt(Date.from(java.time.Instant.now()))
                .build();


        userRepository.save(user);

        return AuthResponseDTO.builder()
                .token(jwtService.getToken(user))
                .username(user.getUsername())
                .email(user.getEmail())
                .build();
    }
}
