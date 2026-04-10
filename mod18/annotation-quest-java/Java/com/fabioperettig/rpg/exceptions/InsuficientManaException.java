package com.fabioperettig.rpg.exceptions;

/**
 * A custom exception is a Class ending and extending
 * "Exception", with a super-made constructor;
 */
public class InsuficientManaException extends Exception{

    public InsuficientManaException(String message){
        super(message);
    }

}
