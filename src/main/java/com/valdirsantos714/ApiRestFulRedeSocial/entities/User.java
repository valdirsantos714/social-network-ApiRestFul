package com.valdirsantos714.ApiRestFulRedeSocial.entities;

import com.valdirsantos714.ApiRestFulRedeSocial.dtos.UserDto;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "users")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false, length = 100)
    private String name;

    @Column(nullable = false, length = 70)
    private String email;

    public User(UserDto userDto) {
        this.name = userDto.name();
        this.email = userDto.email();
    }
}
