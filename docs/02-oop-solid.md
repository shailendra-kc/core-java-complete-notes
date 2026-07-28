# 2. OOP, SOLID and Object Contracts

## Encapsulation

Encapsulation protects an object's invariants by hiding mutable state and exposing controlled operations.

```java
final class BankAccount {
    private long balanceInCents;

    void withdraw(long amount) {
        if (amount <= 0 || amount > balanceInCents) {
            throw new IllegalArgumentException("Invalid amount");
        }
        balanceInCents -= amount;
    }
}
```

Getters and setters alone do not guarantee good encapsulation. The goal is behavior-focused APIs that preserve valid state.

## Abstraction

Abstraction exposes essential behavior while hiding implementation details. Interfaces are common abstraction boundaries.

## Inheritance

Inheritance models an `is-a` relationship. Use it only when subtype behavior satisfies the parent contract. Deep hierarchies increase coupling; composition is often safer.

## Polymorphism

A parent reference can point to different subtype objects. The selected overridden instance method depends on the runtime object.

## Interface vs abstract class

Use an interface for a capability or contract across unrelated types. Use an abstract class when subclasses share state, constructors or reusable protected behavior.

Interfaces can contain default, static and private methods, but instance fields are implicitly `public static final`.

## Composition over inheritance

Composition delegates work to contained objects and allows behavior to vary independently.

```java
class CheckoutService {
    private final PaymentProcessor paymentProcessor;

    CheckoutService(PaymentProcessor paymentProcessor) {
        this.paymentProcessor = paymentProcessor;
    }
}
```

## SOLID

- **Single Responsibility:** one reason to change.
- **Open/Closed:** extend behavior without repeatedly modifying stable code.
- **Liskov Substitution:** subtypes must honor base-type expectations.
- **Interface Segregation:** prefer focused interfaces over large forced contracts.
- **Dependency Inversion:** depend on abstractions, not volatile implementations.

## `equals()` and `hashCode()` contract

If two objects are equal, they must return the same hash code. Unequal objects may still collide.

`equals()` should be reflexive, symmetric, transitive, consistent and false for null.

Hash-based collections first use the hash code to find a bucket, then use equality to identify the key.

### Common failure

Using mutable fields in `hashCode()` can make an object unreachable in a `HashSet` after mutation because it now belongs logically to another bucket.

## `==` vs `equals()`

- For primitives, `==` compares values.
- For references, `==` compares object identity.
- `equals()` compares logical equality according to the class implementation.

## `clone()` concerns

`Object.clone()` performs a shallow field copy and introduces awkward contracts. Copy constructors, static factories or immutable objects are usually clearer.

## Interview scenarios

- A `Square` subclass of mutable `Rectangle` often violates Liskov substitution because setting width independently may alter height.
- A service depending directly on a database implementation violates dependency inversion and is difficult to test.
- A class responsible for validation, persistence, messaging and reporting has multiple reasons to change.
