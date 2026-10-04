package com.fabioperettig.CLI;

import picocli.CommandLine.Command;

@Command(
        name = "PicocliBlockbuster",
        description = "CLI para gerenciamento de filmes",
        mixinStandardHelpOptions = true,
        version = "PicocliBlockbuster CLI 1.0",
        subcommands = {
                CadastarFilmeCommand.class
        }
)
public class PicocliCommnand  implements Runnable {
    /**
     * When an object implementing interface {@code Runnable} is used
     * to create a thread, starting the thread causes the object's
     * {@code run} method to be called in that separately executing
     * thread.
     * <p>
     * The general contract of the method {@code run} is that it may
     * take any action whatsoever.
     *
     * @see Thread#run()
     */
    @Override
    public void run() {
        System.out.println("Bem-vindo ao Blockbuster CLI!");
    }
}
