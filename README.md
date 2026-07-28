# Core Java Complete Notes for Java Developer Interviews

A structured, interview-focused Core Java repository for backend and Java developer roles. It combines deep theory, practical examples, common traps, and concise revision checklists.

## What you will learn

- Java platform fundamentals: JDK, JRE, JVM, bytecode and class loading
- Object-oriented programming, SOLID principles and object contracts
- Strings, immutability, wrappers and value semantics
- Collections internals, complexity and concurrent collections
- Generics, wildcards, type erasure and PECS
- Exception handling and resource management
- Java 8+ lambdas, streams, collectors and Optional
- Multithreading, Java Memory Model, locks, executors and CompletableFuture
- JVM memory, garbage collection and performance basics
- Reflection, annotations, serialization and modern Java features
- Design patterns commonly asked in Java interviews
- Coding questions, scenario questions and model answers

## Study map

| Order | Topic | File |
|---:|---|---|
| 1 | Java platform and language basics | [01-java-platform.md](docs/01-java-platform.md) |
| 2 | OOP, SOLID and object contracts | [02-oop-solid.md](docs/02-oop-solid.md) |
| 3 | Strings, wrappers and immutability | [03-strings-immutability.md](docs/03-strings-immutability.md) |
| 4 | Collections framework | [04-collections.md](docs/04-collections.md) |
| 5 | Generics | [05-generics.md](docs/05-generics.md) |
| 6 | Exceptions | [06-exceptions.md](docs/06-exceptions.md) |
| 7 | Lambdas and functional interfaces | [07-lambdas.md](docs/07-lambdas.md) |
| 8 | Streams and Optional | [08-streams-optional.md](docs/08-streams-optional.md) |
| 9 | Multithreading fundamentals | [09-multithreading.md](docs/09-multithreading.md) |
| 10 | Concurrency utilities | [10-concurrency-utilities.md](docs/10-concurrency-utilities.md) |
| 11 | JVM internals and garbage collection | [11-jvm-gc.md](docs/11-jvm-gc.md) |
| 12 | I/O, serialization, reflection and annotations | [12-advanced-java.md](docs/12-advanced-java.md) |
| 13 | Modern Java features | [13-modern-java.md](docs/13-modern-java.md) |
| 14 | Design patterns | [14-design-patterns.md](docs/14-design-patterns.md) |
| 15 | Interview questions and revision plan | [15-interview-preparation.md](docs/15-interview-preparation.md) |

## Repository structure

```text
core-java-complete-notes/
├── README.md
├── pom.xml
├── docs/
│   ├── 01-java-platform.md
│   ├── 02-oop-solid.md
│   └── ...
└── src/
    ├── main/java/com/interview/corejava/
    └── test/java/com/interview/corejava/
```

## Run examples

Requirements: Java 17+ and Maven 3.9+.

```bash
mvn clean test
mvn exec:java
```

## Interview method

For every topic, prepare three levels of explanation:

1. **Definition:** explain it in one sentence.
2. **Mechanism:** explain how it works internally.
3. **Trade-off:** explain when to use it and when not to use it.

Example for `HashMap`:

- Definition: key-value collection with average O(1) lookup.
- Mechanism: hash spread, bucket index, equality check, linked list/tree bins and resizing.
- Trade-off: fast non-thread-safe lookup; use `ConcurrentHashMap` for concurrent access.

## Recommended seven-day revision

- Day 1: Java platform, OOP, Strings
- Day 2: Collections and Generics
- Day 3: Exceptions, Lambdas and Streams
- Day 4: Threads and Java Memory Model
- Day 5: Executors, locks and CompletableFuture
- Day 6: JVM, GC and advanced Java
- Day 7: Design patterns, mock interview and coding practice

## GitHub topics

`java`, `core-java`, `java-interview`, `collections`, `multithreading`, `concurrency`, `jvm`, `java-streams`, `design-patterns`, `interview-preparation`
