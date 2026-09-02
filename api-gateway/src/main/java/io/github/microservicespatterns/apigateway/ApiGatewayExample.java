package io.github.microservicespatterns.apigateway;

import java.util.Map;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Demonstrates a small API Gateway that maps public routes to internal services.
 */
@RestController
public class ApiGatewayExample {
  private final Map<String, String> routes;

  /**
   * Creates a gateway with the route table used by external clients.
   *
   * @param routes map where the key is a public path prefix and the value is a service name
   */
  public ApiGatewayExample(Map<String, String> routes) {
    this.routes = Map.copyOf(routes);
  }

  /**
   * Resolves the internal service responsible for a public request path.
   *
   * @param path public request path
   * @return target service name
   */
  public String route(String path) {
    return routes.entrySet().stream()
        .filter(entry -> path.startsWith(entry.getKey()))
        .map(Map.Entry::getValue)
        .findFirst()
        .orElseThrow(() -> new IllegalArgumentException("No route for " + path));
  }

  /**
   * Resolves a route from an HTTP query parameter, mirroring a Spring controller endpoint.
   *
   * @param path public request path
   * @return target service name
   */
  @GetMapping("/gateway/route")
  public String routeRequest(@RequestParam String path) {
    return route(path);
  }
}
