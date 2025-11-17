import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class main {

    static Scanner input = new Scanner(System.in);
    static String nome;
    static String genero;


    static List<Object> inputList = new ArrayList<>();
    static List<Object> listaM = new ArrayList<>();
    static List<Object> listaF = new ArrayList<>();

    public static void main(String[] args) {

        System.out.println("\n----- Exercício Ebac – Módulo12 -----\n");
        System.out.println("Adicione nome e sexo, separando o grupo por vírgula.");
        String inputInfos = input.nextLine();

        String[] pessoas = inputInfos.split(",");

        for (String pessoaLocal : pessoas) {

            pessoaLocal = pessoaLocal.trim();

            String[] partes = pessoaLocal.split(" ");
            genero = partes[partes.length-1].toUpperCase();
            nome = pessoaLocal.substring(0,pessoaLocal.lastIndexOf(" ")).trim();

            if (genero.equals("M")) {
                listaM.add(nome);
            } else if (genero.equals("F")) {
                listaF.add(nome);
            } else {
                System.out.println("Gênero inválido em: " + pessoaLocal);
            }

        }

        System.out.println("\n----- Imprimindo listas -----");
        System.out.println("Masculino: " + listaM);
        System.out.println("Feminino:   " + listaF);
        System.out.println("----------------------");

    }

}