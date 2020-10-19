package com.dots.web.exception;

public class CategoryIdMismatchException extends RuntimeException {

    public CategoryIdMismatchException() {
        super();
    }

    public CategoryIdMismatchException(final String message, final Throwable cause){
        super(message, cause);
    }

    public CategoryIdMismatchException(final String message){
        super(message);
    }

    public CategoryIdMismatchException(final Throwable cause){
        super(cause);
    }
}

