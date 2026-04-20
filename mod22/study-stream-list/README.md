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

## 📚 Operations' Study (part I)

1. **filter()** -> Selects which elements should be processed and continue in the stream, based on a specific condition (predicate).

````java
List<User> list = new User().userList();

// It creates a "funnel" that only allows Brazilians to pass through
Stream<User> streamFilter = list.stream()
    .filter(user -> user.getNationality().equals("Brazil"));

````
<br>

2. **map()** -> Used to transform data or extract a specific attribute from the objects in the stream.

````java
// It transforms a Stream of 'User' objects into a Stream of 'Strings' (names)
Stream<String> streamMap = list.stream()
    .map(User::getName); 
````
<br>

**[CLICK HERE FOR CHECK PART II](https://github.com/fabioperettig/tarefas-ebac-Fabio-Peretti/blob/main/mod22/study-stream-comparing/README.md)**