package io.github.microservicespatterns.servicediscovery;

import java.net.URI;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Service;

/**
 * Demonstrates a simple in-memory service registry for dynamic service lookup.
 */
@Service
public class ServiceDiscoveryExample {
  private final Map<String, List<URI>> registry = new HashMap<>();

  /**
   * Registers an instance endpoint for a service name.
   *
   * @param serviceName logical service name
   * @param endpoint concrete instance endpoint
   */
  public void register(String serviceName, URI endpoint) {
    registry.computeIfAbsent(serviceName, ignored -> new ArrayList<>()).add(endpoint);
  }

  /**
   * Finds one endpoint for the requested service.
   *
   * @param serviceName logical service name
   * @return the first registered endpoint for the service
   */
  public URI discover(String serviceName) {
    List<URI> endpoints = registry.getOrDefault(serviceName, List.of());
    if (endpoints.isEmpty()) {
      throw new IllegalArgumentException("No instance registered for " + serviceName);
    }
    return endpoints.get(0);
  }
}
