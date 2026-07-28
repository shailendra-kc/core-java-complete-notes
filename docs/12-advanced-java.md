# 12. I/O, Serialization, Reflection and Annotations

## Byte vs character streams

- Byte streams: `InputStream` and `OutputStream` for binary data.
- Character streams: `Reader` and `Writer` for text using character encoding.

Always specify character sets explicitly, typically UTF-8.

## Buffered I/O

Buffering reduces expensive system calls. `Files` provides convenient NIO.2 APIs for paths, copying, walking directories and reading/writing data.

## NIO

NIO introduces buffers, channels and selectors. Selectors can multiplex many non-blocking channels on a small number of threads.

## Java serialization

Native `Serializable` is tightly coupled to class structure and has security and compatibility risks. Prefer explicit formats such as JSON, Protocol Buffers or Avro for service boundaries.

If used:

- Define `serialVersionUID` deliberately.
- Mark sensitive/non-serializable fields `transient`.
- Never deserialize untrusted input without strong controls.

## Reflection

Reflection inspects classes, fields, constructors, methods and annotations at runtime.

Frameworks use it for dependency injection, serialization, testing and mapping. Costs include reduced compile-time safety, access complexity and potential performance overhead.

## Annotations

Annotations supply metadata. Important meta-annotations:

- `@Target`
- `@Retention`
- `@Documented`
- `@Inherited`
- `@Repeatable`

Retention options are SOURCE, CLASS and RUNTIME.

## Custom annotation example

```java
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Audited {
    String action();
}
```

## Dynamic proxies

JDK proxies implement interfaces and route calls through an `InvocationHandler`. Bytecode-generation libraries can proxy concrete classes. Proxy-based frameworks may not intercept self-invocation because internal calls bypass the proxy.

## ClassLoader concerns

Loading the same class name through different class loaders can produce distinct runtime types. This matters in application servers, plugin systems and hot reload.
