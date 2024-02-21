package com.valdirsantos714.ApiRestFulRedeSocial.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.valdirsantos714.ApiRestFulRedeSocial.dtos.PostDto;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "posts")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = "id")
public class Post implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID) //Tipo de estratégia de gerar ids, com o chaves aleatórias do tipo string
    private String id;

    private Instant date;

    @Column(nullable = false, length = 100)
    private String title;

    @Column(nullable = false)
    private String body;

    @ManyToOne
    @JoinColumn(name = "id_user")
    private User author;

    @JsonIgnore //Precisa colocar em arraylist para não dar loop infinito
    @OneToMany(mappedBy = "post")
    private List<Comment> comments = new ArrayList<>();

    public Post(PostDto postDto) {
        this.title = postDto.title();
        this.body = postDto.body();
    }
}
