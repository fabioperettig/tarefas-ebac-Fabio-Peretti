package com.fabioperettig.testProject.service;

public class ErrorClientException extends IllegalArgumentException{
    public ErrorClientException(String message){
        super(message);
    };
}
