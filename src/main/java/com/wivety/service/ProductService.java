package com.wivety.service;
import com.wivety.models.Product;
import com.wivety.models.ProductResponse;
import com.wivety.repository.ProductRepository;
import com.wivety.utils.Utils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Product create (Product product) {
        return productRepository.save(product);
    }

    public List<Product> getAllProducts (){
        return productRepository.findAll();

    }

    public void delete (Product product) {
        productRepository.delete(product);
    }

    public Optional<Product> findById (String id) {
        return productRepository.getByProductById(id);
    }
}
