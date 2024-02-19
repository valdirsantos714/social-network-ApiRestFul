package com.valdirsantos714.ApiRestFulRedeSocial.repositories;

import com.valdirsantos714.ApiRestFulRedeSocial.entities.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends JpaRepository<Post, String> {
}
