package com.fabioperettig;

import com.fabioperettig.CLI.PicocliCommnand;
import picocli.CommandLine;

public class Main {
    public static void main(String[] args) {

        ///Exemplo args para PicoCLI
        //cadastrar --codigo FILM001 --nome "Alien" --ano 1979 --tempo 117 --nota 8.5

        int exitCode = new CommandLine(new PicocliCommnand()).execute(args);
        System.out.println(exitCode);
    }
}
