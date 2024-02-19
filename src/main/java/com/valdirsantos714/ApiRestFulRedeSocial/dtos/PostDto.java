package com.valdirsantos714.ApiRestFulRedeSocial.dtos;

import jakarta.validation.constraints.NotBlank;

public record PostDto (@NotBlank String title, @NotBlank String body){
}
