package org.example.project2.service;

import java.util.Date;
import java.util.List;
import org.example.project2.dto.ProductCreatedDTO;
import org.example.project2.exception.NotFoundException;
import org.example.project2.model.Product;
import org.example.project2.repository.IProductRepository;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements IProductService {

    IProductRepository productRepository;

    public ProductServiceImpl(IProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public ProductCreatedDTO createProduct(Product product) {
        System.out.println(product);
        Product savedProduct = Product.builder()
                .name(product.getName())
                .description(product.getDescription())
                .price(product.getPrice())
                .category(product.getCategory())
                .createdAt(Date.from(java.time.Instant.now()))
                .build();

        productRepository.save(savedProduct);

        return ProductCreatedDTO.builder()
                .name(savedProduct.getName())
                .description(savedProduct.getDescription())
                .price(savedProduct.getPrice())
                .category(Math.toIntExact(savedProduct.getCategory().getId()))
                .createdAt(savedProduct.getCreatedAt())
                .build();
    }

    public ProductCreatedDTO getProductById(Integer id) {
        Product product = productRepository.findProductById(Long.valueOf(id));
        if (!productRepository.existsById(Long.valueOf(id))) {
            throw new NotFoundException("The product id doesn't exist");
        }
        return ProductCreatedDTO.builder()
                .name(product.getName())
                .description(product.getDescription())
                .price(product.getPrice())
                .build();
    }

    @Override
    public List<ProductCreatedDTO> getProductBycategoryName(String categoryName) {
        List<Product> product = productRepository.findProductByCategoryName(categoryName);
        if(product == null) {
            throw new NotFoundException("The product category doesn't exist");
        }
        return product.stream().map(p -> ProductCreatedDTO.builder()
                .name(p.getName())
                .description(p.getDescription())
                .price(p.getPrice())
                .category(Math.toIntExact(p.getCategory().getId()))
                .createdAt(p.getCreatedAt())
                .build()).toList();
    }

    @Override
    public List<ProductCreatedDTO> findAllProducts() {
        List<Product> products = productRepository.findAll();
        System.out.println(products);
        if (products.isEmpty()) {
            throw new NotFoundException("The product list is empty");
        }
        return products.stream().map(p -> ProductCreatedDTO.builder()
                .name(p.getName())
                .description(p.getDescription())
                .price(p.getPrice())
                .category(Math.toIntExact(p.getCategory().getId()))
                .createdAt(p.getCreatedAt())
                .build()).toList();
    }
}
