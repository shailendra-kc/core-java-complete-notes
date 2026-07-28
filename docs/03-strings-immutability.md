# 3. Strings, Wrappers and Immutability

## Why `String` is immutable

String immutability enables safe sharing through the string pool, stable hash codes, thread safety and safer use in class loading, file paths and security-sensitive APIs.

Operations such as `concat()` return a new string.

## String pool

String literals are interned in a JVM-managed pool.

```java
String a = "java";
String b = "java";
String c = new String("java");

System.out.println(a == b);      // true
System.out.println(a == c);      // false
System.out.println(a.equals(c)); // true
```

`intern()` returns the canonical pooled representation, but indiscriminate use can increase memory pressure.

## `StringBuilder` vs `StringBuffer`

- `StringBuilder`: mutable, not synchronized, normally faster for local construction.
- `StringBuffer`: synchronized legacy alternative for shared mutable use.

For repeated concatenation in loops, use `StringBuilder` or collectors rather than creating many intermediate strings.

## Creating an immutable class

1. Make the class final or tightly control subclassing.
2. Keep fields private and final.
3. Validate state in the constructor.
4. Do not provide mutators.
5. Defensively copy mutable inputs and outputs.

```java
public final class EmployeeSnapshot {
    private final String name;
    private final List<String> skills;

    public EmployeeSnapshot(String name, List<String> skills) {
        this.name = Objects.requireNonNull(name);
        this.skills = List.copyOf(skills);
    }

    public List<String> skills() {
        return skills;
    }
}
```

`List.copyOf` creates an unmodifiable snapshot but assumes elements themselves are safe to share.

## Wrapper classes and autoboxing

Wrappers allow primitive-like values in generic collections. Autoboxing converts primitives to wrappers; unboxing does the reverse.

```java
Integer count = null;
int value = count; // NullPointerException during unboxing
```

## Integer cache

Small boxed integers are commonly cached. Never use `==` for wrapper value comparison.

```java
Integer x = 127;
Integer y = 127;
Integer p = 128;
Integer q = 128;
```

`x == y` may be true while `p == q` may be false. Use `Objects.equals` or unbox safely.

## BigDecimal

Use `BigDecimal` for decimal values requiring predictable precision, especially monetary calculations.

```java
BigDecimal total = new BigDecimal("19.99");
```

Construct from strings rather than binary floating-point values. Compare numeric value using `compareTo()` when scale differences should not matter.
