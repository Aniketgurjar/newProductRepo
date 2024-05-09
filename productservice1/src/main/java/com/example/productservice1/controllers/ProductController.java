package com.example.productservice1.controllers;

import com.example.productservice1.dtos.CreateProductRequestDto;
import com.example.productservice1.models.Product;
import com.example.productservice1.services.FakeStoreProductService;
import com.example.productservice1.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.awt.*;
import java.util.List;

@RestController
public class ProductController {

    private ProductService productService;
    private RestTemplate restTemplate;

    public ProductController(@Qualifier("SelfProductService") ProductService productService, RestTemplate restTemplate) {

        this.productService = productService;
        this.restTemplate = restTemplate;
    }

    @PostMapping("/products")
    public Product createProduct(@RequestBody CreateProductRequestDto request) {
return productService.createProduct(
        request.getTitle(),
        request.getDescription(),request.getCategory(), request.getPrice(), request.getImage());
    }

    @GetMapping("/products/{id}")
    public Product getProductDetails(@PathVariable("id") Long productId) {

        return productService.getSingleProduct(productId);

    }

    @GetMapping("/products")
    public ResponseEntity<List<Product>> getAllProduct() {
List<Product>products= productService.getProducts();
ResponseEntity<List<Product>> response=new ResponseEntity<>(products, HttpStatus
        .NOT_FOUND);
        return response;
    }

    public void updateProduct() {

    }
}
