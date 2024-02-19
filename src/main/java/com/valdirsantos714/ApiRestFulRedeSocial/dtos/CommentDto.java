package com.valdirsantos714.ApiRestFulRedeSocial.dtos;

import jakarta.validation.constraints.NotBlank;

public record CommentDto(@NotBlank String text) {
}
