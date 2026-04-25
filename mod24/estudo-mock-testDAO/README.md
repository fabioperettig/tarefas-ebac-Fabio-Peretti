![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=openjdk&logoColor=white)
![Test](https://img.shields.io/badge/Tests-leafgreen?style=for-the-badge)
![JUnit5](https://img.shields.io/badge/JUnit5-f5f5f5?style=for-the-badge&logo=junit5&logoColor=dc524a)

# ☕ Estudo Teste DAO

Este estudo foi feito para ressaltar a importância da área de **Testes** nos projetos desenvolvidos no padrão Maven, junto com a dependência do pacote [**JUnit**](https://junit.org/). O projeto mostra também um pouco sobre Injeção de Dependência, técnica que torna o código muito mais dinâmico e prático em projetos complexos como **Data Access Objects**.

## 📚 Estrutura DAO

O projeto possui um padrão DAO (*Data Access Objects*), projeto de baixo acoplamento, com camadas idependentes de visualização e/ou controle em relação à camada de dados.

````text
mock-testDAO
├── main
│   ├── controller
│   │   └── ClienteController
│   │
│   ├── dao
│   │   ├── IClienteDAO         #Interface
│   │   ├── ClienteDAO          #Classe concreta
│   │   └── ClienteMockDAO      #Classe 'Mock' para teste
│   │
│   └── service
│       └── ClienteService
│
└── test
    └── ServiceTest             #Classe para teste
````

## Cliente Banco x Cliente Mock

Um exemplo de uma Classe diretamente ligada ao banco de dados (**ClenteDao.java**) que tornaria complexo ou até inviável testar as regras de negócio do projeto, além de correr o risco de expor dados sensíveis do banco. Como solução, é criada uma *Classe Mock* que possui os mesmos métodos, mas com retornos nulos ou específicos para teste.

```` java
public class ClienteDAO implements IClienteDAO{

    List<Cliente> listaCliente = new ArrayList<>();

    @Override
    public void salvar(Cliente cliente) {
        
        /// Exception proposital simulando acesso negado ao banco de dados.
        throw new IllegalArgumentException("Precisa de acesso ao banco de dados.");
    }

    @Override
    public List<Cliente> trazerLista() {
        return new ArrayList<>(listaCliente);
    }
}

-----

public class ClienteMockDAO implements IClienteDAO{
    @Override
    public void salvar(Cliente cliente) {

        /// Retorno personalizado para teste
        System.out.println("Teste executado com sucesso.");
    }

    @Override
    public List<Cliente> trazerLista() {
        System.out.println("Teste executado com sucesso.");
        return List.of();
    }
}
````
>É importante ressaltar a boa prática das classes Concretas e Mocks implementarem os métodos vindos de uma Interface, para garantir que os métodos sejam igualmente inderessados pela camada de Negócios.

## Testes na prática

Sendo o projeto de baixo acomplamento e arquitetado com Injeção de Dependência, podemos testar tanto os métodos da Classe Controller quanto os métodos da Classe Service conectada à Interface que contém os métodos. 

````java
public class ServiceTest {
    private IClienteDAO iClienteDAO = new ClienteMockDAO();

    ClienteService service = new ClienteService(iClienteDAO);
    ClienteController controller = new ClienteController(service);

    @Test()
    public void cadastroTest(){
        controller.novoCadastro("ClienteTeste");
    }
}
````
Assim, o retorno do método dependerá de qual classe foi atribuída a intanciação da Interface. A Classe ClienteDAO apresentará a ***Exception*** de acesso negado, enquanto a Classe MockDAO retornará um Println personalizado.

````bash
EXEMPLO CLASSE ClienteDAO

/Library/Java/JavaVirtualMachines/jdk-17.jdk/Contents/Home/bin/java ...

java.lang.IllegalArgumentException: Precisa de acesso ao banco de dados.

Process finished with exit code 0

------------------------------

EXEMPLO CLASSE ClienteMockDAO

/Library/Java/JavaVirtualMachines/jdk-17.jdk/Contents/Home/bin/java ...

"Teste executado com sucesso."

Process finished with exit code 0
````
