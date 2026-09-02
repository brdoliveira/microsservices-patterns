package io.github.microservicespatterns.circuitbreaker;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class CircuitBreakerExampleTest {
  @Test
  void opensAfterConsecutiveFailuresAndReturnsFallback() {
    CircuitBreakerExample circuitBreaker = new CircuitBreakerExample(2);

    assertEquals("fallback", circuitBreaker.call(this::fail));
    assertEquals("fallback", circuitBreaker.call(this::fail));

    assertTrue(circuitBreaker.isOpen());
    assertEquals("fallback", circuitBreaker.call(() -> "remote-value"));
  }

  @Test
  void resetsFailureCountAfterSuccess() {
    CircuitBreakerExample circuitBreaker = new CircuitBreakerExample(2);

    assertEquals("fallback", circuitBreaker.call(this::fail));
    assertEquals("remote-value", circuitBreaker.call(() -> "remote-value"));
    assertEquals("fallback", circuitBreaker.call(this::fail));

    assertFalse(circuitBreaker.isOpen());
  }

  private String fail() {
    throw new IllegalStateException("remote failure");
  }
}
