package net.javaguides.springboot.controller;

import net.javaguides.springboot.exception.ResourceNotFoundException;
import net.javaguides.springboot.model.Product;
import net.javaguides.springboot.repository.ProductsRepos;
import net.javaguides.springboot.services.ProductService;
import net.javaguides.springboot.services.ProductServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class ProductController {

    private final ProductsRepos productsRepos;
    private final ProductServiceImpl productServiceImpl;

    public ProductController(ProductsRepos productsRepos, ProductServiceImpl productServiceImpl) {
        this.productsRepos = productsRepos;
		this.productServiceImpl = productServiceImpl;
	}

    // get all Product
    @GetMapping("/product")
    public List<Product> getAllProducts(){
        return productsRepos.findAll();
    }

    // create Product rest api
    @PostMapping("/product")
    public Product createProducts(@RequestBody Product product) {
        return productsRepos.save(product);
    }

    // get Product by id rest api
    @GetMapping("/product/{id}")
    public ResponseEntity<Product> getProductsById(@PathVariable Long id) {
        Product Product = productsRepos.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Product not exist with id :" + id));
        return ResponseEntity.ok(Product);
    }

    // update Product rest api

    @PutMapping("/product/{id}")
    public ResponseEntity<Product> updateProducts(@PathVariable Long id, @RequestBody Product productDetails){
        Product product = productsRepos.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("product not exist with id :" + id));

        product.setName(productDetails.getName());
        product.setAbout(productDetails.getAbout());
        product.setAmount(productDetails.getAmount());
        product.setCategories(productDetails.getCategories());
        product.setPrice(productDetails.getPrice());


        Product updatedProduct = productsRepos.save(product);
        return ResponseEntity.ok(updatedProduct);
    }

    // delete Product rest api
    @DeleteMapping("/product/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteProducts(@PathVariable Long id){
        Product Product = productsRepos.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Product not exist with id :" + id));

        productsRepos.delete(Product);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return ResponseEntity.ok(response);
    }
}
