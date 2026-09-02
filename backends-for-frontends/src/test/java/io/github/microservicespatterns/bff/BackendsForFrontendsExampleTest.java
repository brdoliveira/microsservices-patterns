package io.github.microservicespatterns.bff;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class BackendsForFrontendsExampleTest {
  @Test
  void returnsDifferentShapesForMobileAndWeb() {
    BackendsForFrontendsExample example = new BackendsForFrontendsExample();

    BackendsForFrontendsExample.MobileProduct mobile = example.mobileProduct("p-1");
    BackendsForFrontendsExample.WebProduct web = example.webProduct("p-1");

    assertEquals("p-1", mobile.id());
    assertTrue(mobile.buyButtonVisible());
    assertEquals("Office supplies", web.category());
    assertEquals("Ships today", web.shippingMessage());
  }
}
