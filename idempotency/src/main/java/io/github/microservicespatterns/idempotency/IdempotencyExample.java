package io.github.microservicespatterns.idempotency;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;
import org.springframework.stereotype.Service;

/**
 * Demonstrates idempotent command handling by caching results per idempotency key.
 */
@Service
public class IdempotencyExample {
  private final Map<String, String> processedResults = new HashMap<>();

  /**
   * Handles a command once for each idempotency key.
   *
   * @param idempotencyKey client-provided idempotency key
   * @param command command that produces the result on first execution
   * @return cached or newly produced command result
   */
  public String handle(String idempotencyKey, Supplier<String> command) {
    return processedResults.computeIfAbsent(idempotencyKey, ignored -> command.get());
  }

  /**
   * Counts unique commands processed by this service.
   *
   * @return number of unique idempotency keys processed
   */
  public int processedCommandCount() {
    return processedResults.size();
  }
}
