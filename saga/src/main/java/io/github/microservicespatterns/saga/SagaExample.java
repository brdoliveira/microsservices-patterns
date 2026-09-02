package io.github.microservicespatterns.saga;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 * Demonstrates a saga plan with local actions and compensating actions.
 */
@Service
public class SagaExample {
  private final List<String> steps = new ArrayList<>();

  /**
   * Adds a local transaction step and its compensation.
   *
   * @param action local transaction action
   * @param compensation action used to compensate the local transaction
   */
  public void addStep(String action, String compensation) {
    steps.add(action + " -> compensate with " + compensation);
  }

  /**
   * Returns the ordered saga plan.
   *
   * @return immutable ordered step descriptions
   */
  public List<String> plan() {
    return List.copyOf(steps);
  }
}
