package org.example.project2.controller;

import java.util.List;
import org.example.project2.dto.ProductCreatedDTO;
import org.example.project2.dto.ProductDTO;
import org.example.project2.jwt.JwtService;
import org.example.project2.model.Category;
import org.example.project2.model.Product;
import org.example.project2.model.UserEntity;
import org.example.project2.service.ICategoryService;
import org.example.project2.service.IProductService;
import org.example.project2.service.IUserEntityService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Validated
@RequestMapping("/products")
public class ProductController {

    private final IProductService productService;

    private final IUserEntityService userEntityService;

    private final ICategoryService categoryService;

    private final JwtService jwtService;

    public ProductController(IProductService productService, IUserEntityService userEntityService, ICategoryService categoryService, JwtService jwtService) {
        this.productService = productService;
        this.userEntityService = userEntityService;
        this.categoryService = categoryService;
        this.jwtService = jwtService;
    }

    // Methods
    @PostMapping("/create")
    public ResponseEntity<ProductCreatedDTO> createProduct(@RequestBody ProductDTO productDTO,
                                                           @RequestHeader("Authorization")
                                                           String token) {
        String username = jwtService.getUsernameFromToken(token.substring(7));
        UserEntity user = userEntityService.findByUsername(username);
        Category category = categoryService.findCategoryById(productDTO.getCategory());
        Product product = Product.builder()
                .name(productDTO.getName())
                .description(productDTO.getDescription())
                .price(productDTO.getPrice())
                .category(category)
                .build();
        return new ResponseEntity<>(productService.createProduct(product), HttpStatus.CREATED);
    }

    @GetMapping("/product")
    public ResponseEntity<ProductCreatedDTO> getProductById(@RequestParam Integer id) {
        return new ResponseEntity<>(productService.getProductById(id), HttpStatus.OK);
    }

    @GetMapping("/products-category")
    public ResponseEntity<List<ProductCreatedDTO>> getProductBycategoryName(@RequestParam String category) {
        return new ResponseEntity<>(productService.getProductBycategoryName(category), HttpStatus.OK);
    }

    @GetMapping("/list")
    public ResponseEntity<List<ProductCreatedDTO>> getAllProducts(@RequestHeader("Authorization") String token) {
        String username = jwtService.getUsernameFromToken(token.substring(7));
        UserEntity user = userEntityService.findByUsername(username);
        if (user == null || !user.hasPermission("view_all_products")) {
            throw new AccessDeniedException("Forbidden");
        }
        return new ResponseEntity<>(productService.findAllProducts(), HttpStatus.OK);
    }
}
