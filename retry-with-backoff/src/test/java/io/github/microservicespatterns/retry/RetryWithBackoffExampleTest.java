package io.github.microservicespatterns.retry;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import org.junit.jupiter.api.Test;

class RetryWithBackoffExampleTest {
  @Test
  void retriesWithGrowingDelaysUntilSuccess() {
    List<Long> delays = new ArrayList<>();
    AtomicInteger attempts = new AtomicInteger();
    RetryWithBackoffExample retry = new RetryWithBackoffExample(delays::add);

    String result =
        retry.execute(
            () -> {
              if (attempts.incrementAndGet() < 3) {
                throw new IllegalStateException("temporary failure");
              }
              return "success";
            },
            4,
            100);

    assertEquals("success", result);
    assertEquals(List.of(100L, 200L), delays);
    assertEquals(3, attempts.get());
  }
}
