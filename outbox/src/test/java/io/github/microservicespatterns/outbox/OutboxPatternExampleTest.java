package io.github.microservicespatterns.outbox;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class OutboxPatternExampleTest {
  @Test
  void storesAggregateAndOutboxMessageTogether() {
    OutboxPatternExample example = new OutboxPatternExample();

    OutboxPatternExample.OutboxMessage message = example.createOrder("order-123");

    assertTrue(example.hasOrder("order-123"));
    assertEquals("OrderCreated", message.type());
    assertEquals(1, example.unpublishedMessages().size());
  }

  @Test
  void removesMessageFromUnpublishedListAfterPublication() {
    OutboxPatternExample example = new OutboxPatternExample();
    OutboxPatternExample.OutboxMessage message = example.createOrder("order-123");

    example.markPublished(message.id());

    assertTrue(example.unpublishedMessages().isEmpty());
  }
}
