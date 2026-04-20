![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=openjdk&logoColor=white)
![Streams](https://img.shields.io/badge/Streams-0062eb?style=for-the-badge)

# ☕ Java Streams Study

This repository contains practical examples of using the Java Streams API to efficiently explore data collections. Furthermore, **they are closely linked to Lambda Expressions**, as they are used for quick and disposable processes.

## 🚀 Lifecycle

A Stream works like an assembly line, containing specific steps:

- Create: A Stream originates from a List.
>list.stream()

- Intermediate Operations: It's possible to filter, transform, and sort data. However, they cannot finish any process.
>filter(), map(), sort() [...]

- Terminal Operations: it works by closing the Stream and returning final responses.
>forEach, collect, min, max [...]

<br>

## 📚 Operations' Study (part II - [click here for check part I](https://github.com/fabioperettig/tarefas-ebac-Fabio-Peretti/blob/main/mod22/study-stream-comparing/README.md))

3. **sorted & Comparator** -> Defines the elements' order. By default, the order is descending, but it's possible to reverse the order using the operator ***.reversed()***.

````java
List<Monsters> monstersList = new Monsters().monstersList();

/// Order list through the NAME param
Stream sortStream = monstersList.stream()
        .sorted(Comparator.comparing(Monsters::getName))
        .map(Monsters::getName);

sortStream.forEach(System.out::println);

/// Comparing list through the ATK param
String compareStream = monstersList.stream()
        .max(Comparator.comparing(Monsters::getAtk))
        .map(m -> m.getName() + " is the strongest!")
        .orElse("Draw");

System.out.println(compareStream);
````
<br>

4. **distinct()** -> Used to avoid duplicated elements on Stream.

````java
List<Monsters> monstersList = new Monsters().monstersList();

Stream distinctMethod = monstersList.stream()
        .map(monsters -> monsters.getName())
        .distinct();

distinctMethod.forEach(System.out::println);
````
>⚠️ For customized objects, it's necessary to implement 'equals' and 'hashCode' on the Class.

<br>

5. **limit()** -> Used to return a limited number of elements on Stream.

````java
Stream limitMethod = monstersList.stream()
        .sorted(Comparator.comparing(Monsters::getAtk).reversed())
        .limit(4);
limitMethod.forEach(System.out::println);
````
<br>

6. **Skip()** -> Used to select specific intervals on Stream.

````java
Stream skipMethod = monstersList.stream()
    .sorted(Comparator.comparing(Monsters::getDef))
    .skip(4);
````

<br>

7. **min() & max()** -> Used to return the smallest or biggest value on the entire list or specific elements.

````java
/// Comparing specifics through the ATK param
String compareSpecificStream = monstersList.stream()
        .filter(m -> m.getName().equals("Werewolf") || m.getName().equals("Mummy"))
        .max(Comparator.comparing(Monsters::getAtk))
        .map(m -> m.getName() + " wins!")
        .orElse("Draw");

System.out.println(compareSpecificStream);
````
<br>

## 💡 Best Practices and Learnings

- **Method Reference (System.out::println)**: An elegant way to write simple lambdas, passing the method reference directly.

- **Ordem importa:** Performing a *map()* before a *distinct()* can completely change the result, as we saw when comparing entire objects vs. comparing only names.

- **Streams are unic:** Once a terminal operation is executed (such as forEach), the Stream is closed and cannot be reused.

<br>

## 📝 Example of a "complete Stream"

````java
monstersList.stream()
    .filter(m -> m.getAtk() > 10)
    .sorted(Comparator.comparing(Monsters::getAtk).reversed())
    .distinct()
    .skip(1)
    .limit(3)
    .map(m -> "Rank: " + m.getName())
    .forEach(System.out::println);

````
