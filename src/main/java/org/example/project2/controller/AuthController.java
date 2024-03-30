package org.example.project2.controller;


import org.example.project2.dto.LoginRequestDTO;
import org.example.project2.dto.RegisterRequestDTO;
import org.example.project2.service.AuthServiceImpl;
import org.example.project2.service.IAuthService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {
    IAuthService service;

    public AuthController(AuthServiceImpl service){
        this.service = service;
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequestDTO loginRequestDto){
        return ResponseEntity.ok(service.login(loginRequestDto));
    }

    @PostMapping("/signup")
    public ResponseEntity<?> register(@RequestBody RegisterRequestDTO registerRequestDto){
        return ResponseEntity.ok(service.register(registerRequestDto));
    }
}
