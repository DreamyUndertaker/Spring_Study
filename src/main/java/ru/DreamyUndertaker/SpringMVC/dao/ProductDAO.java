package ru.DreamyUndertaker.SpringMVC.dao;

import org.springframework.stereotype.Component;
import ru.DreamyUndertaker.SpringMVC.models.Product;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
@Component
public class ProductDAO {
    private static int PRODUCT_COUNT;
    private final List<Product> products;

    {
        products = new ArrayList<>();

        products.add(new Product(++PRODUCT_COUNT, "First", "number 1", "cat1", 0.0, 0, new Date()));
        products.add(new Product(++PRODUCT_COUNT, "Second", "number 2", "cat2", 0.0, 0, new Date()));
        products.add(new Product(++PRODUCT_COUNT, "Third", "number 3", "cat3", 0.0, 0, new Date()));
        products.add(new Product(++PRODUCT_COUNT, "Fourth", "number 4", "cat4", 0.0, 0, new Date()));
    }

    public List<Product> index(){
        return products;
    }

    public Product show(int id){
        return products.stream().filter(products -> products.getId() == id).findAny().orElse(null);
    }

    public void save(Product product){
        product.setId(++PRODUCT_COUNT);
        products.add(product);
    }
    public void update(int id, Product updeteProduct){
        Product productToBeUpdated = show(id);

        productToBeUpdated.setName(updeteProduct.getName());
        productToBeUpdated.setAbout(updeteProduct.getAbout());
        productToBeUpdated.setCategories(updeteProduct.getCategories());
        productToBeUpdated.setPrice(updeteProduct.getPrice());
        productToBeUpdated.setAmmount(updeteProduct.getAmmount());
        productToBeUpdated.setDate(updeteProduct.getDate());

    }
    public void delete(int id){
        products.removeIf(p -> p.getId() == id);
    }
}
