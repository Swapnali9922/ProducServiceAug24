package com.example.productservice.controllers;

import com.example.productservice.exceptions.ProductNotFoundException;
import com.example.productservice.models.Product;
import com.example.productservice.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {

                   //Get //products/id
    @Autowired
    private ProductService productService;
    //get product by given id
 @GetMapping("/products/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable("id") long Productid ) throws ProductNotFoundException {
//     if(Productid <1 || Productid>20)
//         return new ResponseEntity<>(HttpStatusCode.valueOf(400));
     Product product=productService.getProductById(Productid);
     return new ResponseEntity<>(product,HttpStatusCode.valueOf(200));


 }

 //Get all products
 @GetMapping("/products")
public ResponseEntity<List<Product>> getAllProducts(){
     List<Product> products=productService.getAllProducts();
     return new ResponseEntity<>(products,HttpStatusCode.valueOf(200));
}

//create a new product
    @PostMapping("/products")
    public ResponseEntity<Product> createNewProduct(@RequestBody Product product){
             Product pro= productService.createNewProduct(product);
             return ResponseEntity.status(HttpStatus.CREATED).body(pro);

    }
    //update a product
//    @PutMapping("/products/{id}")
//    public ResponseEntity<Product> updateProduct(@PathVariable("id") long id,@RequestBody Product product)
//    {
//        Product prod=productService.updateProduct(id,product);
//        return new ResponseEntity<>(prod,HttpStatusCode.valueOf(200));
//    }

    //delete a product
    @DeleteMapping("/products/{id}")
    public ResponseEntity<String> deleteproduct(@PathVariable("id") long id){
           productService.deleteProductById(id);
           return new ResponseEntity<>("Product deleted",HttpStatus.OK);
    }

}
