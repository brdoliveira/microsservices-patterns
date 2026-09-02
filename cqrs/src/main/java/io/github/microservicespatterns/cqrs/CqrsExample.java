package io.github.microservicespatterns.cqrs;

import java.util.HashMap;
import java.util.Map;
import org.springframework.stereotype.Service;

/**
 * Demonstrates separate write and read operations for a small catalog.
 */
@Service
public class CqrsExample {
  private final Map<String, String> writeModel = new HashMap<>();
  private final Map<String, String> readModel = new HashMap<>();

  /**
   * Handles a command that changes the write model and projects the read model.
   *
   * @param id item identifier
   * @param description item description
   */
  public void createItem(String id, String description) {
    writeModel.put(id, description);
    readModel.put(id, "Item: " + description);
  }

  /**
   * Handles a query against the read model.
   *
   * @param id item identifier
   * @return text optimized for reading
   */
  public String findItem(String id) {
    return readModel.get(id);
  }
}
