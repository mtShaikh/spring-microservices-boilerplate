package com.taha.boilerplate.example.exception;

public class AbstractUserException extends RuntimeException {
    public AbstractUserException(){ super(); }
    public AbstractUserException(String message){ super(message); }
}
