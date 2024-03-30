package org.example.project2.service;

import java.util.List;
import org.example.project2.dto.ProductCreatedDTO;
import org.example.project2.model.Product;

public interface IProductService {

    ProductCreatedDTO createProduct(Product product);

    ProductCreatedDTO getProductById(Integer id);

    List<ProductCreatedDTO> getProductBycategoryName(String categoryName);

    List<ProductCreatedDTO> findAllProducts();
}
