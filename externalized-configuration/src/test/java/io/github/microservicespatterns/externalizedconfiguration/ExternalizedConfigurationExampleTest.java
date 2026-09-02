package io.github.microservicespatterns.externalizedconfiguration;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Map;
import org.junit.jupiter.api.Test;

class ExternalizedConfigurationExampleTest {
  @Test
  void readsRequiredExternalConfigurationValue() {
    ExternalizedConfigurationExample configuration =
        new ExternalizedConfigurationExample(Map.of("timeout", "250ms"));

    assertEquals("250ms", configuration.required("timeout"));
  }

  @Test
  void rejectsMissingConfigurationValue() {
    ExternalizedConfigurationExample configuration =
        new ExternalizedConfigurationExample(Map.of("timeout", "250ms"));

    assertThrows(IllegalArgumentException.class, () -> configuration.required("retries"));
  }
}
