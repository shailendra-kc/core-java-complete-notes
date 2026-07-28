# 4. Collections Framework

## Core hierarchy

```text
Iterable
  Collection
    List
    Set
    Queue / Deque
  Map (separate hierarchy)
```

## ArrayList

Backed by a resizable array.

- Indexed access: O(1)
- Append: amortized O(1)
- Insert/remove in middle: O(n)
- Not thread-safe

Capacity grows when needed; the exact growth policy is an implementation detail.

## LinkedList

Doubly linked list implementing both `List` and `Deque`.

- End insertion/removal: O(1)
- Random access: O(n)
- Higher per-element memory and poor cache locality

In real applications, `ArrayList` is usually preferable unless deque operations are central.

## HashMap internals

1. Compute/spread the key hash.
2. Map it to a bucket index based on table size.
3. Search the bucket using hash and `equals()`.
4. Store entries in a linked structure; heavily collided buckets may become balanced trees.
5. Resize when size crosses the load-factor threshold.

Average lookup is O(1); worst-case behavior depends on collisions and treeification.

Important points:

- One null key is supported.
- Multiple null values are supported.
- Iteration order is unspecified.
- It is not safe for unsynchronized concurrent modification.

## LinkedHashMap

Maintains insertion order or access order. Access-order mode is useful for LRU-like caches by overriding `removeEldestEntry`.

## TreeMap

Red-black tree sorted by natural ordering or a comparator.

- Search, insert, remove: O(log n)
- Supports range queries and navigation methods
- Comparator must be consistent with equality when map semantics require it

## HashSet

Typically implemented using a backing `HashMap`, storing elements as keys with a shared dummy value.

## TreeSet

Sorted set backed by a tree. Equality for set membership follows comparison result rather than `equals()` alone.

## PriorityQueue

Heap-based priority queue. The head is the smallest element under the chosen ordering. Iteration does not return globally sorted order.

## ArrayDeque

Efficient stack and queue implementation. Prefer it over legacy `Stack`. It does not permit null elements.

## Fail-fast iterators

Many collection iterators detect structural modification and may throw `ConcurrentModificationException`. This is a best-effort bug detector, not a concurrency guarantee.

Use `Iterator.remove()` for supported in-loop removal.

## ConcurrentHashMap

Designed for concurrent access without locking the entire map for ordinary operations. It disallows null keys and values, avoiding ambiguity in concurrent reads.

Atomic compound operations include:

```java
map.putIfAbsent(key, value);
map.computeIfAbsent(key, this::load);
map.merge(key, 1, Integer::sum);
```

## Complexity summary

| Structure | Get/Search | Insert | Ordered |
|---|---:|---:|---|
| ArrayList | O(1) by index | Amortized O(1) append | Insertion |
| HashMap/HashSet | Average O(1) | Average O(1) | No |
| TreeMap/TreeSet | O(log n) | O(log n) | Sorted |
| PriorityQueue | O(n) arbitrary search | O(log n) | Heap head only |

## Interview traps

- `Arrays.asList()` is fixed-size and backed by the original array.
- `List.of()` is unmodifiable and rejects null.
- `Collections.unmodifiableList()` is a view; underlying mutations remain visible.
- `subList()` is a view and may retain the original list.
- A comparator returning inconsistent results can silently lose elements in sorted sets/maps.
