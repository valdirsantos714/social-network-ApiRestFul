package com.valdirsantos714.ApiRestFulRedeSocial.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.valdirsantos714.ApiRestFulRedeSocial.dtos.CommentDto;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.time.Instant;

@Entity
@Table(name = "comments")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = "id")
public class Comment implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column(nullable = false)
    private String text;

    private Instant date;

    @ManyToOne
    @JoinColumn(name = "id_post")
    private Post post;

    @ManyToOne
    @JoinColumn(name = "id_user")
    private User author;

    public Comment(CommentDto commentDto) {

        this.text = commentDto.text();
    }
}
