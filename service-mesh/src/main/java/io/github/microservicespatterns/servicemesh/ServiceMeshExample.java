package io.github.microservicespatterns.servicemesh;

import java.util.Map;
import java.util.function.Function;
import org.springframework.stereotype.Service;

/**
 * Demonstrates keeping service-to-service policies outside the business operation.
 */
@Service
public class ServiceMeshExample {
  private final Map<String, String> meshPolicies;

  /**
   * Creates an example with mesh-managed policies.
   *
   * @param meshPolicies policy names and values applied by the platform
   */
  public ServiceMeshExample(Map<String, String> meshPolicies) {
    this.meshPolicies = Map.copyOf(meshPolicies);
  }

  /**
   * Calls another service while business code stays unaware of mesh policy details.
   *
   * @param serviceName target service
   * @param client client used for the service call
   * @return response from the target service
   */
  public String call(String serviceName, Function<String, String> client) {
    return client.apply(serviceName);
  }

  /**
   * Reads a platform policy managed by the service mesh.
   *
   * @param name policy name
   * @return configured policy value
   */
  public String policy(String name) {
    return meshPolicies.get(name);
  }
}
