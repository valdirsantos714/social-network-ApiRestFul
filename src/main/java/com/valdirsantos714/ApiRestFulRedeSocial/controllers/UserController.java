package com.valdirsantos714.ApiRestFulRedeSocial.controllers;

import com.valdirsantos714.ApiRestFulRedeSocial.dtos.UserDto;
import com.valdirsantos714.ApiRestFulRedeSocial.entities.Comment;
import com.valdirsantos714.ApiRestFulRedeSocial.entities.Post;
import com.valdirsantos714.ApiRestFulRedeSocial.entities.User;
import com.valdirsantos714.ApiRestFulRedeSocial.services.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity<List<User>> findAllUsers() {
        List<User> list = userService.findAll();

        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<User> findByIdUser(@PathVariable String id) {
        User user = userService.findById(id);

        return ResponseEntity.ok().body(user);
    }


    //===========PEGA OS POSTS DE UM USUÁRIO POR ID
    @GetMapping(value = "/{id}/posts")
    public ResponseEntity<List<Post>> findPosts(@PathVariable String id) {
        User user = userService.findById(id);

        return ResponseEntity.ok().body(user.getPosts());
    }

    @GetMapping(value = "/{id}/comments")
    public ResponseEntity<List<Comment>> findComments(@PathVariable String id) {
        User user = userService.findById(id);

        return ResponseEntity.ok().body(user.getComments());

    } // PEGA OS COMENTÁRIOS DE UM USUÁRIO DE ACORDO COM O ID DA PESSOA

    @PostMapping
    public ResponseEntity<User> saveUser(@RequestBody @Valid UserDto userDto) {

        return ResponseEntity.status(HttpStatus.CREATED).body(userService.save(userDto));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable String id) {
        userService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<User> updateUser(@PathVariable String id, @RequestBody @Valid UserDto userDto) {
        User user = new User(userDto);
        user = userService.update(id, userDto);

        return ResponseEntity.ok().body(user);
    }

}
