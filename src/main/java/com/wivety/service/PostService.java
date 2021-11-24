package com.wivety.service;

import com.wivety.models.Post;
import com.wivety.models.Product;
import com.wivety.repository.PostRepository;
import com.wivety.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostService {
    private final PostRepository postRepository;
    private final ProductRepository productRepository;

    public PostService(
            PostRepository postRepository,
            ProductRepository productRepository) {
        this.postRepository = postRepository;
        this.productRepository = productRepository;

    }

    public Post create(Post post) {
        return postRepository.save(post);
    }

    public List<Post> getAllPost() {
        return postRepository.findAll();
    }

    public void delete(Post post) {
        postRepository.delete(post);
    }

    public List<Post> postsFromProduct(String id) throws Exception {
        Optional<Product> product = productRepository.getByProductById(id);
        if (!product.isPresent())
            throw new Exception("Product does not exist");
        return postRepository.getByProduct(product.get().getId());
    }

}
