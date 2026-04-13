package com.fabioperettig.reflectionCrud.exception;

public class InvalidDataException extends Exception{

    public InvalidDataException(String msg){
        this(msg, null);
    }

    InvalidDataException(String msg, Throwable e){
        super(msg, e);
    }
}
