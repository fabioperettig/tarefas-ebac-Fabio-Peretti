package com.fabioperetti.estudomap;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * O map trabalha com tipo wrapper, de dois parâmetros, permitindo chaves de valores null, mas não existe garantia
 * de se manterem ordenados.
 *
 *
 */
public class main {

    public static void main(String[] args) {
        Map<Integer, String> lista = new HashMap<>();
        lista.put(2,"Aba");
        lista.put(1,"lolo");
        lista.put(10,"huhu");
        lista.put(5,"caco");
        lista.put(7,"tiba");
        lista.put(79,"papa");
        lista.put(23,"bebe");


        System.out.println(lista);

        //método for para imprimir Strings
        for (String local:lista.values()){
            System.out.println(local);
        }

        //método para imprimir Integers
        for (Integer key: lista.keySet()){
            System.out.println(key);
        }

        //método para pegar os dois valores de uma vez atra'ves de FOReach (Set)
        Set<Map.Entry<Integer,String>> listaEntryFor = lista.entrySet();
        for(Map.Entry<Integer,String> e : listaEntryFor){
            System.out.printf("%nChave: %d", e.getKey());
            System.out.printf("%nValor: %s", e.getValue());
        }

        //método para pegar os dois valores de uma vez atra'ves de While (Iterator)
        //diferença entre Iterator e Iterable?
        Iterator<Map.Entry<Integer,String>> listaEntryWhile = lista.entrySet().iterator();
        while (listaEntryWhile.hasNext()) {
            Map.Entry<Integer,String> elementoMap = listaEntryWhile.next();
            System.out.printf("%nChave: %d | Valor: %s", elementoMap.getKey(),elementoMap.getValue());
        }

    }


    //PS: fazer estudo sobre STREAMS
}
