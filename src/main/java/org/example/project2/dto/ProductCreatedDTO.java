package org.example.project2.dto;

import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.project2.model.Category;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class ProductCreatedDTO {

    private String name;
    private String description;
    private Double price;
    private Integer category;
    private Date createdAt;
}
