![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)
![Static Badge](https://img.shields.io/badge/microservices-brightgreen?style=for-the-badge&logo=moleculer&logoColor=white)
![Curso EBAC](https://img.shields.io/badge/Curso--EBAC-f2f0ef?style=for-the-badge)

# 📚☕️ Tarefa módulo 41 - Introdução Microsserviços

Este é um estudo introdutório sobre `Microsserviços`,

## 🧩 O que são Microsserviços?

Os Microsserviços são uma arquitetura de software onde uma aplicação é construída pequenas unidades, conhecidas como
`serviços`. Ao contrário de uma aplicação Monolítica, a aplicação em Microsservicos funciona de forma praticamente
independente. Cada serviço possui seu próprio processo, sendo possível publicá-los e escalá-los separadamente.

## ⚖️ Vantagens e Desvantagens

Adotar este tipo de arquitetura pode trazer benefícios ao projeto, pois possuem vantagens em relação a um projeto
monolítico. 

| Aspecto        | Monolítico                                                                            | Microsserviços                                                               |
|----------------|---------------------------------------------------------------------------------------|------------------------------------------------------------------------------|
| Independência  | Todos os módulos fazem parte da mesma aplicação                                       | Cada serviço funciona como uma aplicação independente                        |
| Manutenção     | Uma alteração em um domnínio pode acarretar em alterações em outras partes do projeto | Cada serviço pode ser atualizado livremente sem afetar o todo do projeto     |
| Escalabilidade | O projeto cresce de forma total                                                       | É possível escalar apenas os serviços mais utilizados do projeto             |
| Deploy         | Exige que o projeto todo passe por deploy                                             | Deploy aplicado apenas ao serviço atualizado que foi atualizado              |
| Isolamento     | A queda de um serviço derruba a aplicação inteira                                     | A queda ocorre de forma isolada e não compromete as outras partes do projeto |

>**Exemplo prático:** a área de Estoque está recebendo milhares de consultas por minuto, enquanto Cliente recebe pouquíssimas.
Com microsserviços, é possível aumentar APENAS a capacidade do Estoque, sem precisar aumentar também a capacidade do Cliente.

-----

Por outro lado, este tipo de arquitetura impõe dificuldades e pode tornar o código desnecessariamente complexo.

| Aspecto      | Monolítico                                             | Microsserviços                                               |
|--------------|--------------------------------------------------------|--------------------------------------------------------------|
| Complexidade | Uma única aplicação para desenvolver e administrar     | Mais configuração, monitoramento e gerenciamento             |
| Comunicação  | Direta, por métodos do próprio Java                    | HTTP, APIs e mensageria                                      |
| Desempenho   | Mais rápido com chamadas internas                      | Chamadas de rede que ocasionam latência                      |
| Testes       | Permtie Suites para testar todos os métodos de uma vez | Testes de integração podem exigir vários serviços funcionando|

>**Exemplo prático:** Para registrar uma Venda em um projeto  monolítico, a classe VendaService poderia consultar
> diretamente `ClienteRepository`, `ProdutoRepository` e `EstoqueRepository`. Em microsserviços, o VendaService depende
> de diferentes requisições e ainda deverá saber lidar com a possibilidade de alguma delas estar indisponível.

Por isso, não existe um modelo absoluto. O padrão de arquitetura mais eficaz dependerá do tipo de projeto a ser
construído. Projetos monolíticos priorizam a simplicidade, Microsserviços priorizam a autonomia.

## 🕸️ Separação e Comunicação

A construção deste tipo de projeto geralmente são separadas em `domínios` que compoem a aplicação (cliente, produtos,
venda, etc.), carregando consigo suas próprias camadas de responsabilidade. Ou seja, o Microsserviços de um domínio
"Cliente" carregará também terá sua camada Service, Repository e até seu próprio database.

| Microsserviço   | Domínio | Services       | Sistema DAO       | Database   |
|-----------------|---------|----------------|-------------------|------------|
| cliente-service | Cliente | ClienteService | ClienteRepository | Cliente_DB |
| produto-service | Produto | ProdutoService | ProdutoRepository | Produto_DB |
| venda-service   | Venda   | VendaService   | VendaRepository   | Venda_DB   |
| estoque-service | Estoque | EstoqueService | EstoqueRepository | Estoque_DB |

Em um cenário Monolítico, é fácil entender como estas Entidades se comunicaria pois o projeto todo está implementado
em um mesmo ambiente. Mas, em uma estrutura de Microsserviços, como o Microserviços `Venda` teria
acesso ao `Cliente` e `Produto`?

Para este tipo de arquitetura, é essencial ter um `Padrão de Comunicação`. Existem diferentes tipo de padrões, com
diferentes estruturas e finalidades.

<details><summary>Padrões de Comunicação</summary>

| Padrão         | Finalidade                                    | Comunicação  | Acomplamento | Tecnologia                         |
|----------------|-----------------------------------------------|--------------|--------------|------------------------------------|
| API REST       | Comunicação direta entre sistemas             | Síncrona     | Forte        | HTTP, JSON, Spring Boot, Express   |
| Message Broker | Envio e recebimento de mensagens              | Assíncrona   | Fraco        | RabbitMQ, Apache Kafka, Amazon SQS |
| API GATEWAY    | Ponto único de entrada para todas as resquets | Direcionada  | Centralizado | Kong, AWS API Gateway, Zuul, Nginx |

</details>

> No contexto deste curso, será utilizado o padrão API REST na criação de um projeto DAO numa arquitetura de Microsserviços.

## 📬 API REST

Continuando o exemplo com o projeto de `Vendas`, o microsserviço `venda-service` não precisa ter nenhum atributo do
tipo `Cliente`, nem estar escalado no mesmo ambiente que `cliente-service`. Ele pode apenas fazer uma resquisição HTTP
para chegar até a informação desejada. No caso, se Vendas realizar uma consulta através da ID do Cliente, poderá fazer
a requisição `"GET http://cliente-service:8080/clientes/31"`.

| Trecho          | Finalidade                         |
|-----------------|------------------------------------|
| http://         | Protocolo de comunicação           |
| cliente-service | Nome do servidor/serviço           |
| 8080	            | Porta na qual ele recebe conexões  |
| /clientes       | Caminho do recurso (endpoint)      |
| /31             | Identificador do cliente procurado |

Assim, após o `cliente-service` receber o request, poderá responder à requisição, geralmente em formato JSON.

```bash
{
    "id": 31,
    "nome": "Fabio",
    "email": "fabio@mail.com"
}
```

Assim, a Classe Venda poderá ter apenas um atributo do tipo Long e armazenar o valor de `"id:" 31`, vindo do JSON, e
usá-la em um método simples `venda.setClienteId(15L);`. O `venda-service` continua sem nenhum acomplamento ou relação
com `cliente-service`, apenas salvou o valor vindo do JSON.

```java
@Entity
public class Venda {

    @Id
    private Long id;

    private Long clienteId;
}
```

Concluíndo: estes foram apenas os tópicos introdutórios sobre `Microsserviços`. Sua arquitetura ainda se aprofunda
muito mais, dependendo do tipo de projeto, do tipo de database, do tipo de requisição e do envolvimento de DOCKER.

---

**Fabio Peretti Guimarães | tarefa EBAC mod 41 | OUT 2026**