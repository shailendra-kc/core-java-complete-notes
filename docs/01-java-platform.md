# 1. Java Platform and Language Fundamentals

## JDK, JRE and JVM

- **JVM** executes Java bytecode and provides memory management, class loading, verification and runtime services.
- **JRE** historically meant JVM plus runtime libraries required to run applications.
- **JDK** contains development tools such as `javac`, `java`, `javadoc`, `jdb` and packaging utilities.

Modern Java distributions commonly ship modular runtime images rather than a separately installed public JRE.

## Compilation and execution

```text
Source (.java) -> javac -> Bytecode (.class) -> Class Loader -> JVM -> Machine code
```

The interpreter can execute bytecode immediately. Frequently executed code may be compiled to native machine code by the Just-In-Time compiler.

## Why Java is platform independent

Compiled bytecode targets the JVM specification rather than a particular operating system. A compatible JVM implements the platform-specific execution layer.

## Primitive and reference types

Java has eight primitive types: `byte`, `short`, `int`, `long`, `float`, `double`, `char`, and `boolean`.

A reference variable stores a reference to an object, not the object itself. Java is always pass-by-value: for object arguments, the copied value is the reference.

```java
void reassign(Person person) {
    person = new Person("New"); // caller's reference is unchanged
}

void mutate(Person person) {
    person.setName("Changed"); // referenced object is changed
}
```

## Stack and heap

- Each thread has its own stack containing frames, local variables and method-call state.
- Objects normally live on the heap, which is shared across threads.
- Class metadata is stored in Metaspace.

These are conceptual rules; JVM optimizations such as escape analysis can remove allocations or scalar-replace objects.

## `final`, `finally` and `finalize`

- `final`: prevents reassignment, overriding or inheritance depending on context.
- `finally`: cleanup block associated with `try`/`catch`.
- `finalize()`: deprecated and unreliable object-finalization mechanism; do not use it.

## Static members

A static field belongs to the class, not an individual object. Static methods do not have `this` and cannot directly access instance state.

Static initialization occurs when a class is initialized, generally on first active use.

## Access modifiers

| Modifier | Same class | Same package | Subclass outside package | Everywhere |
|---|---:|---:|---:|---:|
| `private` | Yes | No | No | No |
| package-private | Yes | Yes | No | No |
| `protected` | Yes | Yes | Yes | No |
| `public` | Yes | Yes | Yes | Yes |

## Overloading vs overriding

- Overloading: same method name with different parameter lists; resolved at compile time.
- Overriding: subclass supplies a compatible implementation; resolved dynamically at runtime.

Return type alone cannot overload a method. A covariant return type is allowed when overriding.

## Important interview questions

1. Is Java pass-by-reference? No, Java is strictly pass-by-value.
2. Can a constructor be final or static? No.
3. Can static methods be overridden? They are hidden, not overridden polymorphically.
4. Why is `main` static? The JVM can call it without creating an application object.
5. What is bytecode verification? Validation that loaded bytecode follows JVM safety rules.
