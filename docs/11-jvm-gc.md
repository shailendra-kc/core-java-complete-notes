# 11. JVM Internals and Garbage Collection

## Runtime memory areas

- Heap: objects and arrays; shared.
- Java stacks: per-thread frames, local variables and operand stacks.
- Metaspace: class metadata in native memory.
- PC register: current instruction per thread.
- Native method stack: native execution support.

## Object allocation

Most objects are allocated cheaply using thread-local allocation buffers. Escape analysis may eliminate allocations or locks when an object does not escape a method/thread.

## Class loading

Lifecycle:

1. Loading
2. Linking: verification, preparation and resolution
3. Initialization

Parent delegation normally asks the parent loader first, helping prevent duplicate core classes and improving safety.

## JIT compilation

The JVM interprets or compiles methods based on runtime profiling. Hot methods may be optimized with inlining, devirtualization and escape analysis. Assumptions can later be deoptimized.

## Garbage-collection roots

An object is reachable if a path exists from roots such as active thread stacks, static fields, JNI references and certain JVM internals.

Java can still have memory leaks when objects remain reachable unnecessarily through caches, listeners, ThreadLocal values or static collections.

## Generational hypothesis

Most objects die young. Generational collectors optimize by collecting young regions frequently and older objects less often.

## Common collectors

- Serial GC: simple, single-threaded collection for small workloads.
- Parallel GC: throughput-oriented parallel collection.
- G1: region-based collector balancing throughput and pause goals.
- ZGC and Shenandoah: low-pause collectors for large heaps and latency-sensitive applications.

Collector selection depends on JDK, heap size, throughput, latency goals and deployment environment.

## Strong, soft, weak and phantom references

- Strong: ordinary reference; prevents collection.
- Soft: may remain until memory pressure; unsuitable for deterministic caches.
- Weak: collected once only weakly reachable.
- Phantom: post-mortem cleanup coordination with `ReferenceQueue`; referent cannot be retrieved.

## StackOverflowError vs OutOfMemoryError

- Stack overflow often results from deep/unbounded recursion or huge stack frames.
- Out-of-memory can occur in heap, Metaspace, direct buffers, native threads or other native memory.

## Diagnosis basics

Useful tools and artifacts include thread dumps, heap dumps, Java Flight Recorder, `jcmd`, `jstack`, `jmap`, GC logs and profilers.

Always diagnose before tuning. Increasing heap can hide rather than solve retention problems.

## Interview questions

- Why can Java applications leak memory? Reachable but unused objects are not collectible.
- What is stop-the-world? Application threads pause for a JVM operation.
- Why is GC tuning workload-specific? Allocation rate, object lifetime, heap size and latency requirements differ.
