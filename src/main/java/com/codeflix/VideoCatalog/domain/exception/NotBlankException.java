package com.codeflix.VideoCatalog.domain.exception;

public class NotBlankException extends DomainException {
    public NotBlankException() {
        super();
    }

    public NotBlankException(String message) {
        super(message);
    }
}
