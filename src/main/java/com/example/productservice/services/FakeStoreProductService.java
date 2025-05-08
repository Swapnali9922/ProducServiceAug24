package com.example.productservice.services;

import com.example.productservice.dtos.FakeStoreProductDtos;
import com.example.productservice.models.Product;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class FakeStoreProductService implements ProductService {


    @Override
    public Product getProductById(long id) {
        /*
        Take the id from the input and call this endpoint
        https://fakestoreapi.com/products + id
         */
       String url="https://fakestoreapi.com/products/"+id;
        RestTemplate restTemplate=new RestTemplate();
        FakeStoreProductDtos fakeStoreProductDtos=restTemplate.getForObject(url, FakeStoreProductDtos.class);

        return convertFakeStoreProductDtoToProduct(fakeStoreProductDtos);
    }
    private Product convertFakeStoreProductDtoToProduct(FakeStoreProductDtos dto){
        Product product=new Product();
        product.setName(dto.getTitle());
        product.setPrice(dto.getPrice());
        product.setDescription(dto.getDescription());
        product.setCategory(dto.getCategory());
        product.setImage(product.getImage());
        return product;
    }
}
