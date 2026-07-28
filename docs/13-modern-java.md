# 13. Modern Java Features

## Records

Records provide concise data carriers with final components, generated accessors, constructor, `equals`, `hashCode` and `toString`.

```java
record Employee(String id, String name) {
    Employee {
        Objects.requireNonNull(id);
        Objects.requireNonNull(name);
    }
}
```

Records are shallowly immutable: referenced mutable objects can still change.

## Sealed classes

Sealed hierarchies restrict permitted subclasses, making domain models and exhaustive pattern handling safer.

```java
sealed interface Payment permits CardPayment, BankTransfer {}
```

## Pattern matching

Pattern matching reduces manual casts and supports clearer conditional logic.

```java
if (value instanceof String text) {
    System.out.println(text.length());
}
```

Modern switch supports expressions and pattern-oriented branching depending on the Java version.

## Text blocks

Text blocks simplify multiline strings while preserving readable formatting.

## `var`

Local-variable type inference reduces repetition when the inferred type remains obvious. It does not make Java dynamically typed and cannot be used for fields, parameters or method return types.

## Date and Time API

Prefer `java.time` over legacy `Date` and `Calendar`.

- `Instant`: point on UTC timeline.
- `LocalDateTime`: date/time without zone.
- `ZonedDateTime`: date/time with time zone.
- `Duration`: time-based amount.
- `Period`: date-based amount.

Persist instants for events and preserve zone information when business meaning depends on local time.

## Modules

The module system provides explicit dependencies and stronger encapsulation. It is valuable for large modular applications but not mandatory for every service.

## Virtual threads

Modern Java supports lightweight virtual threads, useful for high-concurrency workloads dominated by blocking I/O. They simplify thread-per-request programming but do not make CPU-bound code faster and do not remove downstream capacity limits.
