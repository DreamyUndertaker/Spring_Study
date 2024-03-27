package net.javaguides.springboot.services;

import net.javaguides.springboot.model.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {
    List<Product> getAllProducts();
    Optional<Product> findById(int id);
    Optional<Product> findByEmail(String email);
    Product save(Product std);
    void deleteById(int id);
}
