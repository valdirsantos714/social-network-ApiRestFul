package com.valdirsantos714.ApiRestFulRedeSocial.services;

import com.valdirsantos714.ApiRestFulRedeSocial.dtos.CommentDto;
import com.valdirsantos714.ApiRestFulRedeSocial.entities.Comment;
import com.valdirsantos714.ApiRestFulRedeSocial.repositories.CommentRepository;
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
public class CommentService {

    @Autowired
    private CommentRepository commentRepository;

    public List<Comment> findAll() {
        List<Comment> list = commentRepository.findAll();
        return list;
    }

    public Comment findById(String id) {

        Optional<Comment> comment = commentRepository.findById(id);
        return comment.orElseThrow(() -> new ResourceNotFound(id));

    }

    @Transactional
    public Comment save(CommentDto commentDto) {
        Comment comment = new Comment(commentDto);
        return comment;
    }

    @Transactional
    public void delete(String id) {
        try {
            commentRepository.deleteById(id);

        } catch (EmptyResultDataAccessException e) {
            throw new ResourceNotFound(id);

        } catch (DataIntegrityViolationException e) {
            throw new DataBaseException(e.getMessage());
        }
    }

    public Comment update(String id, CommentDto commentDto) {
        try {
            Comment comment = commentRepository.getReferenceById(id);
            updateData(comment, commentDto);

            return commentRepository.save(comment);

        } catch (EntityNotFoundException e) {
            throw new ResourceNotFound(id);
        }
    }

    private void updateData(Comment outdatedComment, CommentDto updatedComment) {
        outdatedComment.setText(updatedComment.text());
    }
}
