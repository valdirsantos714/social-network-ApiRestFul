package com.valdirsantos714.ApiRestFulRedeSocial.dtos;

import jakarta.validation.constraints.NotBlank;

public record UserDto (@NotBlank String name, @NotBlank String email){
}
