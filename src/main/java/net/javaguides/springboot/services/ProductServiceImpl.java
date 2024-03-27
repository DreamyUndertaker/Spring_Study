package net.javaguides.springboot.services;

import net.javaguides.springboot.model.Product;
import net.javaguides.springboot.repository.ProductsRepos;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
@Component
public class ProductServiceImpl implements ProductService {
    ProductsRepos productsRepos;

    @Override
    public List<Product> getAllProducts() {
        return null;
    }

    @Override
    public Optional<Product> findById(int id) {
        return Optional.empty();
    }

    @Override
    public Optional<Product> findByEmail(String email) {
        return Optional.empty();
    }

    @Override
    public Product save(Product std) {
        return null;
    }

    @Override
    public void deleteById(int id) {

    }
}
