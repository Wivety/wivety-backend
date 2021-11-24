package com.wivety.controller;
import com.wivety.models.Post;
import com.wivety.models.PostRequestModel;
import com.wivety.service.PostService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.net.URI;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/post")
@CrossOrigin(origins = "http://localhost:3000")
public class PostController {

    private final PostService postService;
    public PostController(PostService postService) {
        this.postService = postService;
    }

    @PostMapping
    private ResponseEntity<Post> save(@RequestBody PostRequestModel post){
        Post comment = new Post();
        comment.setProfile(post.getProfile());
        comment.setProduct(post.getProduct());
        comment.setMessage(post.getMessage());
        final String uuid = UUID.randomUUID().toString();
        comment.setId(uuid);
        Post createdPost = postService.create(comment);
        try {
            return ResponseEntity.created(new URI("/api/post"+createdPost.getId())).body(createdPost);
        }catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @GetMapping
    private ResponseEntity<List<Post>> getAll (){
        return ResponseEntity.ok(postService.getAllPost());
    }

    @GetMapping("{product}")
    private ResponseEntity<List<Post>> getPostsFromProduct (@PathVariable ("product") String id){
        try {
            return ResponseEntity.ok(postService.postsFromProduct(id));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @DeleteMapping
    private ResponseEntity<Void> delete (@RequestBody Post post){
        postService.delete(post);
        return ResponseEntity.ok().build();
    }

}
