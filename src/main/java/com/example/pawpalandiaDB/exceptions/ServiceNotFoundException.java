package com.example.pawpalandiaDB.exceptions;

public class ServiceNotFoundException extends RuntimeException {
    
    private static final long serialVersionUID = 1L;

    public ServiceNotFoundException(Long id) {
        super("No se encontró el servicio con la orden " + id);
    }
}
