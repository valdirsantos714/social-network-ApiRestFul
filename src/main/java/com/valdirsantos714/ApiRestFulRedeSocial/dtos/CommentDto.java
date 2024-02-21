package com.valdirsantos714.ApiRestFulRedeSocial.dtos;

import jakarta.validation.constraints.NotBlank;

import java.time.Instant;

public record CommentDto(@NotBlank String text) {
}
