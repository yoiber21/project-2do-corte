package org.example.project2.repository;

import java.util.List;
import org.example.project2.dto.ProductCreatedDTO;
import org.example.project2.model.Category;
import org.example.project2.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface IProductRepository extends JpaRepository<Product, Long> {
    Product findProductById(Long id);

    @Query("SELECT p FROM Product p WHERE p.category.description = :category")
    List<Product> findProductByCategoryName(String category);
}
