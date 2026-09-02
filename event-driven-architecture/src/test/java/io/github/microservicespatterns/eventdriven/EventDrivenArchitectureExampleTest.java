package io.github.microservicespatterns.eventdriven;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

class EventDrivenArchitectureExampleTest {
  @Test
  void publishesEventToIndependentSubscribers() {
    EventDrivenArchitectureExample eventBus = new EventDrivenArchitectureExample();
    List<String> auditEvents = new ArrayList<>();
    List<String> notificationEvents = new ArrayList<>();

    eventBus.subscribe(auditEvents::add);
    eventBus.subscribe(notificationEvents::add);
    eventBus.publish("OrderCreated");

    assertEquals(List.of("OrderCreated"), auditEvents);
    assertEquals(List.of("OrderCreated"), notificationEvents);
  }
}
