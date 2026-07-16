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
 */
public final class AsyncTask {
    private static final AtomicLong TASK_COUNTER = new AtomicLong();
    private static final ExecutorService EXECUTOR = Executors.newVirtualThreadPerTaskExecutor();

    private AsyncTask() {
    }

    public static CompletableFuture<Void> runAsync(Runnable runnable) {
        Objects.requireNonNull(runnable, "runnable");
        return CompletableFuture.runAsync(runnable, EXECUTOR);
    }

    public static <T> CompletableFuture<T> supplyAsync(Supplier<T> supplier) {
        Objects.requireNonNull(supplier, "supplier");
        return CompletableFuture.supplyAsync(supplier, EXECUTOR);
    }

    public static ThreadFactory namingThreadFactory(String prefix) {
        String safePrefix = prefix == null || prefix.isBlank() ? "tavall-async" : prefix;
        return runnable -> Thread.ofVirtual().name(safePrefix + "-" + TASK_COUNTER.incrementAndGet()).unstarted(runnable);
    }

    public static void shutdown() {
        EXECUTOR.shutdown();
    }
}

