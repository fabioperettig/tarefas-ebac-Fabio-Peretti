package com.fabioperetti.estudomap;

import java.util.Map;
import java.util.TreeMap;


/**
 * Garante ordenação key
 */
public class treeMap {

    public static void main(String[] args) {
        Map<Double,String> listaMap = new TreeMap<>();
        listaMap.put(1.0,"kaka");
        listaMap.put(1.5,"keke");
        listaMap.put(2.0,"kiki");
        listaMap.put(2.5,"koko");
        listaMap.put(3.0,"kuku");
        listaMap.put(3.5,"kaokao");
        listaMap.remove(1.5,"keke");

        System.out.println(listaMap);
    }

}
