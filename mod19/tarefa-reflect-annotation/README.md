![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=openjdk&logoColor=white)
![Annotation Definition](https://img.shields.io/badge/Annotation-gold?style=for-the-badge)
![Annotation Definition](https://img.shields.io/badge/Reflection-432874?style=for-the-badge)

# 🧬​ Projeto: Leitura de Annotation Customizada em Java

Este projeto foca na leitura de uma ***Annotation*** Customizada [**(desenvolvida na tarefa do módulo 18)**](https://github.com/fabioperettig/tarefas-ebac-Fabio-Peretti/tree/main/mod18/tarefa-annotation) através de ***Reflections***.


## 🚀 Leitura da anotação na Classe Main

O programa verifica se a classe possui anotações e obtém seus metatados através dos métodos **tabela.nome()** e **tabela.id()** via Reflection.

````java
public class Main {
    public static void main(String[] args) {

        if(User.class.isAnnotationPresent(Tabela.class)){

            Tabela tabela = User.class.getAnnotation(Tabela.class);
            System.out.printf("nome: %s | id: %d.", tabela.nome(), tabela.id());
        }
    }
}
````

## 💡 Conclusão
Reflections possibilitam inspecionar Classes, verificar por anotações presentes e permitir acesso aos dados em tempo de execução.

---
<br>

**Fabio peretti Guimarães | tarefa Ebac mod 19 | ABR 2026**