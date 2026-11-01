![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)
![Static Badge](https://img.shields.io/badge/microservices-brightgreen?style=for-the-badge&logo=moleculer&logoColor=white)
![Curso EBAC](https://img.shields.io/badge/Curso--EBAC-f2f0ef?style=for-the-badge)

# 📚☕️ Tarefa módulo 42 - Vendas Online em Arquitetura de Microsserviços

Este é meu primeiro projeto em arquitetura de Microsserviços (em desevolvimento...) 🚧

|Package|Função|
|-|-|
|ConfigServer|em desenvolv.|
|ClienteService|em desenvolv.|
|ProdutoService|em desenvolv.|


> **Lembretes de aprendizado:** <br>
> Um objeto gerenciado pelo Spring é chamado de `bean`; <br>
> @RefreshScope pertence ao Spring Cloud; <br>

| Annotation             | Framework           | Descrição                                                                            |
|------------------------|---------------------|--------------------------------------------------------------------------------------|
| @SpringBootApplication | Spring Boot         | Configuração e inicialização da aplicação                                            |
| @RestController        | Spring MVC          | Marca um componente que atende requisições HTTP e devolve dados no corpo da resposta |
| @Service               | Spring              | Identifica um componente usado para regras de negócio                                |
| @Document, @Id         | Spring Data         | Descrevem o mapeamento dos objetos para o MongoDB                                    |
| @RefreshScope          | Spring Cloud        | Permite que um bean seja recriado quando ocorre uma atualização de configuração      |
| @EnableConfigServer    | Spring Cloud Config | Habilita um servidor de configurações                                                |
| @Schema                | Swagger/OpenAPI     | Descreve dados na documentação da API                                                |