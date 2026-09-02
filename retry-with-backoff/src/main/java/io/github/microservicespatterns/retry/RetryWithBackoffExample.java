package io.github.microservicespatterns.retry;

import java.util.function.Supplier;
import org.springframework.stereotype.Service;

/**
 * Demonstrates retries with exponential backoff for transient failures.
 */
@Service
public class RetryWithBackoffExample {
  private final Sleeper sleeper;

  /**
   * Creates a retry service with a no-op sleeper for tests and examples.
   */
  public RetryWithBackoffExample() {
    this(millis -> {});
  }

  /**
   * Creates a retry service with a custom sleeper.
   *
   * @param sleeper strategy used to wait between attempts
   */
  public RetryWithBackoffExample(Sleeper sleeper) {
    this.sleeper = sleeper;
  }

  /**
   * Executes an operation with exponential backoff between failed attempts.
   *
   * @param operation operation that may fail transiently
   * @param maxAttempts maximum number of attempts
   * @param initialDelayMillis first delay before retrying
   * @return operation result
   */
  public String execute(Supplier<String> operation, int maxAttempts, long initialDelayMillis) {
    RuntimeException lastFailure = null;
    for (int attempt = 1; attempt <= maxAttempts; attempt++) {
      try {
        return operation.get();
      } catch (RuntimeException error) {
        lastFailure = error;
        if (attempt < maxAttempts) {
          sleeper.sleep(initialDelayMillis * (1L << (attempt - 1)));
        }
      }
    }
    throw lastFailure;
  }

  /**
   * Strategy for waiting between retry attempts.
   */
  @FunctionalInterface
  public interface Sleeper {
    /**
     * Waits for the given delay.
     *
     * @param millis delay in milliseconds
     */
    void sleep(long millis);
  }
}
