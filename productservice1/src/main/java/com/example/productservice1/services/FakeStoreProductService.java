package com.example.productservice1.services;

import com.example.productservice1.dtos.FakeStoreProductDto;
import com.example.productservice1.models.Product;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service("fakestoreproductservice")
public class FakeStoreProductService implements ProductService {
    private RestTemplate restTemplate;

    public FakeStoreProductService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public Product getSingleProduct(Long productId) {
        ResponseEntity<FakeStoreProductDto> fakeStoreProductResponse = restTemplate.getForEntity("https://fakestoreapi.com/products/" + productId, FakeStoreProductDto.class);

        if (fakeStoreProductResponse.getStatusCode() != HttpStatusCode.valueOf(200)) {

        }
        FakeStoreProductDto fakeStoreProduct = fakeStoreProductResponse.getBody();
        return fakeStoreProduct.toProduct();
    }

    @Override
    public List<Product> getProducts() {

        FakeStoreProductDto[] fakeStoreProducts = restTemplate.getForObject("https://fakestoreapi.com/products", FakeStoreProductDto[].class);


        List<Product> products = new ArrayList<>();


        for (FakeStoreProductDto fakeStoreProduct : fakeStoreProducts) {

            products.add(fakeStoreProduct.toProduct());
        }


        return products;
    }




    @Override
    public Product createProduct(String title,
                                 String description,

                                 String category,
                                 double price,
                                 String image) {
        FakeStoreProductDto fakeStoreProductDto=new FakeStoreProductDto();
        fakeStoreProductDto.setTitle(title);
        fakeStoreProductDto.setCategory(category);
        fakeStoreProductDto.setPrice(price);
        fakeStoreProductDto.setImage(image);
         fakeStoreProductDto.setDescription(description);
        FakeStoreProductDto response=restTemplate.postForObject(
                "https://fakestoreapi.com/products",
                fakeStoreProductDto,
                FakeStoreProductDto.class
        );
        return response.toProduct();
    }

}