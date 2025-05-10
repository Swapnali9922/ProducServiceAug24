package com.example.productservice.services;

import com.example.productservice.exceptions.ProductNotFoundException;
import com.example.productservice.models.Product;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProductService {
    public Product getProductById(long id) throws ProductNotFoundException;
    public List<Product> getAllProducts();
    public Product createNewProduct(Product product);
    //public Product updateProduct(long id, Product product);
    void deleteProductById(long id);
}
