# 14. Design Patterns for Java Interviews

Patterns are reusable design ideas, not code templates to force everywhere.

## Singleton

Use for a single process-wide instance only when global lifetime is genuinely appropriate. Enum singleton is concise and serialization-safe.

```java
enum ApplicationRegistry { INSTANCE }
```

Dependency-injection containers often manage singleton scope more cleanly.

## Factory Method

Moves object creation behind a method or abstraction, reducing coupling to concrete constructors.

## Abstract Factory

Creates related families of objects without exposing concrete classes.

## Builder

Useful for objects with many optional fields, readable construction and validation.

## Strategy

Encapsulates interchangeable algorithms behind a common interface.

```java
interface PricingStrategy { Money calculate(Order order); }
```

Excellent replacement for growing conditional chains.

## Observer

Subscribers react to publisher events. Understand synchronous vs asynchronous delivery, ordering, failure isolation and unsubscription.

## Decorator

Adds behavior by wrapping an object while preserving its interface. Common in Java I/O and middleware chains.

## Adapter

Converts one interface into another expected by clients.

## Template Method

Base class fixes workflow skeleton while subclasses customize steps. Prefer strategy/composition when inheritance is unnecessary.

## Command

Represents an action as an object, enabling queues, retries, undo and audit trails.

## Proxy

Controls access to another object for security, caching, lazy loading, remote calls or transactions.

## Chain of Responsibility

Passes a request through ordered handlers. Common in servlet filters, Spring Security and validation pipelines.

## Repository

Abstracts persistence operations, but should not merely hide every possible database feature behind generic CRUD.

## Common interview discussion

Explain:

1. The problem the pattern solves.
2. Its participants.
3. A Java/framework example.
4. Its trade-offs.
5. A simpler alternative.
