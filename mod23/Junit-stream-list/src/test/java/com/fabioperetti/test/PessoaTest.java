package com.fabioperetti.test;

import com.fabioperettig.user.Pessoa;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PessoaTest {

    List<Pessoa> testList = new Pessoa().pessoaList();

    List<String> femList = testList.stream()
            .filter(sexo -> sexo.getSexo().equals("Feminino"))
            .map(pessoa -> pessoa.getNome() + " | " + pessoa.getSexo())
            .toList();


    @Test
    public void test(){
        femList.forEach(pessoa -> {
            Assertions.assertTrue(pessoa.contains("Feminino"));
        });
    }

}
