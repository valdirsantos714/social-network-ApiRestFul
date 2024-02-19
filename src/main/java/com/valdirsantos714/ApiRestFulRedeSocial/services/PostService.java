package com.valdirsantos714.ApiRestFulRedeSocial.services;

import com.valdirsantos714.ApiRestFulRedeSocial.dtos.PostDto;
import com.valdirsantos714.ApiRestFulRedeSocial.entities.Post;
import com.valdirsantos714.ApiRestFulRedeSocial.repositories.PostRepository;
import com.valdirsantos714.ApiRestFulRedeSocial.services.exceptions.DataBaseException;
import com.valdirsantos714.ApiRestFulRedeSocial.services.exceptions.ResourceNotFound;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;

    @Transactional
    public Post save(PostDto postDto) {
        var post = new Post(postDto);

        return postRepository.save(post);
    }

    @Transactional
    public void delete(String id) {
        try {
            postRepository.deleteById(id);

        } catch (EmptyResultDataAccessException e) {
            throw new ResourceNotFound(id);

        } catch (DataIntegrityViolationException e) {
            throw new DataBaseException(e.getMessage());
        }
    }

    public List<Post> findAll() {
        List<Post> list = postRepository.findAll();

        return list;
    }

    public Post findById(String id) {
        Optional<Post> post = postRepository.findById(id);

        return post.orElseThrow(() -> new ResourceNotFound(id));
    }

    public Post update(String id, PostDto postDto) {
        try {
            Post post = postRepository.getReferenceById(id);

            updateData(post, postDto);

            return postRepository.save(post);

        } catch (EntityNotFoundException e) {
            throw new ResourceNotFound(id);
        }
    }

    private void updateData(Post outdatedPost, PostDto updatedPost) {
        outdatedPost.setTitle(updatedPost.title());
        outdatedPost.setBody(updatedPost.body());
    }
}
