package com.wivety.controller;
import com.wivety.models.Product;
import com.wivety.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/product")
@CrossOrigin(origins = "http://localhost:3000")
public class ProductController {

    private final ProductService productService;
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping
    private ResponseEntity<Product> save(@RequestBody Product product){
        Product createdProduct = productService.create(product);
        try {
            return ResponseEntity.created(new URI("/api/product"+createdProduct.getId())).body(createdProduct);

        }catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @GetMapping
    private ResponseEntity<List<Product>> getAll (){
        return ResponseEntity.ok(productService.getAllProducts());
    }

    @DeleteMapping
    private ResponseEntity<Void> delete (@RequestBody Product product){
        productService.delete(product);
        return ResponseEntity.ok().build();
    }

    @GetMapping (value = "{id}")
    private ResponseEntity<Optional<Product>> listProducts (@PathVariable("id") String id){
        return ResponseEntity.ok(productService.findById(id));
    }
}
