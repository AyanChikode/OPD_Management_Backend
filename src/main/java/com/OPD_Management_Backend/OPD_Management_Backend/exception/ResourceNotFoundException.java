package com.OPD_Management_Backend.OPD_Management_Backend.exception;


public class ResourceNotFoundException extends RuntimeException {

    public ResourceNotFoundException(String message) {
        super(message);
    }
}