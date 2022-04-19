package com.msdt.springmvc.service;

import java.util.List;

import com.msdt.springmvc.entity.Product;
import com.msdt.springmvc.repository.ProductRepository;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> searchByName(String name) {
        return productRepository.findProductsByName(name);
    }

    public List<Product> getProducts() {
        return productRepository.findAll();
    }
}
