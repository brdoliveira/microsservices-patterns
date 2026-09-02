package io.github.microservicespatterns.eventdriven;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import org.springframework.stereotype.Service;

/**
 * Demonstrates event publication to independent subscribers.
 */
@Service
public class EventDrivenArchitectureExample {
  private final List<Consumer<String>> subscribers = new ArrayList<>();

  /**
   * Registers a subscriber that reacts to published events.
   *
   * @param subscriber event consumer
   */
  public void subscribe(Consumer<String> subscriber) {
    subscribers.add(subscriber);
  }

  /**
   * Publishes an event to every registered subscriber.
   *
   * @param event domain event payload
   */
  public void publish(String event) {
    subscribers.forEach(subscriber -> subscriber.accept(event));
  }
}
