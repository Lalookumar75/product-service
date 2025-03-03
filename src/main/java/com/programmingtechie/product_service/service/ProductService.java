package com.programmingtechie.product_service.service;

//import com.programmingtechie.productservice.dto.ProductRequest;
//import com.programmingtechie.productservice.dto.ProductResponse;
//import com.programmingtechie.productservice.model.Product;
//import com.programmingtechie.productservice.repository.ProductRepository;
import com.programmingtechie.product_service.dto.ProductRequest;
import com.programmingtechie.product_service.dto.ProductResponse;
import com.programmingtechie.product_service.model.Product;
import com.programmingtechie.product_service.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductService {

    @Autowired
    private  ProductRepository productRepository;

    public void createProduct(ProductRequest productRequest) {
        Product product = new Product();
        product.setName(productRequest.getName());
        product.setDescription(productRequest.getDescription());
        product.setPrice(productRequest.getPrice());
        productRepository.save(product);

//            Product product = new Product(
//                    null,  // ID will be generated by MongoDB
//                    productRequest.getName(),
//                    productRequest.getDescription(),
//                    productRequest.getPrice()
//            );
//            productRepository.save(product);
//

    }

//    public List<ProductResponse> getAllProducts() {
//    }

    public List<ProductResponse> getAllProducts() {
        List<Product> products = productRepository.findAll(); // Fetch all products from DB

        return products.stream()
                .map(product -> {
                    ProductResponse response = new ProductResponse();
                    response.setId(product.getId());
                    response.setName(product.getName());
                    response.setDescription(product.getDescription());
                    response.setPrice(product.getPrice());
                    return response;
                })
                .toList();
    }


}