package org.example.project2.dto;

import java.util.List;

public record ErrorDTO (
        String explanation,
        List<String> messages
){
}
