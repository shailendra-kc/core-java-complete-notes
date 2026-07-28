# 10. Concurrency Utilities

## ExecutorService

Executors separate task submission from thread management.

```java
ExecutorService pool = Executors.newFixedThreadPool(8);
try {
    Future<Result> future = pool.submit(task);
    Result result = future.get();
} finally {
    pool.shutdown();
}
```

In production, configure `ThreadPoolExecutor` explicitly when queue capacity, rejection policy and observability matter.

## Thread-pool sizing

- CPU-bound work: near the number of available cores.
- I/O-bound work: potentially more threads because tasks spend time waiting.

The correct size depends on wait/compute ratio, latency targets, memory and downstream limits. Measure under realistic load.

## Rejection policies

When both pool and queue are saturated, policies can abort, run in caller thread, discard, or discard the oldest queued task. `CallerRunsPolicy` can provide backpressure by slowing producers.

## Future and CompletableFuture

`Future` represents a pending result but offers limited composition.

`CompletableFuture` supports asynchronous pipelines:

```java
CompletableFuture<User> user = supplyAsync(this::loadUser, executor);
CompletableFuture<Orders> orders = supplyAsync(this::loadOrders, executor);
return user.thenCombine(orders, UserSummary::new)
           .exceptionally(this::fallback);
```

- `thenApply`: synchronous transformation.
- `thenCompose`: asynchronous flatMap.
- `thenCombine`: combine independent futures.
- `handle`: process success or failure.
- `exceptionally`: recover from failure.

Specify an executor for blocking or application-critical work rather than relying blindly on the common pool.

## Locks

`ReentrantLock` supports interruptible acquisition, timed attempts, fairness options and multiple conditions. Always unlock in `finally`.

`ReadWriteLock` can improve read-heavy workloads, but overhead may outweigh benefits for short operations.

`StampedLock` supports optimistic reads but is not reentrant and requires careful validation.

## Atomic classes

Atomic classes use lock-free operations such as compare-and-set for individual variables.

`LongAdder` scales better than `AtomicLong` under heavy contention for statistics, but `sum()` is not an atomic snapshot combined with concurrent updates.

## Synchronizers

- `CountDownLatch`: wait for a fixed number of events; one-shot.
- `CyclicBarrier`: threads meet repeatedly at a barrier.
- `Semaphore`: limit concurrent access to a finite resource.
- `Phaser`: flexible multi-phase coordination.

## BlockingQueue

Ideal for producer-consumer systems. It provides blocking `put` and `take`, built-in visibility guarantees and optional bounded capacity for backpressure.

## ForkJoinPool

Designed for divide-and-conquer tasks using work stealing. Best for recursively splittable CPU-bound workloads.

## Concurrent collection choices

- `ConcurrentHashMap`: concurrent key-value access.
- `CopyOnWriteArrayList`: reads greatly outnumber writes and snapshots are useful.
- `ConcurrentLinkedQueue`: non-blocking queue.
- `BlockingQueue`: coordination and backpressure.
