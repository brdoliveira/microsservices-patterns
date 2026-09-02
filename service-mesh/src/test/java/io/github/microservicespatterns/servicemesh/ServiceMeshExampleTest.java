package io.github.microservicespatterns.servicemesh;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Map;
import org.junit.jupiter.api.Test;

class ServiceMeshExampleTest {
  @Test
  void keepsBusinessCallSeparateFromMeshPolicy() {
    ServiceMeshExample example =
        new ServiceMeshExample(Map.of("mtls", "STRICT", "timeout", "250ms"));

    assertEquals("response-from-orders", example.call("orders", service -> "response-from-" + service));
    assertEquals("STRICT", example.policy("mtls"));
    assertEquals("250ms", example.policy("timeout"));
  }
}
