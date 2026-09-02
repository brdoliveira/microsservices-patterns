package io.github.microservicespatterns.saga;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import org.junit.jupiter.api.Test;

class SagaExampleTest {
  @Test
  void recordsOrderedActionsAndCompensations() {
    SagaExample saga = new SagaExample();

    saga.addStep("reserve inventory", "release inventory");
    saga.addStep("charge customer", "refund customer");

    assertEquals(
        List.of(
            "reserve inventory -> compensate with release inventory",
            "charge customer -> compensate with refund customer"),
        saga.plan());
  }
}
