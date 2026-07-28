# 15. Java Interview Preparation

## Highest-priority questions

1. Explain `HashMap` internals and collision handling.
2. Explain the `equals`/`hashCode` contract.
3. ArrayList vs LinkedList.
4. HashMap vs ConcurrentHashMap.
5. `synchronized` vs `volatile` vs atomic classes.
6. How does the Java Memory Model guarantee visibility?
7. ExecutorService and thread-pool sizing.
8. CompletableFuture: `thenApply` vs `thenCompose`.
9. Checked vs unchecked exceptions.
10. Streams: `map` vs `flatMap`, reduce vs collect.
11. Why are strings immutable?
12. Heap, stack, Metaspace and GC roots.
13. How can Java have memory leaks?
14. Interface vs abstract class.
15. Composition vs inheritance.
16. Generics, wildcards and PECS.
17. Fail-fast vs weakly consistent iterators.
18. Deadlock prevention.
19. Immutable-class design.
20. Common design patterns used in Spring.

## Scenario-based questions

### A shared counter loses increments

`count++` is a read-modify-write sequence. Use synchronization, `AtomicLong`, or `LongAdder` depending on consistency and contention needs.

### HashMap lookup fails after key mutation

The mutation changed fields used by `hashCode()`/`equals()`. Use immutable keys.

### Parallel stream is slower

Possible causes: small input, expensive splitting/merging, blocking I/O, ordering constraints, shared state, or common-pool contention.

### Application memory grows despite GC

Investigate retained references, unbounded caches, listeners, ThreadLocal values, queues and class-loader leaks using heap dumps and allocation profiling.

### CompletableFuture tasks block the application

Blocking work may saturate the common ForkJoinPool. Use a dedicated bounded executor and enforce downstream limits/timeouts.

## Coding exercises

- LRU cache using LinkedHashMap
- Thread-safe bounded queue
- Producer-consumer with BlockingQueue
- Group and aggregate employees with streams
- Immutable domain object
- Custom generic stack
- Deadlock demonstration and fix
- CompletableFuture aggregation
- Word-frequency counter
- Comparator chain with null handling

## Seven-day plan

### Day 1
Java execution model, pass-by-value, OOP, SOLID, `equals` and `hashCode`.

### Day 2
Strings, immutability, wrappers, ArrayList, HashMap, sets, queues and complexity.

### Day 3
Generics, exceptions, lambdas, functional interfaces, streams and Optional.

### Day 4
Threads, synchronized, volatile, Java Memory Model, wait/notify and deadlocks.

### Day 5
Executors, locks, atomics, concurrent collections and CompletableFuture.

### Day 6
JVM memory, class loading, JIT, GC, diagnostics, reflection and serialization.

### Day 7
Modern Java, design patterns, mock interview and coding exercises.

## Answer framework

For each answer:

- Start with a precise definition.
- Explain internal mechanics.
- Give a small example.
- State complexity or thread-safety where relevant.
- Mention trade-offs and alternatives.
- Connect to a production use case.

## Final checklist

You are interview-ready when you can explain major topics without notes, write core examples from memory, identify common concurrency bugs, discuss trade-offs, and connect Java features to backend systems.
