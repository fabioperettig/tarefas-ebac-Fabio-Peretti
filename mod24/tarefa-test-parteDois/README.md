![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=openjdk&logoColor=white)
![Test](https://img.shields.io/badge/Tests-leafgreen?style=for-the-badge)
![JUnit5](https://img.shields.io/badge/JUnit5-f5f5f5?style=for-the-badge&logo=junit5&logoColor=dc524a)

# ☕ Tarefa Estudo de Tests JUnit - Parte II

**Esta é a segunda parte dos estudos de 'Testes' de código, com o uso do framework JUnit. Para este estudo, foi utilizado feito um projeto DAO com métodos CRUD (Create, Read, Update e Delete).**

**[Clique aqui para ver a Parte I do estudo](https://github.com/fabioperettig/tarefas-ebac-Fabio-Peretti/tree/main/mod23/tarefa-test-parteUm).**

>**Nota:** atualmente, a versão mais recomendada do framweork JUnit é a versão 5, diferente do módulo do curso. Então alguns, operadores estarão diferentes, apesar de alcançarem o mesmo objetivo.

````XML
<!-- Source: https://mvnrepository.com/artifact/org.junit.jupiter/junit-jupiter-api -->
<dependency>
    <groupId>org.junit.jupiter</groupId>
    <artifactId>junit-jupiter-api</artifactId>
    <version>5.13.4</version>
    <scope>test</scope>
</dependency>
````
<br>

## Models
<details>
<summary>Clique aqui para expandir</summary>

<br>

**O projeto conta com duas entidades, ambas com seus métodos, testes e Classes Service.**

````java
public class Cliente {

    private int id;
    private String nome;
    private String email;

    public Cliente(String nome, String email) {
        this.nome = nome;
        this.email = email;
    }

    ///getters e setters
    {...}
}
````
````java
public class Contrato {

    private int id;
    private int clienteID;
    private boolean ativo;

    public Contrato(int clienteID, boolean ativo) {
        this.clienteID = clienteID;
        this.ativo = ativo;
    }

    ///getters e setters
    {...}
}
````
</details>

## 📋 Regras

Para este estudo, **submeti também duas mecânicas extras**, que incrementariam o desafio e deixariam o estudo mais próximo de um projeto real:
<br>

- Ambas as entidades devem ser receber **um ID automático no momento da instanciação**. Isso evita a instanciação com IDs duplicados e retira tal responsabilidade do usuário.

- A entidade Contrato **só será instanciada se for atrelada a um ID de Cliente já existente no banco de dados**. Evitando assim a instanciação de contratos 'soltos' e fazendo a entidade exigir métodos particulares.


<br>

## ⚙️ Classe DAO

As classes DAO das entidades possuem todos métodos CRUD, com implementação de Interface, streams e métodos lambdas aprendidos nos módulos mais recentes. Além disso, possuem o ***statement*** de incremento automático no **setId()** dentro do método create().

````java
public class ClienteDAO implements ICliente{

    private final List<Cliente> clienteList = new ArrayList<>();
    private int contadorID = 1;

    /// CRUD methods
    
    @Override
    public void create(Cliente cliente) {
        cliente.setId(contadorID++);
        clienteList.add(cliente);
    }

    @Override
    public Optional<Cliente> read(int id) {
        return clienteList.stream()
                .filter(c -> c.getId() == id)
                .findFirst();
    }

    @Override
    public void update(Cliente clienteUpdate) {
        read(clienteUpdate.getId())
                .ifPresent(c -> {
                    c.setNome(clienteUpdate.getNome());
                    c.setEmail(clienteUpdate.getEmail());
                });
    }

    @Override
    public void delete(int id) {
        clienteList.removeIf(c -> c.getId() == id);
    }

    @Override
    public List<Cliente> findAll() {
        return new ArrayList<>(clienteList);
    }
}
````

<details><summary><b>Classe DAO Contrato</b></summary>

````java
public class ContratoDAO implements IContrato{

    private final List<Contrato> contratoList = new ArrayList<>();
    private int contadorID = 100;

    /// CRUD methods
    
    @Override
    public void create(Contrato contrato) {
        contrato.setId(contadorID++);
        contratoList.add(contrato);
    }

    @Override
    public Optional<Contrato> read(int id) {
        return contratoList.stream()
                .filter(contrato -> contrato.getId() == id)
                .findFirst();
    }

    @Override
    public void update(Contrato contratoUpdate) {
        read(contratoUpdate.getId())
                .ifPresent(contrato -> {
                    contrato.setClienteID(contratoUpdate.getClienteID());
                    contrato.setAtivo(contratoUpdate.isAtivo());
                });
    }

    @Override
    public void delete(int id) {
        contratoList.removeIf(contrato -> contrato.getId()==id);
    }
}
````
</details>

## 🛂 Services

As classes Service determinam as regras de negócio, funcionando como o controle de qualidade do sistema (com destaque nos métodos de criação), com as seguintes funcionalidades:


- Injeção de Dependência: estando acoplado à interface, a classe Service se torna independente de uma classe DAO concreta, deixando o código mais funcional e permitindo que o sistema evolua para vários tipos de persistência, seja JSON (ideal para estados de aplicação ou configurações) ou SQL (para grandes volumes e buscas complexas) sem impactar as regras de negócio.

- Instruções de validação, garantindo que nenhum cliente seja processado com nome nulo ou em branco.

- Validação de criação de Contrato, verificando se o ID de Cliente existe, podendo retornar uma exception customizada ***(ErrorClientException extends IllegalArgumentException)*** caso não encontre a ID do Cliente.

<details><summary><b>Classe ClienteService</b></summary>

````java
public class ClienteService {

    private ICliente iCliente;

    public ClienteService(ICliente iCliente) {
        this.iCliente = iCliente;
    }

    public void createService(Cliente cliente){

        if (cliente.getNome() == null || cliente.getNome().isBlank()){
            throw new IllegalArgumentException("O cliente precisa de um nome");
        }

        iCliente.create(cliente);
    }

    public Cliente readService(int id){
        return iCliente.read(id)
                .orElseThrow(() -> new IllegalArgumentException("Cliente não encontrado."));
    }

    public void updateService(int id, String novoNome, String novoEmail){
        Cliente cliente = readService(id);

        cliente.setNome(novoNome);
        cliente.setEmail(novoEmail);

        iCliente.update(cliente);
    }

    public void deleteService(int id){
        readService(id);
        iCliente.delete(id);
    }

    public List<Cliente> listarCLientes(){
        return iCliente.findAll();
    }
}
````
</details>

<details><summary><b>Classe ContratoService</b></summary>

````java
public class ContratoService {

    private IContrato iContrato;
    private ICliente iCliente;

    public ContratoService(IContrato iContrato, ICliente iCliente) {
        this.iContrato = iContrato;
        this.iCliente = iCliente;
    }

    public void createService(Contrato contrato) throws ErrorClientException {

        iCliente.read(contrato.getClienteID())
                .orElseThrow(() -> new ErrorClientException("Cliente não existe."));

        iContrato.create(contrato);
    }

    public Contrato readService(int id){
        return iContrato.read(id)
                .orElseThrow(() -> new IllegalArgumentException("Contrato não encontrado."));
    }

    public void updateService(int id, boolean ativo){
        Contrato contrato = readService(id);
        ativo = !contrato.isAtivo();
        contrato.setAtivo(ativo);
    }

    public void deleteService(int id){
        readService(id);
        iContrato.delete(id);
    }
}
````

</details>

## ✅ Tests

Para garantir que todos os métodos funcionem corretamente, **foram implementadas diferentes Classes de Testes**, sendo cada uma focada em comportamentos que exigem atenção exclusiva. Sendo assim, optei por não testar métodos do Service que são apenas "passagens" (chamam o DAO sem lógica extra) para evitar repetições desnecessárias e focar o esforço onde a lógica realmente reside. Além disso, o testes foram feitos sob Classes ***'Mock'*** que continham retorno de console (println).

- Testes Service: verifica se as validação de dados funcionam corretamente, testando inclusive **cenários de erro**, garantindo que o sistema lance as exceções ***IllegalArgumentException*** esperadas.

````java
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestServiceClient {

    private ICliente iCliente;

    @BeforeEach
    void setup(){
        iCliente = new ClienteMockDAO();
    }

    @Test
    public void testeServiceCREATEClienteSucesso(){
        Cliente cliente = new Cliente("sucesso", "@mail");
        ClienteService service = new ClienteService(iCliente);

        service.createService(cliente);
        Assertions.assertEquals("sucesso", cliente.getNome());
    }

    @Test
    public void testeServiceCREATEClienteNomeInvalido(){

        ClienteService service = new ClienteService(iCliente);
        Cliente cliente = new Cliente(null, "@mail");

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            service.createService(cliente);
        });
    }

    @Test
    public void testeServiceUPDATECliente(){
        ClienteService service = new ClienteService(iCliente);
        Cliente cliente = new Cliente("testeOLD", "email@mail.com");
        iCliente.create(cliente);

        service.updateService(1,"testeNovoNome", cliente.getEmail());
        Assertions.assertEquals("testeNovoNome", cliente.getNome());
    }
}
````

<details><summary><b>Classe Teste Service Contrato</b></summary>

````java
public class TestServiceContrato {

    private IContrato iContrato;
    private ICliente iCliente;

    @BeforeEach
    void setup(){
        iContrato = new ContratoMockDAO();
        iCliente = new ClienteMockDAO();
    }

    @Test
    public void testeServiceCREATEContratoSucesso() throws ErrorClientException {
        Cliente cliente = new Cliente("name", "@mail");
        Cliente cliente2 = new Cliente("name", "@mail");
        ContratoService service = new ContratoService(iContrato, iCliente);
        ClienteService serviceCLIENTE = new ClienteService(iCliente);

        serviceCLIENTE.createService(cliente);
        serviceCLIENTE.createService(cliente2);

        Contrato contrato = new Contrato(2,false);

        service.createService(contrato);
        Assertions.assertEquals(100,contrato.getId());
    }

    @Test
    public void testeServiceERROsemCLiente() throws ErrorClientException {
        ContratoService service = new ContratoService(iContrato, iCliente);
        Contrato contrato = new Contrato(1, true);

        Assertions.assertThrows(ErrorClientException.class, () -> {
            service.createService(contrato);
        });
    }

    @Test
    public void testeServiceUPDATEContrato(){
        ContratoService service = new ContratoService(iContrato,iCliente);
        ClienteService clService = new ClienteService(iCliente);

        Cliente clienteTeste = new Cliente("teste", "@mail");
        clService.createService(clienteTeste);

        Contrato contrato = new Contrato(1,true);
        service.createService(contrato);

        service.updateService(100,false);

        Assertions.assertFalse(contrato.isAtivo());
    }
}
````
</details>

<br>

- Testes DAO (Persistência): testando o auto incremento de IDs, se os dados estão sendo realmente salvos, lidos, atualizados e deletados. **Cenário onde os métodos já passaram pela validação da Classe Service.**

````java
public class TestDAOClient {

    private ICliente iCliente;

    @BeforeEach
    void setup(){
        iCliente = new ClienteMockDAO();
    }

    @Test
    public void testeDAOCREATEClienteIDAutomatico(){
        Cliente cliente1 = new Cliente("cliente1", "cliente1@mail");
        Cliente cliente2 = new Cliente("cliente2", "cliente1@mail");
        Cliente cliente3 = new Cliente("cliente3", "cliente1@mail");

        iCliente.create(cliente1);
        iCliente.create(cliente2);

        Assertions.assertEquals(2, cliente2.getId());
    }

    @Test
    public void testeDAOREADCliente() {
        Cliente cliente = new Cliente("testeREAD", "email@mail.com");
        iCliente.create(cliente);

        Optional<Cliente> resultado = iCliente.read(cliente.getId());

        Assertions.assertTrue(resultado.isPresent());
        Assertions.assertEquals("testeREAD", resultado.get().getNome());
    }

    @Test
    public void testeDELETEDAOCliente(){
        Cliente cliente = new Cliente("NomeLista1", "email1@mail.com");
        Cliente clienteDEL = new Cliente("NomeLista2", "email2@mail.com");
        iCliente.create(cliente);
        iCliente.create(clienteDEL);

        iCliente.delete(clienteDEL.getId());
        Optional<Cliente> deletar = iCliente.read(clienteDEL.getId());

        Assertions.assertTrue(deletar.isEmpty());
    }

    @Test
    public void testeDAOListarCliente(){

        Cliente cliente1 = new Cliente("Cliente1", "cliente1@mail");
        Cliente cliente2 = new Cliente("Cliente2", "cliente1@mail");

        iCliente.create(cliente1);
        iCliente.create(cliente2);

        List<Cliente> result = iCliente.findAll();

        Assertions.assertEquals(2, result.size());
    }

    @Test
    public void testeDAOListaInicialVazia(){
        List<Cliente> listaVazia = iCliente.findAll();

        Assertions.assertTrue(listaVazia.isEmpty());
    }
}
````

<details><summary><b>Classe Teste DAO Contrato</b></summary>

````java
public class TestDAOContrato {

    private IContrato iContrato;
    private ICliente iCliente;

    @BeforeEach
    void detup(){
        iContrato = new ContratoMockDAO();
        iCliente = new ClienteMockDAO();
    }

    @Test
    public void testeDAOCREATEContratoIDAutomatico(){
        Cliente clienteTest = new Cliente("Teste", "contrato@mail.com");
        iCliente.create(clienteTest);

        Contrato contrato = new Contrato(1,true);
        iContrato.create(contrato);

        Optional<Contrato> resultado = iContrato.read(contrato.getId());

        Assertions.assertTrue(resultado.isPresent());
    }

    @Test
    public void testeDELETEDAOContrato(){
        Contrato contratoDEL = new Contrato(1,false);
        iContrato.create(contratoDEL);

        iContrato.delete(contratoDEL.getId());
        Optional<Contrato> delete = iContrato.read(contratoDEL.getId());

        Assertions.assertTrue(delete.isEmpty());
    }
}
````
</details>

<br>

## 📚 Suite

Para deixar o cenário de testes mais otimizado, diminuindo o esforço de testar classe por classe e, ainda assim, garantir que todos os testes foram validados, foi utilizada o componente *junit-platform-suite* que permite agrupar e executar múltiplos testes de forma organizada.

````java
import org.junit.platform.suite.api.Suite;
import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.SuiteDisplayName;

@Suite
@SuiteDisplayName("Test Suite")
@SelectClasses({
        TestDAOClient.class,
        TestDAOContrato.class,
        TestServiceClient.class,
        TestServiceContrato.class
})

public class TestsSuite {

}
````

## 🏁 Conclusão

Este projeto CRUD foi desenvolvido com foco total em separação de responsabilidades e manutenibilidade. Ao isolar a lógica de negócios no Service 🛂 e a gestão de dados no DAO ⚙️, criou-se uma arquitetura flexível onde as persistências podem ser trocadas com o mínimo de impacto no resto da arquitetura.

Além disso, a cobertura de testes focada em comportamentos reais garante que o sistema não apenas funcione, mas seja resistente a falhas e dados inválidos. Este projeto serviu para consolidar conceitos fundamentais como Injeção de Dependência, Inversão de Controle e o uso estratégico de Interfaces, preparando a base para evoluções futuras como integração com bancos de dados reais ou APIs REST.

**Estrutura final do projeto:**

````
Main
├── controller
|	├── ClienteController
|	└── ContratoController
|
├── dao
|	├── ClienteDAO
|	├── ClienteMockDAO
|	├── ContratoDAO
|	├── ContratoMockDAO
|	├── ICliente
|	└── IContrato
|
├── model
|	├── Cliente
|	└── Contrato
|
├── service
|	├── ClienteService
|	├── ContratoService
|	└── ErrorClientException
|
Main.class


Test
├── TestDAOClient
├── TestDAOContrato
├── TestServiceClient
└── TestServiceContrato
````

----

### Fabio peretti Guimarães | tarefa Ebac mod 24 | MAI 2026
