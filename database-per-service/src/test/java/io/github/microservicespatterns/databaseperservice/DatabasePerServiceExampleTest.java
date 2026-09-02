package io.github.microservicespatterns.databaseperservice;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Map;
import org.junit.jupiter.api.Test;

class DatabasePerServiceExampleTest {
  @Test
  void describesServiceDatabaseOwnership() {
    DatabasePerServiceExample example =
        new DatabasePerServiceExample(Map.of("orders", "orders-db"));

    assertEquals("orders owns orders-db", example.describeOwnership("orders"));
  }

  @Test
  void rejectsUnknownServiceOwnership() {
    DatabasePerServiceExample example =
        new DatabasePerServiceExample(Map.of("orders", "orders-db"));

    assertThrows(IllegalArgumentException.class, () -> example.describeOwnership("payments"));
  }
}
