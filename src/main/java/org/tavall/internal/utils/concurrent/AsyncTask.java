package org.tavall.internal.utils.concurrent;

import java.util.Objects;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicLong;
import java.util.function.Supplier;

/**
 * Shared async task runner for off-thread Tavall work.
 *
 * <p>Tasks are executed on a shared virtual-thread-per-task executor. Returned futures retain the
 * normal {@link CompletableFuture} completion and exception semantics of the submitted action.</p>
 */
public final class AsyncTask {
    private static final AtomicLong TASK_COUNTER = new AtomicLong();
    private static final ExecutorService EXECUTOR = Executors.newVirtualThreadPerTaskExecutor();

    private AsyncTask() {
    }

    /**
     * Executes a non-returning task on the shared virtual-thread executor.
     *
     * @param runnable work to execute asynchronously
     * @return a future completed when the task finishes, or completed exceptionally when it fails
     * @throws NullPointerException if {@code runnable} is {@code null}
     */
    public static CompletableFuture<Void> runAsync(Runnable runnable) {
        Objects.requireNonNull(runnable, "runnable");
        return CompletableFuture.runAsync(runnable, EXECUTOR);
    }

    /**
     * Executes a value-producing task on the shared virtual-thread executor.
     *
     * @param supplier work that produces the future result
     * @param <T> result type produced by the supplier
     * @return a future containing the supplied value, or completed exceptionally when the task fails
     * @throws NullPointerException if {@code supplier} is {@code null}
     */
    public static <T> CompletableFuture<T> supplyAsync(Supplier<T> supplier) {
        Objects.requireNonNull(supplier, "supplier");
        return CompletableFuture.supplyAsync(supplier, EXECUTOR);
    }

    /**
     * Creates a virtual-thread factory that assigns monotonically numbered task names.
     *
     * <p>A null or blank prefix falls back to {@code tavall-async}. Threads returned by the factory
     * are unstarted so the caller retains control over when execution begins.</p>
     *
     * @param prefix name prefix to use for created threads
     * @return factory that creates unstarted named virtual threads
     */
    public static ThreadFactory namingThreadFactory(String prefix) {
        String safePrefix = prefix == null || prefix.isBlank() ? "tavall-async" : prefix;
        return runnable -> Thread.ofVirtual().name(safePrefix + "-" + TASK_COUNTER.incrementAndGet()).unstarted(runnable);
    }

    /**
     * Initiates an orderly shutdown of the shared executor.
     *
     * <p>Previously submitted tasks are allowed to finish. New submissions through this class fail
     * according to the executor's normal shutdown behavior after this method is invoked.</p>
     */
    public static void shutdown() {
        EXECUTOR.shutdown();
    }
}
