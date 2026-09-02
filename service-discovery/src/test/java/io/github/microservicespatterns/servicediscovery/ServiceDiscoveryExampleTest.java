package io.github.microservicespatterns.servicediscovery;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.net.URI;
import org.junit.jupiter.api.Test;

class ServiceDiscoveryExampleTest {
  @Test
  void discoversRegisteredServiceInstance() {
    ServiceDiscoveryExample discovery = new ServiceDiscoveryExample();
    URI endpoint = URI.create("http://orders-1:8080");

    discovery.register("orders", endpoint);

    assertEquals(endpoint, discovery.discover("orders"));
  }

  @Test
  void rejectsUnknownServiceName() {
    ServiceDiscoveryExample discovery = new ServiceDiscoveryExample();

    assertThrows(IllegalArgumentException.class, () -> discovery.discover("payments"));
  }
}
