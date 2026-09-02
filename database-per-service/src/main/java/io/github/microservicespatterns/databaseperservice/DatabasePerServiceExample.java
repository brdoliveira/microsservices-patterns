package io.github.microservicespatterns.databaseperservice;

import java.util.Map;
import org.springframework.stereotype.Service;

/**
 * Demonstrates explicit ownership between services and their databases.
 */
@Service
public class DatabasePerServiceExample {
  private final Map<String, String> ownership;

  /**
   * Creates an ownership catalog for service databases.
   *
   * @param ownership service name to database name mapping
   */
  public DatabasePerServiceExample(Map<String, String> ownership) {
    this.ownership = Map.copyOf(ownership);
  }

  /**
   * Describes which database belongs to a service.
   *
   * @param serviceName service that owns data
   * @return ownership description
   */
  public String describeOwnership(String serviceName) {
    String database = ownership.get(serviceName);
    if (database == null) {
      throw new IllegalArgumentException("Unknown service " + serviceName);
    }
    return serviceName + " owns " + database;
  }
}
