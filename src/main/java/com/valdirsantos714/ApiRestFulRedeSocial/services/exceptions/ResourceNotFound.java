package com.valdirsantos714.ApiRestFulRedeSocial.services.exceptions;

public class ResourceNotFound extends RuntimeException{

    public ResourceNotFound(Object id) {
        super("Resource not found. Id " + id);
    }
}
