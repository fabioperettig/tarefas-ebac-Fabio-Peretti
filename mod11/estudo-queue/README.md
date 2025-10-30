# 📚 Estudos sobre Filas em Java

Este repositório reúne uma série de estudos sobre **estruturas de filas (`Queue`) e suas variações** em Java, demonstrando suas aplicações, diferenças e comportamento prático. Desenvolvidos como parte do processo de aprendizado de **coleções (`Collections Framework`)** e estruturas de dados.

## 🔗 Sumário
- [Queue](#queue)
- [BlockingQueue](#blockingqueue)
- [PriorityQueue](#priorityqueue)
- [Deque](#deque-double-ended-queue)
- [Stack](#stack-pilha)

## Queue

Em Java, uma **fila (Queue)** é uma estrutura de dados que organiza elementos de forma **sequencial**, seguindo a lógica **FIFO (First In, First Out)**.

- Adicionando o elemento através do método **offer()**;
- Evidenciando o elemento atráves do método **peek()**;
- Removendo o elemento através do método **poll()**.

````
static Queue<String> filaPacientes = new LinkedList<>();

    filaPacientes.offer("João");
    filaPacientes.offer("Maria");
    filaPacientes.offer("Carlos");
    filaPacientes.offer("Joaquim");
    filaPacientes.offer("Marcia");
    filaPacientes.offer("Wilson");

    //funciona tanto com println quanto printf
    System.out.printf("%nFila incial: %s%n",filaPacientes);
    [João, Maria, Carlos, Joaquim, Marcia, Wilson]

    System.out.println("------------------------");

    System.out.printf("Atendendo o paciente: %s.%n",filaPacientes.peek());
    [João]

    filaPacientes.poll();
    [João]

    System.out.printf("%nFila incial: %s%n",filaPacientes);
    [Maria, Carlos, Joaquim, Marcia, Wilson]
````
- Além de remover, o método poll() também consegue mostrar o elemento antes de removê-lo da fila.

## BlockingQueue

A BlockingQueue pertence ao pacote java.util.concurrent e permite definir uma capacidade máxima.
Quando cheia, as novas inserções podem bloquear ou simplesmente retornar false.

Classe usada: ArrayBlockingQueue

````
static ArrayBlockingQueue<String> primeirosClientes = new ArrayBlockingQueue<>(5);

    primeirosClientes.offer("João");
    primeirosClientes.offer("Maria");
    primeirosClientes.offer("Carlos");
    primeirosClientes.offer("Joaquim");
    primeirosClientes.offer("Marcia");

    System.out.printf("%nFila cheia: %s.%n",primeirosClientes);
    [João, Maria, Carlos, Joaquim, Marcia]

    [Wilson] não adicionado;
````

Também é possível criar **métodos condicionais** que retornam a possibilidade de adicionar ou não um elemento.

- adicionarMembro(){...} – Adiciona ou retorna aviso;

- adicionarMembroADMIN(){...} – Adiciona ou retorna aviso com a possibilidade de substituição de elemento.

````
    public static void adicionarMembro(){
        System.out.println("\nInsira o nome do novo membro: ");
        String newMembro = input.nextLine();

        if (primeirosClientes.remainingCapacity()==0){
            System.out.println("A fila já está cheia.");
        } else {
            primeirosClientes.offer(newMembro);
        }
    }

    public static void adicionarMembroADMIN(){
        System.out.println("\nInsira o nome do novo membro: ");
        String newMembro = input.nextLine();

        if (primeirosClientes.remainingCapacity()==0){
            System.out.println("A fila já está cheia. Gostaria de remover um elemento da fila?");
            System.out.println("1-Sim | 2-Não");
            int escolha = input.nextInt();
            input.nextLine();

            if (escolha == 1) {
                primeirosClientes.poll();
                primeirosClientes.offer(newMembro);
                System.out.println("Lista atualizada: " + primeirosClientes);
            } else {
                System.out.println("Ação cancelada.");
                System.out.println(primeirosClientes);
            }

        } else {
            primeirosClientes.offer(newMembro);
        }
    }
````
## PriorityQueue

Adicionando elementos à uma fila através do método offer(). Uma lista prioritária serve para mostrar os elementos em ordem especificas:

- String – afbatética;
- Integer/Double – crescente.

**É importante lembrar que a prioridade se aplica sempre ao <u>primeiro elemento</u> da fila, mas não signifca necessariamente que o restante da fila se manterá ordenado.**

````
static PriorityQueue<String> pacientesPrioridade = new PriorityQueue<>();

    pacientesPrioridade.offer("João");
    pacientesPrioridade.offer("Maria");
    pacientesPrioridade.offer("Carlos");
    pacientesPrioridade.offer("Joaquim");
    pacientesPrioridade.offer("Marcia");
    pacientesPrioridade.offer("Wilson");

    System.out.printf("%nLista por prioridade: %s%n",pacientesPrioridade);
    [Carlos, Joaquim, João, Maria, Marcia, Wilson]
````


Para garantir que a fila imprima a fila exatamente ordenada, é necessário seguir alguns passos:

- Adicionar a Queue a um método While;
- Usar como parâmetro a negação da lista vazia;
- Imprimir e retirar o el. prioritário através do .poll().

A repetição do método **poll()** forçará a Queue a sempre buscar o elemento prioritário da fila antes de executar o processo, garantindo que a fila sempre será impressa em ordem.

**Como <u>não há um método 'isFull()' em Queues</u>, é necessário negar o fato de que a lista está vazia e usá-la como parâmetro condicional:**

**!pacientesPrioridade.isEmpty() == 'pacientesPrioridade.isFull()'**

````
public static void prioridadeOrdenada(){

    pacientesPrioridade.offer("João");
    pacientesPrioridade.offer("Maria");
    pacientesPrioridade.offer("Carlos");
    pacientesPrioridade.offer("Joaquim");
    pacientesPrioridade.offer("Marcia");
    pacientesPrioridade.offer("Wilson");

    while (!pacientesPrioridade.isEmpty()) {
        System.out.println("Fila atual: "+pacientesPrioridade);
        System.out.println("Removendo: "+pacientesPrioridade.poll());
    }

    System.out.println("-----------------");

    while (!temperaturaPrioridade.isEmpty()){
        System.out.println(temperaturaPrioridade.poll());
    }

    [Carlos]
    [Joaquim]
    [João]
    [Marcia]
    [Maria]
    [Wilson]
}
````
## Deque (Double-Ended Queue)

Deque é uma estrutura/fila de Duas Pontas. Além de possuir os métodos offer() e poll(), também é possível determinar <u>por qual lado da fila</u> o elemento entrará:

- offerFirst() -> Add o elemento ao início da fila;
- offerLast() -> Add o elemento ao final da fila;
- pollFirst() -> Remove o primeiro elemento;
- pollLast() -> Remove o último elemento.

Obs: o metodo [...]Last() acaba sendo realmente útil quando que quer remover um elemento da fila, pois a adição segue a ordem de instância.

````
static Deque<String> filaDupla = new ArrayDeque<>();

    filaDupla.offer("Fabio");
    filaDupla.offer("Carlos");
    filaDupla.offerLast("Maria"); //não fará diferença;
    filaDupla.offer("Joaquim");
    filaDupla.offerFirst("José");
    [José, Fabio, Carlos, Maria, Joaquim]

    System.out.println("Removendo primeiro: " + filaDupla.pollFirst());
    [Fabio, Carlos, Maria, Joaquim]
    
    System.out.println("Removendo último: " + filaDupla.pollLast());
    [Fabio, Carlos, Maria]
````

## Stack (Pilha)
Uma **pilha (Deque stack)** é uma estrutura de dados que organiza elementos de forma **sequencial**, porém, seguindo a lógica **LIFO (Last In, First Out)**.

Por seguir uma lógica diferente, uma Deque Stack exige seus próprios métodos de adicionar e remover elementos:

- Adicionando o elemento à pilha através do método **push()**;
- Evidenciando o elemento da pilha atráves do método **peek()**;
- Removendo o elemento da pilha através do método **pop()**.

````
static public void mecanicaFila(){
    queueFila.offer("Primeiro");
    queueFila.offer("Segundo");
    queueFila.offer("Terceiro");
    queueFila.offer("Quarto");

    System.out.println("Fila atual: " + queueFila);
    [Primeiro, Segundo, Terceiro, Quarto]


    System.out.println("Removendo o primeiro da fila: " + queueFila.poll());
    [Primeiro]

    System.out.println("Fila atual: " + queueFila);
    [Segundo, Terceiro, Quarto]
}

static public void mecanicaPilha(){
    stackPilha.push("Primeiro");
    stackPilha.push("Segundo");
    stackPilha.push("Terceiro");
    stackPilha.push("Quarto");

    System.out.println("Pilha atual: " + stackPilha);
    [Quarto, Terceiro, Segundo, Primeiro]

    System.out.println("Removendo o primeiro da pilha: " + stackPilha.pop());
    [Quarto]
    
    System.out.println("Pilha atual: " + stackPilha);
    [Terceiro, Segundo, Primeiro]
}
````

## ✨ Conclusão

**Durante este estudo, foram explorados:**
- O comportamento das diferentes filas do Java;
- As diferenças entre estruturas FIFO, LIFO e Prioritárias;
- Implementações com LinkedList, ArrayDeque, ArrayBlockingQueue e PriorityQueue;
- Métodos como offer, poll, peek, push, pop, addFirst, addLast, entre outros.

<p>Autor: Fabio Peretti Guimarães<br>
📘 Módulo de Estruturas de Dados – EBAC (Java Collections Framework)</p>