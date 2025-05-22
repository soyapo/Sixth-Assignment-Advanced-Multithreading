# Report.md

## 1. Atomic Variables

### What output do you get from the program? Why?

You usually get something like:

```
Atomic Counter: 2000000  
Normal Counter: (some number less than 2000000)
```

The **atomicCounter** gives the correct result because `AtomicInteger` handles multiple threads safely. The **normalCounter** is often wrong because `normalCounter++` is not thread-safe — it can lose updates when both threads run at the same time.

### What is the purpose of AtomicInteger in this code?

It makes sure the counter increases correctly even when many threads are running. It avoids race conditions by using atomic operations.

### What thread-safety guarantees does `incrementAndGet()` provide?

It makes sure that every increment is done fully and correctly, even if other threads are doing the same thing at the same time. It uses a method called **compare-and-swap** under the hood to do this safely without locks.

### When is using a lock better than an atomic variable?

Use a lock when:

* You need to update multiple variables at once.
* The operation is complex.
* You need features like fairness or reentrancy.

### What other atomic types are in `java.util.concurrent.atomic`?

Other useful atomic types include:

* `AtomicBoolean`, `AtomicLong`
* `AtomicIntegerArray`, `AtomicLongArray`
* `AtomicReference`, `AtomicReferenceArray`
* `AtomicStampedReference`, `AtomicMarkableReference`
* Field updaters like `AtomicIntegerFieldUpdater`

These help write safe multithreaded code without using locks.

---

Thanks for the clarification — here's the direct and concise answer you can include in your `Report.md` file based on those **specific** questions:

---

# MonteCarlo PI

**Q: Was the multi-threaded implementation always faster than the single-threaded one?**
**A:**
No, the multi-threaded implementation is not *always* faster than the single-threaded one.

---

**Q: If not, what factors are the cause and what can you do to mitigate these issues?**
**A:**
The performance of the multi-threaded version depends on several factors:

1. **Thread Overhead:** For smaller workloads (e.g., a low number of points), the overhead of creating threads, context switching, and collecting results can outweigh the benefits of parallel execution.

2. **CPU Limitations:** If the number of threads exceeds or does not match the number of available CPU cores, threads may compete for resources, reducing performance gains.

3. **Random Number Generation:** Each thread uses its own instance of `Random`, which is not thread-safe or optimized for high-speed parallel usage. Shared or poor RNG performance can become a bottleneck.

**Mitigation Strategies:**

* Use multi-threading only for large enough workloads (e.g., millions of points).
* Match the number of threads to the number of logical CPU cores.
* Use more efficient random number generators like `ThreadLocalRandom` for parallel tasks.
* Reuse thread pools and avoid repeated creation of executors in real-world applications.

---
