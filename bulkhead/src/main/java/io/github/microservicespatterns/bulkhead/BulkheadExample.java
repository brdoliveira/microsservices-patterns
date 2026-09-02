package io.github.microservicespatterns.bulkhead;

import java.util.concurrent.Semaphore;
import java.util.function.Supplier;
import org.springframework.stereotype.Service;

/**
 * Demonstrates resource isolation with a concurrency limit.
 */
@Service
public class BulkheadExample {
  private final Semaphore permits;

  /**
   * Creates a bulkhead with a fixed number of concurrent permits.
   *
   * @param maxConcurrentCalls maximum concurrent operations allowed
   */
  public BulkheadExample(int maxConcurrentCalls) {
    this.permits = new Semaphore(maxConcurrentCalls);
  }

  /**
   * Runs an operation only when a permit is available.
   *
   * @param operation operation isolated by the bulkhead
   * @return operation result or a rejection marker
   */
  public String execute(Supplier<String> operation) {
    if (!permits.tryAcquire()) {
      return "rejected";
    }
    try {
      return operation.get();
    } finally {
      permits.release();
    }
  }
}
