package io.github.microservicespatterns.stranglerfig;

import java.util.Set;
import org.springframework.stereotype.Service;

/**
 * Demonstrates routing selected capabilities from a legacy system to a new service.
 */
@Service
public class StranglerFigExample {
  private final Set<String> migratedCapabilities;

  /**
   * Creates a router aware of already migrated capabilities.
   *
   * @param migratedCapabilities capabilities served by the new service
   */
  public StranglerFigExample(Set<String> migratedCapabilities) {
    this.migratedCapabilities = Set.copyOf(migratedCapabilities);
  }

  /**
   * Selects whether a capability should use the legacy or new service.
   *
   * @param capability requested capability
   * @return selected backend name
   */
  public String route(String capability) {
    return migratedCapabilities.contains(capability) ? "new-service" : "legacy-system";
  }
}
