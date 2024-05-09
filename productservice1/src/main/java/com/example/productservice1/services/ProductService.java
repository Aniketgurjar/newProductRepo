package com.example.productservice1.services;

import com.example.productservice1.dtos.CreateProductRequestDto;
import com.example.productservice1.models.Product;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.util.List;

public interface ProductService {
    Product getSingleProduct(Long productId);
    List<Product> getProducts();
    Product createProduct(String title,
    String description,
                          String Category,
                          double price,
                          String image
    );


}

