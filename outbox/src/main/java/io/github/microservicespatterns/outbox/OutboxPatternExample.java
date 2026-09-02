package io.github.microservicespatterns.outbox;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import org.springframework.stereotype.Service;

/**
 * Demonstrates the Outbox pattern with an in-memory aggregate store and outbox table.
 */
@Service
public class OutboxPatternExample {
  private final List<String> orders = new ArrayList<>();
  private final List<OutboxMessage> outbox = new ArrayList<>();

  /**
   * Creates an order and stores the corresponding outbox message in the same local operation.
   *
   * @param orderId order identifier
   * @return stored outbox message
   */
  public OutboxMessage createOrder(String orderId) {
    orders.add(orderId);
    OutboxMessage message =
        new OutboxMessage(
            UUID.randomUUID().toString(), orderId, "OrderCreated", "{\"orderId\":\"" + orderId + "\"}", false);
    outbox.add(message);
    return message;
  }

  /**
   * Lists messages waiting to be published.
   *
   * @return unpublished outbox messages
   */
  public List<OutboxMessage> unpublishedMessages() {
    return outbox.stream().filter(message -> !message.published()).toList();
  }

  /**
   * Marks a message as published after the broker acknowledges it.
   *
   * @param messageId outbox message identifier
   */
  public void markPublished(String messageId) {
    for (int index = 0; index < outbox.size(); index++) {
      OutboxMessage message = outbox.get(index);
      if (message.id().equals(messageId)) {
        outbox.set(
            index,
            new OutboxMessage(
                message.id(), message.aggregateId(), message.type(), message.payload(), true));
        return;
      }
    }
  }

  /**
   * Checks whether the aggregate store contains an order.
   *
   * @param orderId order identifier
   * @return true when the order was stored
   */
  public boolean hasOrder(String orderId) {
    return orders.contains(orderId);
  }

  /**
   * Message persisted in the local outbox before publication.
   *
   * @param id message identifier
   * @param aggregateId aggregate that produced the event
   * @param type event type
   * @param payload serialized event payload
   * @param published publication marker
   */
  public record OutboxMessage(
      String id, String aggregateId, String type, String payload, boolean published) {}
}
