package org.example.project2.dto;


public record ExceptionDTO(
        String message,
        String className,
        Integer status
){
}