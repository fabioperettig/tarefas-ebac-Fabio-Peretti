package com.fabioperettig.testProject.service;

public class ErroClientException extends IllegalArgumentException{
    public ErroClientException(String message){
        super(message);
    };
}
