package com.valdirsantos714.ApiRestFulRedeSocial.controllers;

import com.valdirsantos714.ApiRestFulRedeSocial.dtos.PostDto;
import com.valdirsantos714.ApiRestFulRedeSocial.entities.Post;
import com.valdirsantos714.ApiRestFulRedeSocial.services.PostService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;
import java.util.List;

@RestController
@RequestMapping("/posts")
public class PostController {

    @Autowired
    private PostService postService;

    @GetMapping
    public ResponseEntity<List<Post>> findAllPosts() {
        List<Post> list = postService.findAll();

        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Post> findByIdPost(@PathVariable String id) {
        Post post = postService.findById(id);

        return ResponseEntity.ok().body(post);
    }

    @PostMapping
    public ResponseEntity<Post> savePost(@RequestBody @Valid PostDto postDto) {
        Post post = new Post(postDto);
        post.setDate(Instant.now());

        return ResponseEntity.status(HttpStatus.CREATED).body(postService.save(post));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deletePost(@PathVariable String id) {
        postService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Post> updatePost(@PathVariable String id, @RequestBody @Valid PostDto postDto) {
        Post post = new Post(postDto);
        post = postService.update(id, postDto);

        return ResponseEntity.ok().body(post);
    }

}
