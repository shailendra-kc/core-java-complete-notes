# 7. Lambdas and Functional Interfaces

A functional interface has exactly one abstract method. Methods inherited from `Object`, default methods and static methods do not increase that count.

```java
@FunctionalInterface
interface Transformer<T, R> {
    R apply(T value);
}
```

## Standard functional interfaces

- `Predicate<T>`: T -> boolean
- `Function<T,R>`: T -> R
- `Consumer<T>`: T -> void
- `Supplier<T>`: () -> T
- `UnaryOperator<T>`: T -> T
- `BinaryOperator<T>`: (T,T) -> T

Primitive specializations such as `IntPredicate` reduce boxing.

## Lambda capture

Lambdas may capture local variables only when they are final or effectively final. Captured instance fields may be mutated, but thread-safety remains the programmer's responsibility.

## Lambda vs anonymous class

- `this` in a lambda refers to the enclosing instance.
- `this` in an anonymous class refers to the anonymous object.
- Lambdas are intended to represent behavior, not a new object-oriented subtype with identity.

## Method references

```java
String::trim
System.out::println
Employee::new
employee::getName
```

Use method references when they improve readability; do not force them when they obscure arguments.

## Function composition

```java
Predicate<String> valid = nonBlank.and(shortEnough);
Function<String, String> normalize = String::trim;
```

`andThen` applies the current function first; `compose` applies the supplied function first.

## Interview traps

- A lambda cannot capture a reassigned local variable.
- Overloaded methods combined with lambdas can create ambiguous type inference.
- Side effects in functional pipelines reduce clarity and can break parallel execution.
