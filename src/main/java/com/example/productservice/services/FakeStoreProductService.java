package com.example.productservice.services;

import com.example.productservice.dtos.FakeStoreProductDtos;
import com.example.productservice.exceptions.ProductNotFoundException;
import com.example.productservice.models.Product;
import org.springframework.http.HttpEntity;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.http.HttpHeaders;
import java.util.ArrayList;
import java.util.List;

@Service
public class FakeStoreProductService implements ProductService {


    @Override
    public Product getProductById(long id) throws ProductNotFoundException {
        /*
        Take the id from the input and call this endpoint
        https://fakestoreapi.com/products + id
         */
       String url="https://fakestoreapi.com/products/"+id;
        RestTemplate restTemplate=new RestTemplate();
        FakeStoreProductDtos fakeStoreProductDtos=restTemplate.getForObject(url, FakeStoreProductDtos.class);
          if(fakeStoreProductDtos==null)
          {
              throw new ProductNotFoundException("product with id "+ id +" not found");
          }
        return convertFakeStoreProductDtoToProduct(fakeStoreProductDtos);
    }

    @Override
    public List<Product> getAllProducts() {
       String url="https://fakestoreapi.com/products";
       RestTemplate restTemplate=new RestTemplate();
        // Get array of products from fake store
       FakeStoreProductDtos[] fakeStoreProductDtos=restTemplate.getForObject(url,FakeStoreProductDtos[].class);
       List<Product> products=new ArrayList<>();
       for(FakeStoreProductDtos dto: fakeStoreProductDtos){
           products.add(convertFakeStoreProductDtoToProduct(dto));

       }
       return products;
    }

    @Override
    public Product createNewProduct(Product product) {
                RestTemplate restTemplate=new RestTemplate();
                String url="https://fakestoreapi.com/products";
                FakeStoreProductDtos fakaestoreproductdto=restTemplate.postForObject(url,product,FakeStoreProductDtos.class);
                return convertFakeStoreProductDtoToProduct(fakaestoreproductdto);
    }

    @Override
    public void deleteProductById(long id) {
           String url="https://fakestoreapi.com/products/"+id;
           RestTemplate restTemplate=new RestTemplate();
           restTemplate.delete(url);
    }

//    @Override
//    public Product updateProduct(long id, Product product) {
//        RestTemplate resttemplate=new RestTemplate();
//        String url="https://fakestoreapi.com/products/"+id;
//        FakeStoreProductDtos fro=new FakeStoreProductDtos();
//        fro.setTitle(product.getTitle());
//        fro.setDescription(product.getDescription());
//        fro.setPrice(product.getPrice());
//        fro.setCategory(product.getCategory());
//        fro.setPrice(product.getPrice());
//
//
//        resttemplate.put(url,fro);
//        FakeStoreProductDtos fakeStoreProductDtos=resttemplate.getForObject(url, FakeStoreProductDtos.class);
//        return convertFakeStoreProductDtoToProduct(fakeStoreProductDtos);
//    }

    private Product convertFakeStoreProductDtoToProduct(FakeStoreProductDtos dto){
        Product product=new Product();
        product.setId(dto.getId());
        product.setTitle(dto.getTitle());
        product.setPrice(dto.getPrice());
        product.setDescription(dto.getDescription());
        product.setCategory(dto.getCategory());
        product.setImage(dto.getImage());
        return product;
    }
}
