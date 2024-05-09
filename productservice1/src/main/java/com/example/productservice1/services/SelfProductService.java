package com.example.productservice1.services;

import com.example.productservice1.models.Category;
import com.example.productservice1.models.Product;
import com.example.productservice1.repositories.CategoryRepository;
import com.example.productservice1.repositories.ProductRepositories;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.util.List;

@Getter
@Setter
@Service("SelfProductService")
public class SelfProductService implements ProductService{
    private ProductRepositories productRepositories;
    private CategoryRepository categoryRepository;
    public SelfProductService(ProductRepositories productRepositories,CategoryRepository categoryRepository){
        this.productRepositories=productRepositories;
        this.categoryRepository=categoryRepository;
    }
    @Override
    public Product getSingleProduct(Long productId) {

        return null;
    }

    @Override
    public List<Product> getProducts() {
        return null;
    }

    @Override
    public Product createProduct(String title, String description, String category, double price, String image) {
        Product product=new Product();
        product.setTitle(title);
        product.setDescription(description);
        product.setPrice(price);
        product.setImageUrl(image);
        Category category1 =categoryRepository.findByTitle(category);
        if(category1==null){
category1=new Category();
category1.setTitle(title);
        }
        product.setCategory(category1);
        return null;
    }
}
