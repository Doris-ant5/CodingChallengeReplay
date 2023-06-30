package com.reply.challenge.repository;

import com.reply.challenge.model.Category;
import com.reply.challenge.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Integer> {

    Optional<Product> findProductByName (String name);

    List<Product> findProductsByCategory(Category category);

}
