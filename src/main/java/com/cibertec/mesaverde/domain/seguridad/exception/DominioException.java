package com.cibertec.mesaverde.domain.seguridad.exception;

public class DominioException extends RuntimeException{
    public DominioException(String message) {
        super(message);
    }

    public DominioException(String message, Throwable cause) {
        super(message, cause);
    }
}
