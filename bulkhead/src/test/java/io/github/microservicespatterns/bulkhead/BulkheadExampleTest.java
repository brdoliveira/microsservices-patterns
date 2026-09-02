package io.github.microservicespatterns.bulkhead;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class BulkheadExampleTest {
  @Test
  void executesOperationWhenPermitIsAvailable() {
    BulkheadExample bulkhead = new BulkheadExample(1);

    assertEquals("accepted", bulkhead.execute(() -> "accepted"));
  }

  @Test
  void rejectsOperationWhenNoPermitIsAvailable() {
    BulkheadExample bulkhead = new BulkheadExample(0);

    assertEquals("rejected", bulkhead.execute(() -> "accepted"));
  }
}
