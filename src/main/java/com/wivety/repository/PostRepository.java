package com.wivety.repository;

import com.wivety.models.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Long> {
    @Query(
            value = "SELECT * FROM post p WHERE p.product = :product",
            nativeQuery = true
    )
    List<Post> getByProduct(@Param("product") String product);
}
