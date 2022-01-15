package org.corgi.template.exception;

public class NotFoundException extends RuntimeException {
    public NotFoundException() {}

    public NotFoundException(String message)
    {
        super(message);
    }
}
