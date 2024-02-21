package com.valdirsantos714.ApiRestFulRedeSocial.controllers;

import com.valdirsantos714.ApiRestFulRedeSocial.dtos.CommentDto;
import com.valdirsantos714.ApiRestFulRedeSocial.entities.Comment;
import com.valdirsantos714.ApiRestFulRedeSocial.services.CommentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;
import java.util.List;

@RestController
@RequestMapping("comments")
public class CommentController {

    @Autowired
    private CommentService commentService;

    @GetMapping
    public ResponseEntity<List<Comment>> findAllComments() {
        List<Comment> comments = commentService.findAll();
        return ResponseEntity.ok().body(comments);
    }


    @GetMapping(value = "/{id}")
    public ResponseEntity<Comment> findById(@PathVariable String id) {
        Comment comment = commentService.findById(id);
        return ResponseEntity.ok().body(comment);
    }

    @PostMapping
    public ResponseEntity<Comment> saveComment(@RequestBody @Valid CommentDto commentDto) {
        Comment comment = new Comment(commentDto);
        comment.setDate(Instant.now()); //Dessa forma ele cria um comment a partir de um comment dto validado e quando salvar no banco de dados ele vai com a hora que vc salvou
        
        return ResponseEntity.status(HttpStatus.CREATED).body(commentService.save(comment));
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Comment> updateComment(@PathVariable String id, @RequestBody @Valid CommentDto commentDto) {
        Comment comment = new Comment(commentDto);
        comment = commentService.update(id, commentDto);

        return ResponseEntity.ok().body(comment);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deleteComment(@PathVariable String id) {
        commentService.delete(id);

        return ResponseEntity.noContent().build();
    }
}
