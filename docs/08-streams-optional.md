# 8. Streams, Collectors and Optional

A stream is a lazy pipeline over a data source. It does not store elements and normally does not modify the source.

## Pipeline

```text
Source -> Intermediate operations -> Terminal operation
```

Intermediate operations such as `filter`, `map`, `sorted` and `distinct` are lazy. A terminal operation such as `collect`, `reduce`, `count` or `findFirst` triggers execution.

## `map` vs `flatMap`

- `map` transforms each element into one result.
- `flatMap` transforms each element into a stream and flattens nested streams.

## Stateless vs stateful operations

`map` and `filter` are stateless. `sorted` and `distinct` may need to retain information about multiple elements.

## Short-circuiting

Operations such as `limit`, `findFirst`, `anyMatch` and `allMatch` may finish without processing every element.

## Reduction

```java
int total = numbers.stream().reduce(0, Integer::sum);
```

The identity must be neutral, and the accumulator/combiner must be associative for correct parallel reduction.

## Collectors

Common collectors:

```java
Collectors.toList()
Collectors.toSet()
Collectors.joining(", ")
Collectors.groupingBy(Employee::department)
Collectors.partitioningBy(Employee::active)
Collectors.mapping(Employee::name, Collectors.toList())
Collectors.summarizingInt(Employee::age)
```

When using `toMap`, provide a merge function if duplicate keys are possible.

## Parallel streams

Parallel streams use the common ForkJoinPool by default. They can help for large CPU-bound, splittable, stateless workloads. They may hurt small tasks, blocking I/O, ordered pipelines, shared-state operations or environments where common-pool contention matters.

Always measure rather than assuming parallel is faster.

## Stream reuse

A stream is single-use. After a terminal operation, create a new stream.

## Optional

`Optional<T>` models a possibly absent return value.

Prefer:

```java
optional.map(...).filter(...).orElseGet(...)
```

Understand:

- `orElse(value)` evaluates its argument eagerly.
- `orElseGet(supplier)` computes lazily.
- `map` wraps a normal transformed value.
- `flatMap` avoids nested Optional values.

Avoid using Optional as a field, method parameter or collection element without a strong design reason. Do not call `get()` without proving presence.

## Interview exercises

- Group employees by department and find the highest-paid employee in each group.
- Find duplicate words using grouping and counting.
- Flatten orders into line items and calculate totals.
- Explain why mutating external state inside `forEach` is unsafe in parallel streams.
