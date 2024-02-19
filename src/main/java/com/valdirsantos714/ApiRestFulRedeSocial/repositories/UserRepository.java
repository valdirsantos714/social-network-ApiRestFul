package com.valdirsantos714.ApiRestFulRedeSocial.repositories;

import com.valdirsantos714.ApiRestFulRedeSocial.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
