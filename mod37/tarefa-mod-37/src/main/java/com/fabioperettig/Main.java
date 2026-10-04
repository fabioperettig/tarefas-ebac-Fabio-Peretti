package com.fabioperettig;

import com.fabioperettig.CLI.PicocliCommnand;
import picocli.CommandLine;

public class Main {
    public static void main(String[] args) {

        int exitCode = new CommandLine(new PicocliCommnand()).execute(args);
        System.out.println(exitCode);
    }
}
