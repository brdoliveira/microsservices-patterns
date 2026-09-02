package io.github.microservicespatterns.apigateway;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Map;
import org.junit.jupiter.api.Test;

class ApiGatewayExampleTest {
  @Test
  void routesPublicPathToInternalService() {
    ApiGatewayExample gateway =
        new ApiGatewayExample(Map.of("/orders", "order-service", "/customers", "customer-service"));

    assertEquals("order-service", gateway.route("/orders/123"));
    assertEquals("customer-service", gateway.route("/customers/77"));
  }

  @Test
  void rejectsUnknownRoutes() {
    ApiGatewayExample gateway = new ApiGatewayExample(Map.of("/orders", "order-service"));

    assertThrows(IllegalArgumentException.class, () -> gateway.route("/payments"));
  }
}
