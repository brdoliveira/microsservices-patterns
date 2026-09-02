package io.github.microservicespatterns.externalizedconfiguration;

import java.util.Map;
import org.springframework.stereotype.Service;

/**
 * Demonstrates reading service configuration from an external source.
 */
@Service
public class ExternalizedConfigurationExample {
  private final Map<String, String> configuration;

  /**
   * Creates a configuration reader backed by external values.
   *
   * @param configuration external configuration key-value map
   */
  public ExternalizedConfigurationExample(Map<String, String> configuration) {
    this.configuration = Map.copyOf(configuration);
  }

  /**
   * Reads a required configuration value.
   *
   * @param key configuration key
   * @return configured value
   */
  public String required(String key) {
    String value = configuration.get(key);
    if (value == null || value.isBlank()) {
      throw new IllegalArgumentException("Missing configuration " + key);
    }
    return value;
  }
}
