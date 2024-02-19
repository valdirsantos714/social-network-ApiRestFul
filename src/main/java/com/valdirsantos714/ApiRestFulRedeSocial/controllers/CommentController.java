package com.valdirsantos714.ApiRestFulRedeSocial.controllers;

import com.valdirsantos714.ApiRestFulRedeSocial.dtos.CommentDto;
import com.valdirsantos714.ApiRestFulRedeSocial.entities.Comment;
import com.valdirsantos714.ApiRestFulRedeSocial.services.CommentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    /*
    @GetMapping(value = "/{user}/{senha}")

    public ResponseEntity<String> amostraTela(@PathVariable String user, @PathVariable Sring senha) {
         if (user == "valdir" && senha == 1223) {
            return "/telaPrincipal";
        }
     */


    @GetMapping(value = "/{id}")
    public ResponseEntity<Comment> findById(@PathVariable String id) {
        Comment comment = commentService.findById(id);
        return ResponseEntity.ok().body(comment);
    }

    @PostMapping
    public ResponseEntity<Comment> saveComment(@RequestBody @Valid CommentDto commentDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(commentService.save(commentDto));
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
