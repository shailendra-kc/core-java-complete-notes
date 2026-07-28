# 5. Generics

Generics provide compile-time type safety and reusable algorithms without explicit casts.

```java
List<String> names = new ArrayList<>();
```

## Invariance

`List<Integer>` is not a subtype of `List<Number>`. Otherwise a `Double` could be inserted into a list intended only for integers.

## Wildcards

- `? extends T`: producer of T values; read safely as T, generally do not add.
- `? super T`: consumer of T values; can add T, reads are only safely Object.

This is the PECS rule: **Producer Extends, Consumer Super**.

```java
static double sum(List<? extends Number> values) { ... }
static void addDefaults(List<? super Integer> values) { ... }
```

## Generic methods

```java
static <T> T first(List<T> values) {
    return values.get(0);
}
```

The type parameter appears before the return type.

## Bounded type parameters

```java
<T extends Comparable<? super T>> T max(List<T> values)
```

Multiple bounds place the class first: `<T extends Base & Runnable & Serializable>`.

## Type erasure

Most generic type information is removed or transformed during compilation. This preserves binary compatibility with pre-generics Java.

Consequences:

- Cannot write `new T()` directly.
- Cannot create `new T[10]` safely.
- Cannot use primitives as type arguments.
- Cannot overload only by generic parameterization due to same erasure.
- `instanceof List<String>` is not allowed.

## Raw types

Raw types disable generic safety and can cause heap pollution. Use them only when integrating unavoidable legacy APIs.

## Generic array issue

Arrays are covariant and reified; generics are invariant and erased. Mixing them would undermine runtime type guarantees.

## Interview example

Why can `List<? extends Number>` not accept an `Integer`? The actual list might be `List<Double>`, so adding an integer would violate its concrete element type.
