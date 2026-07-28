# 9. Multithreading and Java Memory Model

## Process vs thread

A process has its own address space. Threads within a process share heap state but have independent stacks and execution paths.

## Creating work

Prefer representing work with `Runnable` or `Callable` and submitting it to an executor rather than creating raw threads for every task.

## Thread lifecycle

Common `Thread.State` values: NEW, RUNNABLE, BLOCKED, WAITING, TIMED_WAITING and TERMINATED.

`RUNNABLE` includes both running and ready-to-run states from the JVM perspective.

## Race condition

A race occurs when correctness depends on unpredictable interleaving of operations.

```java
count++; // read, add, write; not atomic
```

## `synchronized`

Provides mutual exclusion and memory visibility around the same monitor. Exiting a synchronized block happens-before a later entry on the same monitor.

Instance synchronized methods lock `this`; static synchronized methods lock the `Class` object.

## `volatile`

A volatile write happens-before a later volatile read of the same variable. It provides visibility and ordering but not atomicity for compound operations.

Good use: stop flags or publishing immutable state. Not enough for `count++`.

## Happens-before

The happens-before relation defines when one action's effects are guaranteed visible to another. Key examples:

- Monitor unlock before subsequent lock on the same monitor.
- Volatile write before subsequent volatile read.
- Actions before `Thread.start()` visible to the started thread.
- Completed thread actions visible after successful `join()`.

## `wait`, `notify`, `notifyAll`

These methods operate on an object's monitor and must be called while holding it.

Always wait in a loop:

```java
synchronized (queue) {
    while (queue.isEmpty()) {
        queue.wait();
    }
}
```

The loop handles spurious wakeups and rechecks the condition after competing consumers run.

## Deadlock

Deadlock commonly requires mutual exclusion, hold-and-wait, no preemption and circular wait.

Prevention techniques:

- Consistent lock ordering
- Smaller lock scope
- Timed `tryLock`
- Avoid nested locks
- Prefer higher-level concurrent utilities

## Starvation and livelock

- Starvation: a thread repeatedly fails to obtain CPU or a required lock.
- Livelock: threads remain active but keep responding to each other without progress.

## Safe publication

An object can be safely published through final fields after proper construction, static initialization, volatile references, locks, concurrent collections or thread-safe queues.
