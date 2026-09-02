package io.github.microservicespatterns.circuitbreaker;

import java.util.function.Supplier;
import org.springframework.stereotype.Service;

/**
 * Demonstrates a minimal circuit breaker for protecting remote calls.
 */
@Service
public class CircuitBreakerExample {
  private final int failureThreshold;
  private int failures;
  private boolean open;

  /**
   * Creates a circuit breaker with a consecutive failure threshold.
   *
   * @param failureThreshold number of failures needed to open the circuit
   */
  public CircuitBreakerExample(int failureThreshold) {
    this.failureThreshold = failureThreshold;
  }

  /**
   * Executes a protected call while the circuit is closed.
   *
   * @param action remote operation to execute
   * @return operation result
   */
  public String call(Supplier<String> action) {
    if (open) {
      return "fallback";
    }
    try {
      String result = action.get();
      failures = 0;
      return result;
    } catch (RuntimeException error) {
      failures++;
      if (failures >= failureThreshold) {
        open = true;
      }
      return "fallback";
    }
  }

  /**
   * Reports whether the circuit is open.
   *
   * @return true when calls are being short-circuited
   */
  public boolean isOpen() {
    return open;
  }
}
