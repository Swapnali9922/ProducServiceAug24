package com.example.productservice.services;

import com.example.productservice.exceptions.ProductNotFoundException;
import com.example.productservice.models.Product;
import org.springframework.stereotype.Service;

@Service
public interface ProductService {
    public Product getProductById(long id) throws ProductNotFoundException;
}
