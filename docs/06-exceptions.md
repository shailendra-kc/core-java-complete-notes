# 6. Exception Handling

## Hierarchy

```text
Throwable
├── Error
└── Exception
    ├── RuntimeException
    └── Checked exceptions
```

Errors generally represent serious runtime conditions applications should not normally attempt to recover from.

## Checked vs unchecked

- Checked exceptions must be caught or declared.
- Unchecked exceptions extend `RuntimeException` and usually represent programming errors, invalid state or violated preconditions.

Choose based on whether callers can reasonably recover and whether forced handling improves the API.

## `throw` vs `throws`

- `throw` creates/raises a specific exception.
- `throws` declares possible checked exceptions in a method signature.

## Try-with-resources

Use for `AutoCloseable` resources.

```java
try (BufferedReader reader = Files.newBufferedReader(path)) {
    return reader.readLine();
}
```

Resources close in reverse order. Exceptions during closing become suppressed exceptions if another exception is already being thrown.

## `finally`

`finally` normally executes whether or not an exception occurs, but not under every JVM termination condition. Avoid returning from `finally` because it can hide exceptions and earlier returns.

## Exception translation

Convert low-level exceptions into meaningful domain exceptions while preserving the cause.

```java
catch (SQLException ex) {
    throw new OrderPersistenceException("Unable to save order", ex);
}
```

## Best practices

- Catch the most specific exception you can handle.
- Add meaningful context.
- Preserve the original cause.
- Do not use exceptions for normal control flow.
- Never silently swallow failures.
- Keep cleanup deterministic.
- Design custom exceptions around domain semantics, not implementation details.

## Overriding rule

An overriding method cannot declare broader checked exceptions than the parent method. It may declare narrower checked exceptions or unchecked exceptions.

## Common interview questions

- Can we have `try` without `catch`? Yes, with `finally` or try-with-resources.
- Can `finally` change a return value? It can, but doing so is dangerous and should be avoided.
- What are suppressed exceptions? Secondary failures retained when resource closing fails during another exception.
