![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=openjdk&logoColor=white)
![Static Badge](https://img.shields.io/badge/Generics-blue?style=for-the-badge)
![Static Badge](https://img.shields.io/badge/Factory-a12a46?style=for-the-badge)


# 🚗 Car Inventory Manager

Este projeto é um sistema de gerenciamento de inventário automotivo desenvolvido em Java. O objetivo foi criar uma estrutura capaz de separar veículos por categorias (SUVs, Luxo, etc.) garantindo que erros de tipo sejam pegos antes mesmo do programa rodar.

## 🛠️ Tecnologias e Conceitos Aplicados

- **Java 17+:** Um contato com funcionalidades modernas como ***Streams*** e ***Lambdas***.
- **Generics (Bounded Types):** Implementação de filtros rigorosos **(<T extends Car & ISUV>)** que impedem erros em tempo de execução.
- **Factory Method Pattern:** Centralização da criação de objetos via Reflection, garantindo um código desacoplado.
- **Encapsulamento:** Gerenciamento de listas privadas dentro de uma classe "Hub" (Garage).

## 🚀 Diferenciais do Projeto

O sistema utiliza **Generics** e o padrão de criação **Factory** para tornar a instanciação e o armazenamento de objetos muito mais seguros e organizados que o modelo tradicional.

### 1. Evolução da Instanciação

O projeto demonstra a transição do modelo tradicional para o modelo profissional:
- ❌ Antigo: Jeep jeepCompass = new Jeep(); (Alto acoplamento).
- ✅ Moderno: car.factory(Jeep.class); (Abstração total via Factory).

````java
Jeep jeepCompass = new Jeep();
Jeep jeepRenegade = car.factory(Jeep.class);
````


### 2. Segurança Camada a Camada

A estrutura possui dois "filtros de segurança" que impedem o uso indevido do sistema:
- Filtro de Fábrica: A FactoryCar utiliza Generics para barrar a fabricação de qualquer objeto que não herde da classe abstrata Car (ex: impede a fabricação de Motos em uma fábrica de Carros).

````Java
Jeep jeepRenegade = car.factory(Jeep.class); ✅
Ferrari ferrariSpider = car.factory(Ferrari.class); ✅

ARCHMotorcycle krgt = car.factory(ARCHMotorcycle.class); ❌
````
<br>

- Filtro de Categoria (Interface Marcadora): A Classe **Garage** utiliza Intersection Types para garantir que apenas carros que implementam ISUV entrem na lista de SUVs, e apenas IDelux entrem na lista de luxo.

`````java
package com.fabioperettig.factory;

import java.util.ArrayList;
import java.util.List;

public class Garage{

    private List<Car> GarageSUV = new ArrayList<>();
    private List<Car> GarageDelux = new ArrayList<>();

    public<T extends Car & ISUV> void addSUV(T car) {
        GarageSUV.add(car);
        System.out.println("New SUV: " + car.getClass().getSimpleName());
    }

    public<T extends Car & IDelux> void addDelux(T car) {
        GarageDelux.add(car);
        System.out.println("New Deluxe: " + car.getClass().getSimpleName());
    }

    public void getSUV(){
        GarageSUV.stream()
                .map(car -> car.getClass().getSimpleName())
                .forEach(System.out::println);  ;
    }
}
`````


### 3. Factory Pattern ⚙️
A classe FactoryCar não apenas centraliza a criação dos objetos, mas utiliza a API de Reflection do Java para instanciar classes de forma dinâmica e segura. Impedindo que o erros se propaguem de forma silenciosa e garantindo que a fábrica recuse terminantemente qualquer classe que não herde de 'Car'.

````java
package com.fabioperettig.factory;

public class FactoryCar {

    public <T extends Car> T factory(Class<T> cars){
        try{
            return cars.getDeclaredConstructor().newInstance();
        } catch (Exception e) {
            throw new RuntimeException("Error in car manufacturing.", e);
        }
    }

}

````



## 💻 Exemplo de Código (Main)

````java
// Criando a infraestrutura
FactoryCar factory = new FactoryCar();
Garage myGarage = new Garage();

// Instanciação moderna e segura
Jeep renegade = factory.factory(Jeep.class);
Ferrari spider = factory.factory(Ferrari.class);

// O sistema barra tipos incompatíveis em tempo de compilação!
myGarage.addSUV(spider); //ERRO: Ferrari não é SUV!

myGarage.addSUV(renegade);
myGarage.addDelux(spider);

// Listagem inteligente com Streams
myGarage.getSUV(); 
````
<br>

------

#### @Author Fabio Peretti Guimarães | Projeto EBAC – Generics | Abril de 2026