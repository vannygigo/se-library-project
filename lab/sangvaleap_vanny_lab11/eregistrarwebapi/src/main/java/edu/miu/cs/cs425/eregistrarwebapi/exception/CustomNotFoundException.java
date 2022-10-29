package edu.miu.cs.cs425.eregistrarwebapi.exception;

public class CustomNotFoundException extends Exception {
    public CustomNotFoundException(String errorMessage) {
        super(errorMessage);
    }
}
