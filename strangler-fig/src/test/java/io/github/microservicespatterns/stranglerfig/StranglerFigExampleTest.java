package io.github.microservicespatterns.stranglerfig;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Set;
import org.junit.jupiter.api.Test;

class StranglerFigExampleTest {
  @Test
  void routesMigratedCapabilitiesToNewService() {
    StranglerFigExample router = new StranglerFigExample(Set.of("checkout"));

    assertEquals("new-service", router.route("checkout"));
    assertEquals("legacy-system", router.route("catalog"));
  }
}
