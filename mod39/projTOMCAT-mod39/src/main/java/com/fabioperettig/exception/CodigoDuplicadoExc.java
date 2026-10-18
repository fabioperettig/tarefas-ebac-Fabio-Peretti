package com.fabioperettig.exception;

public class CodigoDuplicadoExc extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public CodigoDuplicadoExc(Long codigo, Throwable causa) {
        super(String.format("Código %d já está cadastro. Escolha um código diferente.", codigo), causa);
    }
}
