package com.valdirsantos714.ApiRestFulRedeSocial.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.valdirsantos714.ApiRestFulRedeSocial.dtos.UserDto;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "users")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column(nullable = false, length = 100)
    private String name;

    @Column(nullable = false, length = 70)
    private String email;

    @JsonIgnore
    @OneToMany(mappedBy = "author")
    private List<Post> posts = new ArrayList<>();

    @JsonIgnore
    @OneToMany(mappedBy = "author")
    private List<Comment> comments = new ArrayList<>();

    public User(UserDto userDto) {
        this.name = userDto.name();
        this.email = userDto.email();
    }
}
