package io.github.microservicespatterns.idempotency;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.concurrent.atomic.AtomicInteger;
import org.junit.jupiter.api.Test;

class IdempotencyExampleTest {
  @Test
  void returnsStoredResultWhenKeyIsRepeated() {
    IdempotencyExample example = new IdempotencyExample();
    AtomicInteger executions = new AtomicInteger();

    String first = example.handle("request-1", () -> "created-" + executions.incrementAndGet());
    String second = example.handle("request-1", () -> "created-" + executions.incrementAndGet());

    assertEquals("created-1", first);
    assertEquals("created-1", second);
    assertEquals(1, executions.get());
    assertEquals(1, example.processedCommandCount());
  }
}
