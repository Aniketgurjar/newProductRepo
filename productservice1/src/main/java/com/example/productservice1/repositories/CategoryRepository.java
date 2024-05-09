package com.example.productservice1.repositories;

import com.example.productservice1.models.Category;
import org.hibernate.annotations.processing.Find;

public interface CategoryRepository {
Category findByTitle(String title);

}
