package org.example.project2.handlers;

import org.example.project2.dto.ExceptionDTO;
import org.example.project2.exception.AlreadyExistsException;
import org.example.project2.exception.BadRequestException;
import org.example.project2.exception.NotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = {
            AlreadyExistsException.class,
            BadRequestException.class
    })
    public ResponseEntity<ExceptionDTO> handleUsernameAlreadyExistsException(AlreadyExistsException e) {
        return ResponseEntity.badRequest()
                .body(
                        new ExceptionDTO(e.getMessage(),
                                e.getClass().getSimpleName(),
                                400));
    }

    @ExceptionHandler(value = {
            NotFoundException.class
    })
    public ResponseEntity<ExceptionDTO> handleNotFoundException(NotFoundException e) {
        return ResponseEntity.status(404)
                .body(
                        new ExceptionDTO(e.getMessage(),
                                e.getClass().getSimpleName(),
                                404));
    }
}
