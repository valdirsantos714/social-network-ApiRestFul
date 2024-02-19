package com.valdirsantos714.ApiRestFulRedeSocial.repositories;

import com.valdirsantos714.ApiRestFulRedeSocial.entities.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentRepository extends JpaRepository<Comment, String> {
}
