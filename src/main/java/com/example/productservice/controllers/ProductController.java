package com.example.productservice.controllers;

import com.example.productservice.exceptions.ProductNotFoundException;
import com.example.productservice.models.Product;
import com.example.productservice.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {

                   //Get //products/id
    @Autowired
    private ProductService productService;
 @GetMapping("/products/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable("id") long Productid ) throws ProductNotFoundException {
//     if(Productid <1 || Productid>20)
//         return new ResponseEntity<>(HttpStatusCode.valueOf(400));
     Product product=productService.getProductById(Productid);
     return new ResponseEntity<>(product,HttpStatusCode.valueOf(200));


 }

 @ExceptionHandler(ProductNotFoundException.class)
 public ResponseEntity<String> getProductNotFoundexception(ProductNotFoundException e){
       return new ResponseEntity<>(e.getMessage(),HttpStatusCode.valueOf(400));
 }

}
