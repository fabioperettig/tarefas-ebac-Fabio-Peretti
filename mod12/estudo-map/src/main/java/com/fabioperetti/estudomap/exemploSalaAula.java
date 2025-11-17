package com.fabioperetti.estudomap;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.Random;

//library
import com.fabioperettig.escola.Aluno;
import com.fabioperettig.lista.StringNomes;
import com.fabioperettig.lista.ListObjects;

/**
 * Classe de exemplo que demonstra o uso de library particular, criada
 * para manipular listas de objetos utilizando generics (<T>) e uma lista
 * fixa de nomes.
 * <p>
 * Esta classe simula a criação de uma sala de aula contendo alunos
 * gerados aleatoriamente, utilizando:
 * <ul>
 *   <li>{@link com.fabioperettig.lista.StringNomes} para sortear nomes;</li>
 *   <li>{@link com.fabioperettig.lista.ListObjects} para armazenar os objetos Aluno;</li>
 *   <li>{@link java.util.Random} para gerar valores aleatórios.</li>
 * </ul>
 * A classe também demonstra como armazenar listas tipadas dentro de um
 * {@code Map<Integer, ListObjects<Aluno>>}, representando salas de aula.
 */
public class exemploSalaAula {

    //import de library
    static StringNomes nomes = StringNomes.listaNomeDefault();
    static ListObjects<Aluno> listaAlunosSala1 = new ListObjects<>();

    static Random rnd = new Random();

    public static void main(String[] args) {

        criarAlunos();
        Map<Integer, ListObjects<Aluno>> sala1 = new HashMap<>();
        sala1.put(1, listaAlunosSala1);
        System.out.println(sala1.get(1).mostrarListaObj());


    }

    /**
     * Cria objetos {@link Aluno} com dados aleatórios e os adiciona
     * à lista {@code listaAlunosSala1}, que utiliza a estrutura genérica da library.
     * <p>
     * Para cada aluno são gerados:
     * <ul>
     *   <li>Nome aleatório retirado da lista fixa da library;</li>
     *   <li>Idade entre 25 e 35 anos;</li>
     *   <li>Nota entre 1.25 e 9.25;</li>
     *   <li>Status de aprovação baseado na nota (>= 7 aprovado);</li>
     *   <li>Curso fixo: "Java".</li>
     * </ul>
     * Os alunos são adicionados na lista {@code ListObjects<Aluno>} que
     * pertence à library-domain.
     */
    public static void criarAlunos(){
        for (int i=0; i<5; i++){
            List<String> listaNomeTemp = nomes.mostrarLista();
            String nomeSort = listaNomeTemp.get(rnd.nextInt(listaNomeTemp.size()));

            int idadeSort = rnd.nextInt(11) + 25;
            double notaSort = rnd.nextDouble(8) + 1.25;
            boolean statusAluno;

            if (notaSort >=7){
                statusAluno = true;
            } else {statusAluno = false;}

            Aluno aluno = new Aluno(nomeSort, idadeSort, "Java", notaSort, statusAluno);
            listaAlunosSala1.addObject(aluno);
        }
    }



}
