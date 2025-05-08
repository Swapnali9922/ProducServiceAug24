package com.example.productservice.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
//@RequestMapping("/products")
public class ProductController {

    @GetMapping("/hello")
    public String sayHello(){
        return "Hello Swapnali";
    }
    @GetMapping("/hello/{name}/seat/{sid}")
    public String helloBYName(@PathVariable("name") String  Dynamname, @PathVariable("sid") int id){
        return "Helllo"+ Dynamname+"seat"+id;
    }
//    @GetMapping("/{productId}")
//    public void getProductById(@PathVariable int product_id) {
//        System.out.println("product_id" + product_id);
//    }
}
