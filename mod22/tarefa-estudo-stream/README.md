![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=openjdk&logoColor=white)
![Streams](https://img.shields.io/badge/Streams-0062eb?style=for-the-badge)

# ☕ Tarefa Estudo de Streams

**Este projeto é um pequeno exemplo de manipulação de dados de uma Lista através do uso de Streams.**

Este tipo de manipulação é muito util quando é necessário manipular dados (lista ou variável única) em um fluxo de operações que podem ser descartadas logo após a manipulação, *gerindo melhor os espaços alocados em seu projeto*.

## 👤 Classe Principal

Para este estudo, foi criada uma Classe 'Pessoa' com atributos, construtores, getters e uma lista já previamente implementada.

````java
public class Pessoa {

    private String nome;
    private String sexo;

    /// construtor vazio
    public Pessoa(){};

    /// construtor default
    public Pessoa(String nome, String sexo) {
        this.nome = nome;
        this.sexo = sexo;
    }

    public String getNome() {
        return nome;
    }

    public String getSexo() {
        return sexo;
    }

    public List<Pessoa> pessoaList(){
        Pessoa p1 = new Pessoa("Fabio","Masculino");
        Pessoa p2 = new Pessoa("Miguel","Masculino");
        Pessoa p3 = new Pessoa("Helena","Feminino");
        Pessoa p4 = new Pessoa("Arthur","Masculino");
        Pessoa p5 = new Pessoa("Alice","Feminino");
        Pessoa p6 = new Pessoa("Laura","Feminino");
        [...]

        return List.of(p1,p2,p3,p4,p5,p6...);
    }


    @Override
    public String toString() {
        return "Nome: " + nome + " – Sexo: " + sexo;
    }
}

````
A partir daqui já é possível notar a seguinte particularidade:

- **Construtores (Vazio e Default) ->** O construtor *'default'* permite já a instanciação de Objetos em uma própria lista interna da Classe, enquanto um construtor vazio permite acesso à essa mesma lista sem a necessidade de uma *instanciação explicita* da Classe Pessoa, prática conhecida como *instanciação anônima*.

<br>

## 🚀 Uso de Streams

Na Classe Principal, foi implementada duas manipulações **stream()** com retorno de pessoas ***(.map)***, filtradas pelo sexo feminino ***(.filter)*** e exibidas em um método ***forEach()***. Enquanto a primeira forma retorna uma 'Stream pura', a segunda forma retorna **como uma nova lista**.

````java
/// Stream puro com 'print manual' no map()
Stream<String> streamFiltro = pessoaList.stream()
        .filter(p -> p.getSexo().equals("Feminino"))
        .map(p -> p.getNome() + " – " + p.getSexo());

streamFiltro.forEach(System.out::println);
````
````java
/// Stream toList() com uma nova lista e map() que acessa o método toString()
List<Pessoa> listaFeminina = pessoaList.stream()
        .filter(pessoa -> pessoa.getSexo().equals("Feminino"))
        .map(pessoa -> new Pessoa(pessoa.getNome(), pessoa.getSexo()))
        .toList();

listaFeminina.forEach(System.out::println);
````
<br>

## 🔍 Retorno Stream vs Lista

Por mais que ambas as formas possuam os mesmos passos de operadores e a mesma possibilidade de exibição. A verdadeira diferença entre elas está na pretenção do que fazer com os dados retornados.

- **Stream ->** É um objeto de uso único. Uma vez que a operação terminal é executada, a Stream é "fechada" e impossível de ser reutilizada.

- **List ->** É uma estrutura de dados na memória. É possível percorrer *'listaFeminina'* inúmeras vezes, passá-la como parâmetro para outros métodos ou reutilizá-la em qualquer finalidade que ela permanecerá ativa.


### Abaixo uma pequena implementação de *'Try/Catch'* para ver o comportamento do Java perante os dois dados:

````java
/// Erro ao tentar chamar novamente a streamFiltro
try {
    long totalStream = streamFiltro.count();
} catch (IllegalStateException e) {
    throw new StreamException("Ciclo de vida da Stream já encerrada.");
} finally {
    long totalStream = listaFeminina.stream().count();
    System.out.println("Número total: "+totalStream);
}
````
Ao tentar atribuir a **'streamFiltro'** como valor da variável long **'totalStream'**, o java retornará uma *'IllegalStateException'*. Assim, foi implementado um *'finally'* que atribui a **'listaFeminina'** como valor da variável long, passando inclusive por uma nova stream de contagem.

Este pequeno exemplo ajuda a entender como o uso de Streams reduz a verbozidade de um projeto, mas também ajuda a ver qual tipo de retorno a Stream deve executar.

----

### Fabio peretti Guimarães | tarefa Ebac mod 22 | ABR 2026